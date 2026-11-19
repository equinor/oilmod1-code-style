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
They are optional for checkstyle, so if they are not found, suppressions (for example of `dto` packages) are silently not applied.
The CheckStyle-IDEA plugin finds them next to the configuration file, but the Checkstyle CLI, Maven and Gradle resolve them against the working directory, see [Checkstyle in Maven, Gradle or the CLI](#checkstyle-in-maven-gradle-or-the-cli).

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

The scheme also covers other languages. Apart from XML, which uses the Java settings, they follow their own style guides instead of the Java deviations:

* Python: [Google Python style](https://google.github.io/styleguide/pyguide.html), 4 spaces indentation, 80 characters
* JavaScript: [Google JavaScript style](https://google.github.io/styleguide/jsguide.html), 2 spaces indentation, 80 characters
* Protocol Buffers: [protobuf style guide](https://protobuf.dev/programming-guides/style/), 2 spaces indentation, 80 characters
* Objective-C: [Google Objective-C style](https://google.github.io/styleguide/objcguide.html), 2 spaces indentation, 100 characters

The same limits are set in [.editorconfig](../.editorconfig).

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

## Checkstyle in Maven, Gradle or the CLI

The configuration refers to the suppression files by file name only.
Outside of the CheckStyle-IDEA plugin, Checkstyle resolves those names against the working directory, not against the directory of `oilmod-checkstyle.xml`.
Set both suppression file properties explicitly, otherwise the suppressions are silently skipped.
The examples below expect the three files of a [version](#versions) in `config/checkstyle/` of your project.

### Maven

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-checkstyle-plugin</artifactId>
    <version>3.6.0</version>
    <dependencies>
        <dependency>
            <groupId>com.puppycrawl.tools</groupId>
            <artifactId>checkstyle</artifactId>
            <version>14.4.0</version>
        </dependency>
    </dependencies>
    <configuration>
        <configLocation>config/checkstyle/oilmod-checkstyle.xml</configLocation>
        <!-- ${project.baseUri} instead of ${project.basedir}: backslashes of Windows paths would be treated as escapes -->
        <propertyExpansion>
            org.checkstyle.google.suppressionfilter.config=${project.baseUri}config/checkstyle/oilmod-checkstyle-suppressions.xml
            org.checkstyle.google.suppressionxpathfilter.config=${project.baseUri}config/checkstyle/oilmod-checkstyle-xpath-suppressions.xml
        </propertyExpansion>
        <!-- the configuration reports all violations as warnings -->
        <violationSeverity>warning</violationSeverity>
    </configuration>
</plugin>
```

### Gradle

```groovy
checkstyle {
    toolVersion = '14.4.0'
    configFile = file('config/checkstyle/oilmod-checkstyle.xml')
    configProperties = [
        'org.checkstyle.google.suppressionfilter.config'     : file('config/checkstyle/oilmod-checkstyle-suppressions.xml').path,
        'org.checkstyle.google.suppressionxpathfilter.config': file('config/checkstyle/oilmod-checkstyle-xpath-suppressions.xml').path,
    ]
}
```

### Checkstyle CLI

Create a properties file, for example `checkstyle.properties`, with paths relative to the directory you run Checkstyle from (use `/` also on Windows):

```properties
org.checkstyle.google.suppressionfilter.config=config/checkstyle/oilmod-checkstyle-suppressions.xml
org.checkstyle.google.suppressionxpathfilter.config=config/checkstyle/oilmod-checkstyle-xpath-suppressions.xml
```

```shell
java -jar checkstyle-14.4.0-all.jar -c config/checkstyle/oilmod-checkstyle.xml -p checkstyle.properties src
```
