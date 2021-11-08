package greasemonkey

external interface GmClass{
    fun xmlHttpRequest(dy: Request)
}

external var GM : GmClass
