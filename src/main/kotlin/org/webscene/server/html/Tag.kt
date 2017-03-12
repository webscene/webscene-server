package org.webscene.server.html

/**
 * Base for a tag element.
 */
interface Tag {
    var tagName: String
    val attributes: MutableMap<String, String>
    var isClosed: Boolean
    var txtContent: String

    fun createText(indent: Int = 2): String
}