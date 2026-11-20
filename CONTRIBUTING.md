# Contribution Guide

## How to Start contributing

Welcome! We are delighted that you want to contribute to our project! 💖

This project accepts contributions via GitHub pull requests.

This document outlines the process to help ensure your contribution is accepted.

There are several ways to contribute:

* Suggest [features](https://github.com/equinor/oilmod1-code-style/issues/new?template=feature-request.md)
* Suggest [changes](https://github.com/equinor/oilmod1-code-style/issues/new?template=code-maintenance.md)
* Report [bugs](https://github.com/equinor/oilmod1-code-style/issues/new?template=bug-report.md)

## How to contribute your changes via PR

In general, we follow [Work and Pull Request Workflow](https://github.com/susam/gitpr).

Here's a quick guide:

1. Create your fork of the repository.
1. Clone the project to your machine.
1. To keep track of the original repository add another remote named "upstream".

    ```shell
    git remote add upstream git@github.com:equinor/oilmod1-code-style.git
    ```

1. Create a branch locally with a succinct but descriptive name, prefixed with change type.

    ```shell
    git checkout -b feature/my-new-feature
    ```

1. Make the changes in the created branch.
1. Add the changed files.

    ```shell
    git add path/to/filename
    ```

1. Commit your changes using the [conventional commits](https://www.conventionalcommits.org/en/v1.0.0/) formatting for the commit messages.

    ```shell
    git commit -m "conventional commit formatted message"
    ```

1. Before sending the pull request, make sure to rebase onto the upstream source. This ensures your code is based on the latest available code.

    ```shell
    git fetch upstream
    git rebase upstream/main
    ```

1. Push to your fork.

    ```shell
    git push origin feature/my-new-feature
    ```

1. Submit a pull request to the original repository via GitHub interface.  
    * Please provide us with some explanation of why you made the changes you made.  
    * For new features make sure to explain a standard use case to us.

That's it... thank you for your contribution!

After your pull request is merged, you can safely delete your branch.

## Changing the checkstyle configuration

Changes to `java/checkstyle/` are verified in CI by running checkstyle on sample sources in `java/checkstyle/verify/`:

* `src/valid/java` follows the code style and must produce no violations.
* `src/invalid/java` breaks the Oilmod1 deviations from the Google style and must produce exactly the violations listed in `expected-violations.txt`.

Run the same check locally (requires Java 21+, Maven and Python 3):

```shell
mvn -f java/checkstyle/verify/pom.xml clean verify
python java/checkstyle/verify/compare_violations.py
```

When adding or changing a deviation, add a sample to `src/valid/java` or `src/invalid/java` and update `expected-violations.txt`.

### Syncing with the Google configuration

`oilmod-checkstyle.xml` is the `google_checks.xml` of a Checkstyle release with the Oilmod1 changes listed in its header comment.
It keeps the upstream formatting, so a diff with the original shows only those changes.
To sync with a newer Checkstyle release:

1. Take `src/main/resources/google_checks.xml` of the release tag from [checkstyle/checkstyle](https://github.com/checkstyle/checkstyle) (for example tag `checkstyle-14.4.0`).
1. Re-apply the changes listed in the header comment and update the Checkstyle version and date in it.
1. Set the same Checkstyle version in `java/checkstyle/verify/pom.xml` and run the check above. New upstream checks can conflict with an Oilmod1 change, as `GoogleMethodName` did with abbreviations.
1. Find the minimum Checkstyle version that loads the configuration and update the required version in [java/README.md](java/README.md#versions).

## Code review process

The core team regularly reviews pull requests.

After feedback has been provided, we expect responses within three weeks.

If there is no activity on the pull request after three weeks, we may consider closing it.
