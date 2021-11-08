package greasemonkey

class Request (
    //Required. The URL to make the request to. Must be an absolute URL, beginning with the scheme. May be relative to the current page.
    var url: String,
    //Required. Type of HTTP request to make (E.G. "GET", "POST")
    var method: dynamic /* 'GET' | 'POST' | 'PUT' | 'DELETE' | 'PATCH' | 'HEAD' | 'TRACE' | 'OPTIONS' | 'CONNECT' */,
    //Optional. Will be called when the request has completed successfully. Passed one argument, the #Response Object.
    val onload: ((response: Response) -> Unit)
)