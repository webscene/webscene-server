import org.gradle.jvm.tasks.Jar
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.webscene"
version = "0.1-SNAPSHOT"

fun deleteDirectory(directory: File): Boolean {
    @Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")
    var files: Array<File>? = arrayOf()

    if (directory.exists()) {
        files = directory.listFiles()
        if (files != null) {
            for (i in 0..files.size - 1) {
                if (files[i].isDirectory) {
                    deleteDirectory(files[i])
                } else {
                    files[i].delete()
                }
            }
        }
    }
    return directory.delete()
}

buildscript {
    extra["kotlin-ver"] = "1.1.2-2"
    extra["dokka-ver"] = "0.9.13"

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${extra["kotlin-ver"]}")
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:${extra["dokka-ver"]}")
    }
}

apply {
    plugin("kotlin")
    plugin("org.jetbrains.dokka")
}

repositories {
    mavenCentral()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:${extra["kotlin-ver"]}")
}

val dokka: DokkaTask by tasks
val compileKotlin: KotlinCompile by tasks

dokka.moduleName = "webscene-server"
dokka.outputDirectory = "$buildDir/javadoc"
dokka.sourceDirs = files("src/main/kotlin")
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

dokka.doFirst {
    deleteDirectory(File("${projectDir.absolutePath}/build/javadoc"))
}

tasks {
    "createSourceJar"(Jar::class) {
        dependsOn("classes")
        classifier = "sources"
        from("src/main/kotlin")
    }

    "createDokkaJar"(Jar::class) {
        dependsOn("dokka")
        classifier = "javadoc"
        from(dokka.outputDirectory)
    }

    "createAllJarFiles" {
        dependsOn("jar", "createSourceJar", "createDokkaJar")
    }
}

val createAllJarFiles by tasks

createAllJarFiles.doLast {
    println("Finished creating JAR files.")
}
