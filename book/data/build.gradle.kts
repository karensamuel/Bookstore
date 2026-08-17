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
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    implementation(project(":book:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.koin.android)

}