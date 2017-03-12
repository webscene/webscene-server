package org.webscene.server.template

import org.webscene.server.WebScene as ws
import org.webscene.server.html.HtmlTag

/**
 * Template for a web page.
 * @author Nick Apperley
 */
class PageTemplate(val pageId: String, var title: String = "", var charset: String = "UTF-8") : HtmlTemplate {
    val headItems = mutableListOf<HtmlTag>()
    val scripts = mutableListOf<HtmlTag>()
    val bodyItems = mutableListOf<HtmlTag>()

    override var content: HtmlTag? = null
        get() = ws.parentHtmlElement("html") {
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
                ws.htmlElement("meta") {
                    attributes["charset"] = charset
                    isClosed = true
                }
        )
        headItems.add(
                ws.htmlElement("meta") {
                    attributes["pageId"] = pageId
                    isClosed = true
                }
        )
    }
}