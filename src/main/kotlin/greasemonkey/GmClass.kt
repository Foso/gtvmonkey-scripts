package greasemonkey

/**
 * @param text The main notification text.
 * @param title The title of the notification. If not provided, the title will be "Greasemonkey".
 * @param image The URL for an image to display in the dialog. If not provided, the Greasemonkey logo will be used.
 * @param onclick  Callback, triggered when the notification window is clicked.
 */
class NotificationOption(val text: String, val title: String = "", val image: String = "", val onclick: () -> Unit = {})

class Script(val name:String)

class Info(val script : Script)
external interface GmClass {
    fun xmlHttpRequest(dy: Request)

    //This method displays a notification to the user, using the underlying browser and operating system's notification mechanism.
    fun notification(notificationOption: NotificationOption)
    val info : Info
}

external var GM: GmClass
