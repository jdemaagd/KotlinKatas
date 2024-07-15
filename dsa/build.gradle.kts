plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

kotlin {
    KotlinVersion.CURRENT
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockito.kotlin)

    testImplementation(libs.junit)
}