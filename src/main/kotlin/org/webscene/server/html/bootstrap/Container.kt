package org.webscene.server.html.bootstrap

import org.webscene.server.html.ParentHtmlElement

/**
 * Bootstrap Container element.
 * @author Nick Apperley
 * @see org.webscene.server.html.ParentHtmlElement
 */
class Container : ParentHtmlElement() {
    override var tagName
        get() = "div"
        set(value) {}
    /** [Container] uses the full width of the screen if set to true. **/
    @Suppress("unused")
    var fullWidth = true

    /**
     * Creates a new [row][Row] in [Container] that holds one or more columns.
     * @param init Initialisation block for setting up the row.
     * @return A new [Row].
     */
    @Suppress("unused")
    fun row(init: Row.() -> Unit): Row {
        val rowElement = Row()

        children.add(rowElement)
        rowElement.init()
        return rowElement
    }
}