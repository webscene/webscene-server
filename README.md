# Web Scene Server (webscene-server)
Server side library for building web UIs for Kotlin based projects.


## Usage

Use the **org.webscene.server.WebScene** object to create HTML elements. Below is an example:

```kotlin
import org.webscene.server.WebScene as ws

@JvmStatic
fun main(args: Array<String>) {
    ws.parentHtmlElement("div") {
        parentHtmlElement("p") {
            htmlElement("b") {
                +"Hello World! :)"
            }
        }
    }
}
```


Once the HTML element is created you call the **createText** function off the object to generate the HTML that the web server will send after receiving a HTTP response. Here is what the HTML will look like after calling the **createText** function (based on the example above):

```html
<div>
    <p>
        <b>Hello World! :)</b>
    </p>
</div>
```
