plugins {
    alias(libs.plugins.dev.karen.android.bookinfo)
    alias(libs.plugins.kotlin.serialization)

}

android {
    namespace = "com.example.bookinfo.data"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    implementation(project(":bookinfo:domain"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))

    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.content.negotiation)

    implementation(libs.koin.android)
    implementation(libs.kotlinx.collections.immutable)
}