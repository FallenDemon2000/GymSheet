plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidKmpLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
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
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
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
            implementation(libs.room.sqlite.wrapper)
        }

        commonMain.dependencies {
            implementation(project.dependencies.platform(libs.koin.boom))
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
            implementation(libs.room.runtime)
            implementation(libs.sqlite.bundled)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

dependencies {
    // KSP support for Room Compiler.
    add("kspAndroid", libs.room.compiler)
    add("kspIosSimulatorArm64", libs.room.compiler)
    add("kspIosX64", libs.room.compiler)
    add("kspIosArm64", libs.room.compiler)
}

room {
    schemaDirectory("$projectDir/schemas")
}

compose.resources {
    publicResClass = true
}
