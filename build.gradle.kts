plugins {
    kotlin("jvm") version "1.9.23"
    id("org.jetbrains.kotlin.kapt") version "1.9.23"
}

group = "com.kryptopass.kotlinkatas"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("io.arrow-kt:arrow-core:1.2.3")
    implementation("io.arrow-kt:arrow-optics:1.2.3")
}