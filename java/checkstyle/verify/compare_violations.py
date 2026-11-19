"""Compare checkstyle violations for the invalid samples with expected-violations.txt.

Run after `mvn -f java/checkstyle/verify/pom.xml clean verify`. Exits non-zero on any missing or unexpected violation.
Violations are counted, so the same check reported twice on one line must be listed twice in expected-violations.txt.
"""

import sys
import xml.etree.ElementTree as ET
from collections import Counter
from pathlib import Path

VERIFY_DIR = Path(__file__).resolve().parent
SOURCES_DIR = VERIFY_DIR / "src" / "invalid" / "java"
RESULT_FILE = VERIFY_DIR / "target" / "checkstyle-invalid.xml"
EXPECTED_FILE = VERIFY_DIR / "expected-violations.txt"


def check_name(source):
    # "com.puppycrawl.tools.checkstyle.checks.TodoCommentCheck#commentStartWithSpace" -> "TodoComment#commentStartWithSpace"
    name, _, module_id = source.rpartition(".")[2].partition("#")
    name = name.removesuffix("Check")
    return f"{name}#{module_id}" if module_id else name


def actual_violations():
    violations = Counter()
    for file in ET.parse(RESULT_FILE).getroot().iter("file"):
        path = Path(file.get("name")).resolve().relative_to(SOURCES_DIR).as_posix()
        for error in file.iter("error"):
            violations[f"{path}:{error.get('line')}: {check_name(error.get('source'))}"] += 1
    return violations


def expected_violations():
    lines = EXPECTED_FILE.read_text(encoding="utf-8").splitlines()
    return Counter(line.strip() for line in lines if line.strip() and not line.startswith("#"))


def print_violations(label, violations):
    for violation, count in sorted(violations.items()):
        print(f"{label} {violation}" + (f" (x{count})" if count > 1 else ""))


def main():
    if not RESULT_FILE.is_file():
        sys.exit(f"{RESULT_FILE} not found, run 'mvn -f java/checkstyle/verify/pom.xml clean verify' first")

    actual = actual_violations()
    expected = expected_violations()

    print_violations("missing:   ", expected - actual)
    print_violations("unexpected:", actual - expected)

    if actual != expected:
        sys.stdout.flush()
        sys.exit("checkstyle violations for the invalid samples differ from expected-violations.txt")
    print(f"all {expected.total()} expected violations reported")


if __name__ == "__main__":
    main()
