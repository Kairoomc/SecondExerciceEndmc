import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}


group = "fr.kairo.items"
version = "1.0"

repositories {
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(files("spigot-1.12.2.jar"))
}



java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}



