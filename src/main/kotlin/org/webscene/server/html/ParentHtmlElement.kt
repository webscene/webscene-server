package org.webscene.server.html

/**
 * A parent HTML element which can contain [children].
 * @author Nick Apperley
 */
open class ParentHtmlElement : ParentHtmlTag {
    /** Contains unique class names. */
    val classes = mutableSetOf<String>()
    override lateinit var tagName: String
    override val attributes = mutableMapOf<String, String>()
    override var txtContent = ""
    override val children = mutableListOf<HtmlTag>()

    /**
     * Creates a new [parent HTML element][ParentHtmlElement] that is appended to [children] that can contain child
     * HTML elements.
     * @param tagName Name of the tag.
     * @param init Initialisation block for setting up the HTML element.
     * @return A new [ParentHtmlElement]
     */
    fun parentHtmlElement(tagName: String, init: ParentHtmlElement.() -> Unit): ParentHtmlElement {
        val parentHtmlElement = ParentHtmlElement()

        parentHtmlElement.tagName = tagName
        children.add(parentHtmlElement)
        parentHtmlElement.init()
        return parentHtmlElement
    }

    /**
     * Creates a new [HTML element][HtmlElement] that is appended to [children] which doesn't have any child HTML
     * elements.
     * @param tagName Name of the tag.
     * @param init Initialisation block for setting up the HTML element.
     * @return A new [HtmlElement]
     */
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

    /**
     * Changes the [text][txtContent] to include in the parent HTML element.
     */
    operator fun String.unaryPlus() {
        txtContent = this
    }
}