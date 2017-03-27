package org.webscene.server.template

import org.webscene.server.html.HtmlTag

/**
 * Base for an HTML template.
 * @author Nick Apperley
 */
interface HtmlTemplate {
    /** The root HTML element to use for the template. */
    var content: HtmlTag?
}