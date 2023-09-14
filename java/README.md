# Oilmod1 Java Code Style

The current Oilmod1 Java Code Style is primarily based on the [Google Java Code Style](https://google.github.io/styleguide/javaguide.html) guide, albeit with minor deviations.

These deviations include:

* Setting the **maximum line length** to **160 characters**.
* Mandating **4 spaces** for **indents** in Java code, in contrast to Google's preference for 2 spaces.

At present, we have two important rules in place:

* Developers are expected to adhere to the Oilmod1 Java Code Style and apply it consistently to all newly written code and any modified lines in existing code sections.
* Developers are discouraged from applying code style adjustments in bulk to existing code sections (such as entire classes, files, or packages) when only a few lines of code have been edited. This practice can complicate the review process and obscure the actual changes made to the code.

## Installing code style settings into your IDE

To make life easier, it is possible to adjust IDE settings to adhere to the code style.

Please, follow guides below in order to apply this code style.

### IntelliJ IDEA instructions

Download file [./java/intellij/intellij-java-oilmod-style.xml](https://github.com/equinor/oilmod1-code-style/blob/master/java/intellij/intellij-java-oilmod-style.xml) from repository.

1. Go to `File` → `Settings and select Editor` → `Code Style`
1. Click gear icon :gear:, choose from drop-down menu: `Import Scheme` → `Intellij IDEA code style XML` and import settings file

### Checkstyle plugin for IntelliJ IDEA

Additional benefits can be obtained by installing the [CheckStyle-IDEA - IntelliJ IDEs Plugin | Marketplace](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea) plugin.

#### Install

1. Open IntelliJ
1. Go to `File` → `Settings` → `Plugins`
1. Search for and install **CheckStyle-IDEA plugin** from marketplace
1. Restart IDE

#### Configure

1. Clone the [equinor/oilmod1-code-style](https://github.com/equinor/oilmod1-code-style) repository  
(or just download the configuration file: [./java/checkstyle/oilmod_checks.xml](https://github.com/equinor/oilmod1-code-style/blob/master/java/checkstyle/oilmod_checks.xml))
1. Open IntelliJ
1. Go to `File` → `Tools` → `Checkstyle`
1. Configure plugin:
   * Set `Scan Scope` to `Only Java sources (including tests)` (excluding tests is default behaviour for the plugin and is wrong)
   * Check `Treat Checkstyle errors as warnings`
   * Check `Copy libraries from project directory`
   * Click the `+` in the `Configuration File` section to import new configuration file: `./java/checkstyle/oilmod_checks.xml` (give it a sensible name, for example, “Oilmod Checks”)

#### Use

After configuration is done, Checkstyle errors will appear as warnings in the editor.

For additional benefits, search for "Checkstyle" in IntelliJ and select the option with a yellow pencil icon. This will add a Checkstyle window located near the Services, Terminal, and Git windows. Within this window, you'll find more options to scan the current file, module, and project, among other choices.
