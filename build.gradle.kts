import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("js") version "1.8.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    js {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
}


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


tasks{
    register("buildUserScript") {
        doLast {
            val toConcatenate = files("./build/distributions/metadata.txt","./build/distributions/${project.name}.js")
            val outputFileName = "./build/distributions/${project.name}.user.js"
            val output = File(outputFileName)
            output.writeText(" ") // truncate output if needed
            toConcatenate.forEach { f -> output.appendText(f.readText()) }
            output.appendText("\nmain();")
            println("Hello, World!") }

    }
}

tasks.build {
    finalizedBy("buildUserScript")
}