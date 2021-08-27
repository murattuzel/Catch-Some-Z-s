import plugins.BuildPlugins
import plugins.Merge_checks_gradle.MergeChecksTask

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins.apply(BuildPlugins.gitHooks)

subprojects {
    plugins.apply(BuildPlugins.spotless)
    plugins.apply(BuildPlugins.detekt)
    plugins.apply(BuildPlugins.ktlint)

    tasks.register("checkFormat") {
        dependsOn("detekt", "ktlintCheck", "lintDebug", "spotlessCheck")
    }

    tasks.register("reformat") {
        dependsOn("ktlintFormat", "spotlessApply")
    }

    tasks.register<MergeChecksTask>("mergeChecks")
}

tasks.register("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}
