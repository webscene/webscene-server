package org.webscene.server.html.bootstrap

import org.webscene.server.html.ParentHtmlElement

/**
 * Bootstrap Row element.
 * @author Nick Apperley
 * @see org.webscene.server.html.ParentHtmlElement
 */
class Row : ParentHtmlElement() {
    override var tagName
        get() = "div"
        set(value) {}

    /**
     * Creates a new [column][Column] in [Row] that can contain HTML elements.
     * @param colSizes One or more column sizes to use for sizing the column.
     * @param init Initialisation block for setting up the column.
     * @return A new [Column].
     */
    @Suppress("unused")
    fun column(vararg colSizes: Pair<ColumnSize, Int>, init: Column.() -> Unit): Column {
        val colElement = Column()

        colSizes.forEach { colElement.colSizes[it.first] = it.second }
        children.add(colElement)
        colElement.init()
        return colElement
    }
}