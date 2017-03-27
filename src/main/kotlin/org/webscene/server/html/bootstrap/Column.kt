package org.webscene.server.html.bootstrap

import org.webscene.server.html.ParentHtmlElement

/**
 * Bootstrap Column element.
 * @author Nick Apperley
 * @see org.webscene.server.html.ParentHtmlElement
 */
class Column : ParentHtmlElement() {
    /**
     * Contains column sizes. Each entry is [column size type][ColumnSize] (key), span size (value).
     */
    val colSizes = mutableMapOf<ColumnSize, Int>()
    override var tagName
        get() = "div"
        set(value) {}
}