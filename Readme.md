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
When you use **gradle -t build** inside your project folder, Gradle will detect all changes to your Kotlin Code and metadata.txt file, and will compile and generate a new userscript on every change. 
