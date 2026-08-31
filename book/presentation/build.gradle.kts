plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.book.presentation"

    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    androidUi()

    compose()

    implementation(Dependencies.composeMaterialIconsExtended)
   implementation(Dependencies.coilCompose)

    koin()

    implementation(Dependencies.lifecycleViewModelKtx)

    coreDomain()
    bookDomain()

    implementation(Dependencies.immutableCollections)

    test()
}