# Web Scene Server (webscene-server)
Server side library for building web UIs for Kotlin based projects.


## Installation

To install the library do the following:

1. Clone the **webscene/webscene-server** Git repository from GitHub
2. Import the cloned repository into IntelliJ
3. Create all JAR files (source, documentation, library) by running the **createAllJarFiles** Gradle task
4. Copy the contents of **build/libs** directory to this directory in your project: **libs/org/webscene/webscene-server/{version}**
5. Assuming Gradle is used in your project edit your **build.gradle.kts** file, and insert the following:

```kotlin
import java.net.URI

// ...

repositories {
    mavenCentral()
    maven {
        url = URI("libs").toURL()
    }
}
```

6. Add this line in your **build.gradle** file to add the library as a dependency:

```kotlin
compile("org.webscene:webscene-server:version")
```


## Basic Usage

Use the **org.webscene.server.WebScene** object to create HTML elements. Below is an example:

```kotlin
import org.webscene.server.html.HtmlCreator as html

fun main(args: Array<String>) {
    html.parentElement("div") {
        parentElement("p") {
            element("b") { +"Hello World! :)" }
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
