plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)

}

android {
    namespace = "com.example.searchbook.presentation"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }

}

dependencies {
    // Android
    androidUi()

    // Compose
    compose()

    // Compose Icons
    implementation(Dependencies.composeMaterialIconsExtended)

    // Modules
    searchBookDomain()
    coreDomain()

    // Koin
    koin()

    // Lifecycle
    implementation(Dependencies.lifecycleViewModelKtx)

    // Immutable Collections
    implementation(Dependencies.immutableCollections)

    // Testing
    test()
}