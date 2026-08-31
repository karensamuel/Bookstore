plugins {
    alias(libs.plugins.android.library)

    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.bookinfo.presentation"
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
    // Android
    implementation(Dependencies.coreKtx)

    // Compose
    compose()

    // Debug
    debugImplementation(Dependencies.composeUiTooling)

    // Modules
    coreDomain()
    bookInfoDomain()

    // Compose Icons
    implementation(Dependencies.composeMaterialIconsExtended)

    // Coil
    implementation(Dependencies.coilCompose)

    // Lifecycle
    implementation(Dependencies.lifecycleViewModelKtx)

    // Koin
    koin()

    // Immutable Collections
    implementation(Dependencies.immutableCollections)

    // Testing
    test()
}
