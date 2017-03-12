package org.webscene.server

import org.webscene.server.html.HtmlElement
import org.webscene.server.html.ParentHtmlElement

/**
 * Provides general view functionality.
 * @author Nick Apperley
 */
object WebScene {
    /**
     * Creates a new parent HTML element that can contain child HTML elements.
     * @param tagName Name of the tag.
     * @param init Initialisation block for setting up the HTML element.
     */
    fun parentHtmlElement(tagName: String, init: ParentHtmlElement.() -> Unit): ParentHtmlElement {
        val parentHtmlElement = ParentHtmlElement()

        parentHtmlElement.tagName = tagName
        parentHtmlElement.init()
        return parentHtmlElement
    }

    /**
     * Creates a new HTML element which doesn't have any child HTML elements.
     * @param tagName Name of the tag.
     * @param init Initialisation block for setting up the HTML element.
     */
    fun htmlElement(tagName: String, init: HtmlElement.() -> Unit): HtmlElement {
        val htmlElement = HtmlElement()

        htmlElement.tagName = tagName
        htmlElement.init()
        return htmlElement
    }
}