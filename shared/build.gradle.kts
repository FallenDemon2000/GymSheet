plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidKmpLibrary)
    kotlin("plugin.serialization") version "2.0.21"
}

kotlin {
    androidLibrary {
        compileSdk = 36
        minSdk = 26
        namespace = "com.plcoding.shared"
        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.ui.tooling)
            implementation(libs.androidx.activity.compose)
        }

        commonMain.dependencies {
            implementation(libs.androidx.runtime)
            implementation(libs.androidx.foundation)
            implementation(libs.androidx.ui.material3)
            implementation(libs.androidx.ui)
            implementation(libs.androidx.components.resources)
            implementation(libs.androidx.ui.tooling.preview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.androidx.navigation)
            implementation(libs.androidx.material.icons)
            implementation(libs.androidx.material.icons.extended)
            implementation(libs.koin.compose)
            implementation(libs.koin.core)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

compose.resources {
    publicResClass = true
}
