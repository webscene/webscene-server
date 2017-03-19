package org.webscene.server

import org.webscene.server.html.HtmlElement
import org.webscene.server.html.ParentHtmlElement
import org.webscene.server.template.PageTemplate
import org.webscene.server.template.SectionTemplate

/**
 * Provides general view functionality.
 * @author Nick Apperley
 */
@Suppress("unused")
object WebScene {
    /**
     * Creates a new parent HTML element that can contain child HTML elements.
     * @param tagName Name of the tag.
     * @param init Initialisation block for setting up the HTML element.
     * @return A new [parent HTML element][ParentHtmlElement].
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
     * @return A new [HTML element][HtmlElement].
     */
    fun htmlElement(tagName: String, init: HtmlElement.() -> Unit): HtmlElement {
        val htmlElement = HtmlElement()

        htmlElement.tagName = tagName
        htmlElement.init()
        return htmlElement
    }

    /**
     * Creates a new [web page template][PageTemplate].
     * @param pageId Unique identifier for the web page.
     * @param title Name of the web page.
     * @param charset Character encoding to use for the web page.
     * @return A new [web page template][PageTemplate].
     */
    fun pageTemplate(pageId: String, title: String = "", charset: String = "UTF-8") = PageTemplate(pageId = pageId,
            title = title, charset = charset)

    /**
     * Creates a new [section template][SectionTemplate] which can be used in multiple web pages.
     * @return A new [section template][SectionTemplate].
     */
    fun sectionTemplate() = SectionTemplate()
}