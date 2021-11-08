package xmlHttpRequestExample

import greasemonkey.GM
import greasemonkey.Request
import kotlinx.browser.window

//https://wiki.greasespot.net/GM.xmlHttpRequest

fun bareMinimun() {
    GM.xmlHttpRequest(Request(url = "http://www.example.com/", method = "GET", onload = {
        window.alert(it.responseText)
    }))
}