plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.book.data"
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
        buildConfig = true
    }

    buildTypes {
        release {

            buildConfigField(
                "String",
                "GET_BOOKS_ENDPOINT",
                "\"trending/now.json\""
            )
            buildConfigField(
                "String",
                "COVER_BASE_URL",
                "\"https://covers.openlibrary.org/b/id/\""
            )
            buildConfigField(
                "String",
                "COVER_SIZE",
                "\"M\""
            )
        }
        debug {
            buildConfigField(
                "String",
                "GET_BOOKS_ENDPOINT",
                "\"trending/now.json\""
            )
            buildConfigField(
                "String",
                "COVER_BASE_URL",
                "\"https://covers.openlibrary.org/b/id/\""
            )
            buildConfigField(
                "String",
                "COVER_SIZE",
                "\"M\""
            )
        }
    }

}

dependencies {
    androidUi()
    ktor()
    koinAndroid()
    test()

    coreDomain()
    coreData()
    bookDomain()
}