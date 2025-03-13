plugins {
    idea
    kotlin("jvm") version "2.1.0"
}

group = "kotlin-selenium"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
}

tasks.test {
    useJUnitPlatform()
}