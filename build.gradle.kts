import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.kotlin.dsl.withType

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.androidKmpLibrary) apply false
    alias(libs.plugins.detekt)
}

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    dependencies {
        val detektVersion = "1.23.8" //TODO move it to libs.versions.toml
        //For some reason the version catalog is recommend here, but it doesn't work.
        detekt("io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion")
        detekt("io.gitlab.arturbosch.detekt:detekt-cli:$detektVersion")
    }
}

subprojects {
    tasks.withType<Detekt>().configureEach {
        reports {
            allRules = false // activate all available (even unstable) rules.
            autoCorrect = true // Correct right-away all correctable code smells
            buildUponDefaultConfig = true // preconfigure defaults
            config.setFrom("${project.rootDir}/config/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
        }
    }
}
