plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)

}

android {
    namespace = "com.example.bookinfo.data"
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
                "BOOK_INFO_ENDPOINT",
                "\"works/\""
            )
            buildConfigField(
                "String",
                "COVER_BASE_URL",
                "\"https://covers.openlibrary.org/b/id/\""
            )
            buildConfigField(
                "String",
                "COVER_SIZE",
                "\"L\""
            )
            buildConfigField(
                "String",
                "JSON_TYPE",
                "\".json\""
            )
            buildConfigField(
                "String",
                "BOOK_AUTHOR_ENDPOINT",
                "\"authors/\""
            )
        }
        debug {
            buildConfigField(
                "String",
                "BOOK_INFO_ENDPOINT",
                "\"works/\""
            )
            buildConfigField(
                "String",
                "COVER_BASE_URL",
                "\"https://covers.openlibrary.org/b/id/\""
            )
            buildConfigField(
                "String",
                "COVER_SIZE",
                "\"L\""
            )
            buildConfigField(
                "String",
                "JSON_TYPE",
                "\".json\""
            )
            buildConfigField(
                "String",
                "BOOK_AUTHOR_ENDPOINT",
                "\"authors/\""
            )
        }
    }

}

dependencies {
    androidUi()

    bookInfoDomain()
    coreDomain()
    coreData()

    ktor()

    koin()

    implementation(Dependencies.immutableCollections)

    test()
}