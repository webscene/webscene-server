package org.webscene.server.html

/**
 * Basic HTML element which doesn't contain any children.
 * @author Nick Apperley
 */
open class HtmlElement : HtmlTag {
    val classes = mutableListOf<String>()
    override val attributes = mutableMapOf<String, String>()
    override lateinit var tagName: String
    override var isClosed = false
    override var txtContent = ""

    private fun createAttributes() = buildString {
        if (attributes.isNotEmpty()) {
            append(" ")
            attributes.keys.forEach { append("$it = \"${attributes[it]}\" ") }
        }
    }

    private fun createClasses() = buildString {
        if (classes.isNotEmpty()) append(" class = \"${classes.joinToString(" ")}\"")
    }

    override fun createText(indent: Int) = buildString {
        (1..indent).forEach { append(" ") }
        append("<$tagName${createClasses()}${createAttributes()}")
        if (isClosed) append(" />") else append(">$txtContent</$tagName>")
    }

    operator fun String.unaryPlus() {
        txtContent = this
    }
}