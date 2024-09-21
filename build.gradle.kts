plugins {
    kotlin("jvm") version "2.0.0"
}

group = "dev.artisrabocanvi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // Tests
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
    testImplementation("io.kotest:kotest-assertions-core:5.8.1")

    testImplementation("org.assertj:assertj-core:3.24.2")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}