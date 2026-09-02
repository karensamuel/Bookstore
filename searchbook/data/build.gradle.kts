plugins {
    alias(libs.plugins.dev.karen.android.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.searchbook.data"



    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            buildConfigField(
                "String",
                "SEARCH_ENDPOINT",
                "\"search.json\""
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
                "SEARCH_ENDPOINT",
                "\"search.json\""
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

    implementation(project(":searchbook:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))

    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)

    implementation(libs.koin.android)

}