# Oilmod1 Java Code Style

The current Oilmod1 Java Code Style is primarily based on the [Google Java Code Style](https://google.github.io/styleguide/javaguide.html) guide, albeit with minor deviations.

These deviations include:

* Setting the **maximum line length** to **160 characters**.
* Mandating **4 spaces** for **indents** in Java code, in contrast to Google's preference for 2 spaces.

At present, we have two important rules in place:

* Developers are expected to adhere to the Oilmod1 Java Code Style and apply it consistently to all newly written code and any modified lines in existing code sections.
* Developers are discouraged from applying code style adjustments in bulk to existing code sections (such as entire classes, files, or packages) when only a few lines of code have been edited. This practice can complicate the review process and obscure the actual changes made to the code.

# Installing code style settings into your IDE

To make life easier, it is possible to adjust IDE settings to adhere to the code style.

Please, follow guides below in order to apply this code style.

## IntelliJ IDEA instructions

Download file [./java/intellij/intellij-java-google-style.xml](https://github.com/equinor/oilmod1-code-style/blob/master/java/intellij/intellij-java-google-style.xml) from repository.

1. Go to `File` → `Settings and select Editor` → `Code Style`
2. Click gear icon :gear:, choose from drop-down menu: `Import Scheme` → `Intellij IDEA code style XML` and import settings file

## Checkstyle plugin for IntelliJ IDEA

Additional benefits can be obtained by installing the [CheckStyle-IDEA - IntelliJ IDEs Plugin | Marketplace](https://plugins.jetbrains.com/plugin/1065-checkstyle-idea) plugin.

### Install

Install the extension called [Checkstyle for Java](https://marketplace.visualstudio.com/items?itemName=shengchen.vscode-checkstyle) which will show error as you go.
