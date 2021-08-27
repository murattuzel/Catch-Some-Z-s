object Dependencies {
    const val material = "com.google.android.material:material:1.4.0"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val threeTenAbp = "com.jakewharton.threetenabp:threetenabp:1.3.1"
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.7"
    const val chucker = "com.github.chuckerteam.chucker:library:3.4.0"
    const val coil = "io.coil-kt:coil:1.3.2"

    object Kotlin {
        private const val version = "1.5.21"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val coreKtx = "androidx.core:core-ktx:1.6.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.0"
        const val appStartup = "androidx.startup:startup-runtime:1.0.0"

        object Lifecycle {
            private const val version = "2.3.1"
            const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Navigation {
            private const val version = "2.3.5"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Test {
            private const val version = "1.3.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"
            const val junitKtx = "androidx.test.ext:junit-ktx:1.1.2"
            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
            const val archCore = "androidx.arch.core:core-testing:2.1.0"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }
        }
    }

    object KotlinX {
        object Coroutines {
            private const val version = "1.5.1"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }

        object Serialization {
            private const val version = "1.2.1"
            const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        }
    }

    object Dagger {
        private const val version = "2.38.1"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:$version"

    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitSerializer =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    }

    object OkHttp {
        const val bom = "com.squareup.okhttp3:okhttp-bom:4.9.1"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object ExoPlayer {
        private const val version = "2.15.0"
        const val core = "com.google.android.exoplayer:exoplayer-core:$version"
        const val ui = "com.google.android.exoplayer:exoplayer-ui:$version"
    }

    object Test {
        const val junit = "junit:junit:4.13"
        const val junitAndroidX = "androidx.test.ext:junit:1.1.2"
        const val mockK = "io.mockk:mockk:1.12.0"
        const val robolectric = "org.robolectric:robolectric:4.6.1"
    }
}
