plugins {
    java
    application
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("junit:junit:4.13")
}

application {
    mainClassName = "ru.vigilov.graph.Application"
}
