package org.webscene.server

import org.webscene.server.html.HtmlElement
import org.webscene.server.html.ParentHtmlElement
import org.webscene.server.html.bootstrap.Column
import org.webscene.server.html.bootstrap.ColumnSize
import org.webscene.server.html.bootstrap.Container
import org.webscene.server.html.bootstrap.Row
import org.webscene.server.template.PageTemplate
import org.webscene.server.template.SectionTemplate

/**
 * Provides general view functionality.
 * @author Nick Apperley
 */
@Suppress("unused")
object WebScene {
    /**
     * Contains common functionality for Bootstrap (CSS framework).
     */
    object Bootstrap {
        /**
         * Creates a new [container][Container] that holds one or more rows.
         * @param init Initialisation block for setting up the container.
         * @return A new [Container].
         */
        fun container(init: (Container) -> Unit) = createBootstrapContainer(init)

        /**
         * Creates a new [row][Row] that holds one or more columns.
         * @param init Initialisation block for setting up the row.
         * @return A new [Row].
         */
        fun row(init: (Row) -> Unit) = createBootstrapRow(init)

        /**
         * Creates a new [column][Column] that can contain HTML elements.
         * @param colSizes One or more column sizes to use for sizing the column.
         * @param init Initialisation block for setting up the column.
         * @return A new [Column].
         */
        fun column(vararg colSizes: Pair<ColumnSize, Int>, init: Column.() -> Unit): Column {
            val tmp = arrayOf(*colSizes)

            return createBootstrapColumn(tmp, init)
        }
    }

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