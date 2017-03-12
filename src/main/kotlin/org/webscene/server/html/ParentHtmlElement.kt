package org.webscene.server.html

/**
 * A parent HTML element which can contain children.
 */
open class ParentHtmlElement : ParentTag {
    val classes = mutableListOf<String>()
    override lateinit var tagName: String
    override val attributes = mutableMapOf<String, String>()
    override var txtContent = ""
    override val children = mutableListOf<Tag>()

    fun parentHtmlElement(tagName: String, init: ParentHtmlElement.() -> Unit): ParentHtmlElement {
        val parentHtmlElement = ParentHtmlElement()

        parentHtmlElement.tagName = tagName
        children.add(parentHtmlElement)
        parentHtmlElement.init()
        return parentHtmlElement
    }

    fun htmlElement(tagName: String, init: HtmlElement.() -> Unit): HtmlElement {
        val htmlElement = HtmlElement()

        htmlElement.tagName = tagName
        children.add(htmlElement)
        htmlElement.init()
        return htmlElement
    }

    private fun createStartingTag(indent: Int) = buildString {
        if (indent > 0) (1..indent).forEach { append(" ") }
        append("<$tagName${createClasses()}${createAttributes()}>")
    }

    private fun createAttributes() = buildString {
        if (attributes.isNotEmpty()) {
            append(" ")
            attributes.keys.forEach { append("$it = \"${attributes[it]}\" ") }
        }
    }

    private fun createClasses() = buildString {
        if (classes.isNotEmpty()) {
            append(" class = \"${classes.joinToString(" ")}\"")
        }
    }

    override fun createText(indent: Int) = buildString {
        val newIndent = indent + 2

        append("\n${createStartingTag(indent)}")
        if (txtContent.isNotEmpty()) {
            append("\n")
            (1..newIndent).forEach { append(" ") }
            append(txtContent)
        }
        children.forEach { append(it.createText(newIndent)) }
        append("\n")
        (1..indent).forEach { append(" ") }
        append("</$tagName>")
    }

    operator fun String.unaryPlus() {
        txtContent = this
    }
}