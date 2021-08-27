plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        vectorDrawables { useSupportLibrary = true }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            val baseUrlDev: String by project
            buildConfigField("String", "BASE_URL", baseUrlDev)
        }

        release {
            isMinifyEnabled = false
            val baseUrlPrd: String by project
            buildConfigField("String", "BASE_URL", baseUrlPrd)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions { jvmTarget = "11" }

    buildFeatures {
        dataBinding = true
    }

    lint {
        isAbortOnError = true
        isAbsolutePaths = false
        lintConfig = file("$rootDir/config/lint/lint.xml")
    }
}

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.KotlinX.Coroutines.core)
    implementation(Dependencies.KotlinX.Coroutines.android)
    implementation(Dependencies.KotlinX.Serialization.json)

    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.appStartup)
    implementation(Dependencies.AndroidX.Lifecycle.livedata)
    implementation(Dependencies.AndroidX.Lifecycle.runtime)
    implementation(Dependencies.AndroidX.Lifecycle.viewModel)
    implementation(Dependencies.AndroidX.Navigation.fragment)
    implementation(Dependencies.AndroidX.Navigation.ui)
    implementation(Dependencies.material)

    implementation(Dependencies.Dagger.hilt)
    kapt(Dependencies.Dagger.hiltKapt)

    implementation(Dependencies.coil)
    implementation(Dependencies.timber)
    implementation(Dependencies.threeTenAbp)
    implementation(Dependencies.timber)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.retrofitSerializer)

    implementation(platform(Dependencies.OkHttp.bom))
    implementation(Dependencies.OkHttp.okHttp)
    implementation(Dependencies.OkHttp.loggingInterceptor)

    implementation(Dependencies.ExoPlayer.core)
    implementation(Dependencies.ExoPlayer.ui)

    debugImplementation(Dependencies.chucker)
    debugImplementation(Dependencies.leakCanary)

    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.mockK)
    testImplementation(Dependencies.Test.robolectric)
    testImplementation(Dependencies.KotlinX.Coroutines.test)
    testImplementation(Dependencies.AndroidX.Test.junitKtx)
    testImplementation(Dependencies.AndroidX.Test.core)
    testImplementation(Dependencies.AndroidX.Test.archCore)
    androidTestImplementation(Dependencies.Test.junitAndroidX)
    androidTestImplementation(Dependencies.AndroidX.Test.core)
    androidTestImplementation(Dependencies.AndroidX.Test.junitKtx)
    androidTestImplementation(Dependencies.AndroidX.Test.espressoCore)
    androidTestImplementation(Dependencies.AndroidX.Test.rules)
    androidTestImplementation(Dependencies.AndroidX.Test.Ext.junit)
}
