import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version "2.1.10"
}

group = "kotlin-selenium"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("dev.kolibrium:kolibrium-selenium:0.7.0-SNAPSHOT")
    implementation("io.kotest:kotest-assertions-core-jvm:5.9.1")
    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    testImplementation("com.titusfortner:selenium-logger:2.4.0")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.3")
}

tasks.withType<KotlinCompile> {
    compilerOptions.freeCompilerArgs = listOf(
        "-Xcontext-receivers",
    )
}

tasks.test {
    useJUnitPlatform()
}