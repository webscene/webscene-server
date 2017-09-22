import org.gradle.jvm.tasks.Jar
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val KOTLIN_VER = "1.1.1"


group = "org.webscene"
version = "0.1-SNAPSHOT"

plugins {
    `maven-publish`
    kotlin(module = "jvm", version = "1.1.1")
}

buildscript {
    extra["dokka-ver"] = "0.9.13"

    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:${extra["dokka-ver"]}")
    }
}

val DOKKA_VER = "${extra["dokka-ver"]}"

apply {
    plugin("org.jetbrains.dokka")
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    compile(kotlin(module = "stdlib-jre8", version = KOTLIN_VER))
}

publishing {
    publications {
        create("docs", MavenPublication::class.java) {
            from(components["java"])
            artifact(createDokkaJar)
        }
        create("sources", MavenPublication::class.java) {
            from(components["java"])
            artifact(createSourceJar)
        }
    }

    repositories {
        maven { url = uri("$buildDir/repository") }
    }
}

val compileKotlin by tasks.getting(KotlinCompile::class) {
    kotlinOptions.jvmTarget = "1.8"
}
val dokka by tasks.getting(DokkaTask::class) {
    moduleName = "webscene-server"
    outputDirectory = "$buildDir/javadoc"
    sourceDirs = files("src/main/kotlin")
    doFirst { File("${projectDir.absolutePath}/build/javadoc").deleteRecursively() }
}
val createDokkaJar = task<Jar>("createDokkaJar") {
    dependsOn(dokka)
    classifier = "javadoc"
    from(dokka.outputDirectory)
}
val createSourceJar = task<Jar>("createSourceJar") {
    dependsOn("classes")
    classifier = "sources"
    from("src/main/kotlin")
}

task("createAllJarFiles") {
    dependsOn("jar", createSourceJar, createDokkaJar)
    println("Creating JAR files (library, sources and documentation)...")
    doLast { println("Finished creating JAR files.") }
}
