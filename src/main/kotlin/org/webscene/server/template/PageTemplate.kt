package org.webscene.server.template

import org.webscene.server.html.HtmlTag
import org.webscene.server.html.HtmlCreator as html

/**
 * Template for a web page.
 * @property pageId Unique identifier for the web page.
 * @property title Name of the web page.
 * @property charset Character encoding to use for the web page.
 * @author Nick Apperley
 */
class PageTemplate(val pageId: String, var title: String = "", var charset: String = "UTF-8") : HtmlTemplate {
    /** HTML tags that are included in the **head** tag. */
    val headItems = mutableListOf<HtmlTag>()
    /** JavaScript tags (**script** tags) to include in the HTML. */
    val scripts = mutableListOf<HtmlTag>()
    /** HTML tags that are included in the **body** tag. */
    val bodyItems = mutableListOf<HtmlTag>()

    override var content: HtmlTag? = null
        get() = html.parentHtmlElement("html") {
            parentHtmlElement("head") {
                if (title.isNotEmpty()) htmlElement("title") { +title }
                headItems.forEach { children.add(it) }
            }
            parentHtmlElement("body") {
                bodyItems.forEach { children.add(it) }
                scripts.forEach { children.add(it) }
            }
        }

    init {
        headItems.add(
            html.htmlElement("meta") {
                    attributes["charset"] = charset
                    isClosed = true
                }
        )
        headItems.add(
            html.htmlElement("meta") {
                    attributes["pageId"] = pageId
                    isClosed = true
                }
        )
    }
}