plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

object PluginVersions {
    const val gradle = "7.0.1"
    const val kotlinGradle = "1.5.21"
    const val spotless = "5.12.5"
    const val detekt = "1.17.1"
    const val ktlint = "10.1.0"
    const val hilt = "2.36"
    const val safeArgs = "2.3.5"
    const val serialization = "1.5.10"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginVersions.gradle}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.kotlinGradle}")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:${PluginVersions.spotless}")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${PluginVersions.detekt}")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:${PluginVersions.ktlint}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${PluginVersions.hilt}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${PluginVersions.safeArgs}")
    implementation("org.jetbrains.kotlin:kotlin-serialization:${PluginVersions.serialization}")
}
