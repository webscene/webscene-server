package org.webscene.server.html.bootstrap

/**
 * Contains all available Bootstrap column sizes.
 * @property txt Text representation of the column size.
 * @author Nick Apperley
 */
@Suppress("unused")
enum class ColumnSize(val txt: String) {
    /** Smart phone size. **/
    EXTRA_SMALL("xs"),
    /** Tablet size. **/
    SMALL("sm"),
    /** Desktop size. **/
    MEDIUM("md"),
    /** Desktop size. **/
    LARGE("lg")
}