package org.webscene.server.html

/**
 * Base for a HTML tag.
 * @author Nick Apperley
 */
interface HtmlTag {
    var tagName: String
    val attributes: MutableMap<String, String>
    /**
     * If true then there is only one tag for the element, two otherwise.
     */
    var isClosed: Boolean
    var txtContent: String

    /**
     * Creates a text representation of HTML.
     * @param indent Number of spaces to use for indenting HTML elements.
     */
    fun createText(indent: Int = 2): String
}