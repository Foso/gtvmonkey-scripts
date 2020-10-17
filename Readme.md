# Grease/Tamper/Violent-Monkey scripts with KotlinJs

This a template project that helps you write Greasemonkey/Tampermonkey/ViolentMonkey scripts with KotlinJs

## How does it work?

### Gradle
I configured a gradle task **buildUserScript** that will generate a userscript file.
The task will concat the script metadata from **main/resources/metadata.txt**, the **kotlin.js** and your generated javascript file. 
Then it will append **main();** to the script, which will execute the main() of your Kotlin Code.

The script will be outputed to <kbd>/build/distributions/$NAMEOFYOURGRADLEPROJECT.user.js</kbd>

The gradle task will be triggered after every gradle **build** task
