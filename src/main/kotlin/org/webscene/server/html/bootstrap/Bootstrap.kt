package org.webscene.server.html.bootstrap

import org.webscene.server.createBootstrapColumn
import org.webscene.server.createBootstrapContainer
import org.webscene.server.createBootstrapRow

@Suppress("unused")
/**
 * Contains common functionality for Bootstrap (CSS framework).
 * @author Nick Apperley
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