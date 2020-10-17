import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLElement
import org.w3c.dom.get

fun main() {
    helloWorld()
   // hideImages()
   // floatingMenu()
}

fun floatingMenu() {
    //A Greasemonkey script that finds h2 tags and creates a floating menu of them.
    val headers = document.getElementsByTagName("h2");
    var menu = ""
    for (i in 0 until headers.length) {
        headers[i]?.let { headerElement ->
            // Determine menu text
            var thismenu = headerElement.innerHTML
            thismenu = thismenu.replace("/\\<[^\\>]*\\>/g", ""); // Remove HTML tags\n"
            thismenu = thismenu.replace("/\\[[^\\]]*\\]/g", "")

            // Create menu item
            var thisid = headerElement.id;
            if (thisid == "") {
                thisid = "h2header$i";
                headerElement.id = thisid;
            }
            menu += "<li><a href=\"#$thisid\"\">$thismenu</a></li>";
        }
    }

    // Create menu
    if (menu != "") {
        val menuobj = document.createElement("ul") as HTMLElement;
        menuobj.style.apply {
            position = "fixed";
            top = "10px";
            left = "10px";
            padding = "20px";
            backgroundColor = "#fff";

        }
        menuobj.innerHTML = menu;
        val body = document.getElementsByTagName("body")[0];
        body?.appendChild(menuobj);
    }

}

private fun hideImages() {
    //This will hide all img-Elements on a page
    val imgs = document.getElementsByTagName("img")
    for (i in 0 until imgs.length) {
        (imgs[i] as HTMLElement).style.visibility = "hidden"  //.asDynamic().style.visibility = "hidden"
    }
}

fun helloWorld() {
    window.alert("Monkey say... \"Hello World!\"");
}



