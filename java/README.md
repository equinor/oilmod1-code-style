# Oilmod1 Java Code Style
Based on [Google Java Code Style](https://google.github.io/styleguide/javaguide.html) guide with small deviations.

Deviations from [Google Java Code Style](https://google.github.io/styleguide/javaguide.html):
* max line length is set to `160` (here we agree with [Mozilla Java practices](https://developer.mozilla.org/en-US/docs/Mozilla/Developer_guide/Coding_Style#Java_practices))
* indents should be `4 spaces` (Google prefer `2 spaces`)

# How to configure your IDE to use this code style
It is possible to import code style configuration in many modern IDEs.

Please, follow guides below in order to apply this code style.

## Spring Tools Suite (Eclipse) instructions
Download file [eclipse-java-google-style.xml](https://github.com/equinor/oilmod1-code-style/blob/master/java/eclipse-java-google-style.xml) from this repository.
1. Open `Window` → `Preferences and select Java` → `Code Style` → `Formatter`
1. Import settings file by using `Import...` button

## IntelliJ IDEA instructions
Download file [intellij-java-google-style.xml](https://github.com/equinor/oilmod1-code-style/blob/master/java/eclipse-java-google-style.xml) from this repository.
1. Go to `File` → `Settings and select Editor` → `Code Style`
1. Click gear icon :gear:, choose from drop-down menu: `Import Scheme` → `Intellij IDEA code style XML` and import settings file

## Visual Studio Code (VSCode)
Download file [eclipse-java-google-style.xml](https://github.com/equinor/oilmod1-code-style/blob/master/java/eclipse-java-google-style.xml) from this repository.
1. Go to `File` → `Preferences` → `Settings and select Extensions` → `Java configuration`
1. Find `Java` → `Format` → `Settings: Url` and type in the path to the downloaded xml

Bonus: Install the extension called [Checkstyle for Java](https://marketplace.visualstudio.com/items?itemName=shengchen.vscode-checkstyle))  which will show error as you go.
