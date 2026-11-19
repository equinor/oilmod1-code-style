# Oilmod1 Java Code Style

The current Oilmod1 Java Code Style is primarily based on the [Google Java Code Style](https://google.github.io/styleguide/javaguide.html) guide, albeit with minor deviations.

These deviations include:

* Setting the **maximum line length** to **160 characters**.
* Mandating **4 spaces** for **indents** in Java code, in contrast to Google's preference for 2 spaces.

At present, we have two important rules in place:

* Developers are expected to adhere to the Oilmod1 Java Code Style and apply it consistently to all newly written code and any modified lines in existing code sections.
* Developers are discouraged from applying code style adjustments in bulk to existing code sections (such as entire classes, files, or packages) when only a few lines of code have been edited. This practice can complicate the review process and obscure the actual changes made to the code.

## Versions

The configuration files are versioned with date-based tags (`YYYY.MM.DD`).
See [releases](https://github.com/equinor/oilmod1-code-style/releases) for the available versions and how each one changes the rules.

Use a tagged version instead of the `main` branch, so your project only gets new rules when you decide to upgrade.
Download the files of a version by replacing `main` with the tag in the URL, for example for `2025.06.24`:

* `https://raw.githubusercontent.com/equinor/oilmod1-code-style/2025.06.24/java/checkstyle/oilmod-checkstyle.xml`
* `https://raw.githubusercontent.com/equinor/oilmod1-code-style/2025.06.24/java/checkstyle/oilmod-checkstyle-suppressions.xml`
* `https://raw.githubusercontent.com/equinor/oilmod1-code-style/2025.06.24/java/checkstyle/oilmod-checkstyle-xpath-suppressions.xml`
* `https://raw.githubusercontent.com/equinor/oilmod1-code-style/2025.06.24/java/intellij/intellij-java-oilmod-style.xml`

Keep the suppression files in the same directory as `oilmod-checkstyle.xml`.
They are optional for checkstyle, so if they are missing, suppressions (for example of `dto` packages) are silently not applied.

Required Checkstyle version:

* **10.16.0 or later** from version `2024.05.23`, older Checkstyle versions fail to load the configuration
* 8.42 or later for version `2024.03.14`

The configuration on `main` is verified in CI with the Checkstyle version set in [verify/pom.xml](checkstyle/verify/pom.xml).

## Installing code style settings into your IDE

To make life easier, it is possible to adjust IDE settings to adhere to the code style.

Please, follow guides below in order to apply this code style.

### EditorConfig

Copy the [.editorconfig](../.editorconfig) file to the root of your project.
It sets basic settings (encoding, line endings, indentation, maximum line length) and is supported by IntelliJ IDEA, Eclipse, VS Code and most other editors natively or via a plugin.

### IntelliJ IDEA instructions

Download file `intellij-java-oilmod-style.xml` of a [version](#versions) (or the latest one from [java/intellij/intellij-java-oilmod-style.xml](intellij/intellij-java-oilmod-style.xml)).

1. Go to `File` → `Settings` → `Editor` → `Code Style`
1. Click gear icon :gear:, choose from drop-down menu: `Import Scheme` → `IntelliJ IDEA code style XML` and import settings file

### Checkstyle plugin for IntelliJ IDEA

Additional benefits can be obtained by installing the [CheckStyle-IDEA - IntelliJ IDEs Plugin | Marketplace](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea) plugin.

#### Install

1. Open IntelliJ
1. Go to `File` → `Settings` → `Plugins`
1. Search for and install **CheckStyle-IDEA plugin** from marketplace
1. Restart IDE

#### Configure

1. Clone the [equinor/oilmod1-code-style](https://github.com/equinor/oilmod1-code-style) repository at a version, for example `git clone --branch 2025.06.24 https://github.com/equinor/oilmod1-code-style.git`  
(or just download the configuration and suppression files of a [version](#versions) into one directory)
1. Open IntelliJ
1. Go to `File` → `Settings` → `Tools` → `Checkstyle`
1. Configure plugin:
   * Set `Checkstyle version` to a [supported version](#versions) (10.16.0 or later)
   * Set `Scan Scope` to `Only Java sources (including tests)` (excluding tests is default behaviour for the plugin and is wrong)
   * Check `Treat Checkstyle errors as warnings`
   * Check `Copy libraries from project directory`
   * Click the `+` in the `Configuration File` section to import new configuration file: `./java/checkstyle/oilmod-checkstyle.xml` (give it a sensible name, for example, “Oilmod Checkstyle”)

#### Use

After configuration is done, Checkstyle errors will appear as warnings in the editor.

For additional benefits, search for "Checkstyle" in IntelliJ and select the option with a yellow pencil icon. This will add a Checkstyle window located near the Services, Terminal, and Git windows. Within this window, you'll find more options to scan the current file, module, and project, among other choices.
