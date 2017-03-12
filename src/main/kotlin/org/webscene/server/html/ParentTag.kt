package org.webscene.server.html

/**
 * Base for a parent tag element that contains children.
 */
interface ParentTag : Tag {
    override var isClosed: Boolean
        get() = false
        set(value) {}
    val children: MutableList<Tag>
}