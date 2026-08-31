plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.example.core.data"
    compileSdk {
        version = release(37)
    }

    buildFeatures {
        buildConfig = true
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
        buildConfig = true
    }

    buildTypes {
        release {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://openlibrary.org/\""
            )
        }
        debug {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://openlibrary.org/\""
            )
        }
    }
}

dependencies {
    // Android
    androidUi()

    // Ktor
    ktor()

    // Koin
    koin()

    // Modules
    coreDomain()

    // Testing
    test()
}