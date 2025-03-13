import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version "2.1.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.0"
}

group = "kotlin-selenium"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("dev.kolibrium:kolibrium-selenium:0.7.0-SNAPSHOT")
    implementation("dev.kolibrium:kolibrium-dsl:0.7.0-SNAPSHOT")
    implementation("io.kotest:kotest-assertions-core-jvm:5.9.1")
    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    implementation("io.ktor:ktor-client-core:3.0.3")
    implementation("io.ktor:ktor-client-cio:3.0.3")
    implementation("io.ktor:ktor-client-content-negotiation:3.0.3")
    implementation("io.ktor:ktor-client-logging:3.0.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:3.0.3")
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