# Grease/Tamper/Violent-Monkey scripts with KotlinJs

This a template project that helps you write Greasemonkey/Tampermonkey/ViolentMonkey scripts with KotlinJs

## How does it work?

### Gradle
I configured a Gradle task [**buildUserScript**](https://github.com/Foso/gtvmonkey-scripts/blob/master/build.gradle#L42) that will generate a userscript file.
The task will concat the script metadata from <kbd>main/resources/metadata.txt</kbd>, the **kotlin.js** and your generated javascript file. 
Then it will append **main();** to the script, which will execute the main() of your Kotlin Code.

The script will be outputed to <kbd>/build/distributions/$NAMEOFYOURGRADLEPROJECT.user.js</kbd>

The gradle task will be triggered after every Gradle **build** task

### Metadata
You can configure the metadata of your userscript inside [/src/main/resources/metadata.txt](https://github.com/Foso/gtvmonkey-scripts/blob/master/src/main/resources/metadata.txt)

## Kotlin
Write your Kotlin Code inside **src/main/kotlin**. The **main()** will be executed first by the userscript.

## Hot Reload
When you use **gradle -t build** inside your project folder, Gradle will detect all changes to your Kotlin Code and metadata.txt file, and will compile and generate a new userscript on every change. The detection of changes on the userscript depends on your used addon. E.g. Violentmonkey supports tracking of file changes in Chrome (https://violentmonkey.github.io/posts/how-to-edit-scripts-with-your-favorite-editor/) and it can detect changes on a new generated userscript.

## Example
Let's create a script thats alerts "Hello Github" on every page of Github.

Add this inside your /main/resources/metadata.txt

```kotlin
// ==UserScript==
// @name        MyNew script - KotlinJs
// @namespace   GtvMonkey Scripts
// @grant       none
// @version     1.0
// @author      -
// @description 10/16/2020, 9:43:07 PM
// @include     https://github.com/*
// ==/UserScript==
```
You can find out more about the Metadata section [HERE](https://wiki.greasespot.net/Metadata_Block)

This is your Kotlin Code
```kotlin
fun main() {
    window.alert("Hello Github!")
}
```

Run the **build** task of Gradle and you will find a *.user.js inside /build/distributions.
Add this file to your wanted userscript browser addon and you are done.
