package org.webscene.server.html

import org.webscene.server.createHtmlElement
import org.webscene.server.createParentHtmlElement
import org.webscene.server.template.PageTemplate
import org.webscene.server.template.SectionTemplate

@Suppress("unused")
/**
 * Manages creating HTML elements.
 */
object HtmlCreator {
    /**
     * Creates a new [parent HTML element][ParentHtmlElement] that can contain child HTML elements.
     * @param tagName Name of the tag.
     * @param init Initialisation block for setting up the parent HTML element.
     * @return A new [ParentHtmlElement].
     */
    fun parentHtmlElement(tagName: String, init: ParentHtmlElement.() -> Unit) = createParentHtmlElement(
        tagName, init)

    /**
     * Creates a new [HTML element][HtmlElement] which doesn't have any child HTML elements.
     * @param tagName Name of the tag.
     * @param init Initialisation block for setting up the HTML element.
     * @return A new [HtmlElement].
     */
    fun htmlElement(tagName: String, init: HtmlElement.() -> Unit) = createHtmlElement(tagName, init)

    /**
     * Creates a new [web page template][PageTemplate].
     * @param pageId Unique identifier for the web page.
     * @param title Name of the web page.
     * @param charset Character encoding to use for the web page.
     * @return A new [PageTemplate].
     */
    fun pageTemplate(pageId: String, title: String = "", charset: String = "UTF-8") = PageTemplate(pageId = pageId,
        title = title, charset = charset)

    /**
     * Creates a new [section template][SectionTemplate] which can be used in multiple web pages.
     * @return A new [SectionTemplate].
     */
    fun sectionTemplate() = SectionTemplate()
}