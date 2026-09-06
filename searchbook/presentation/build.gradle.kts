plugins {
    alias(libs.plugins.dev.karen.android.library.compose)
}

android {
    namespace = "com.example.searchbook.presentation"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(project(":searchbook:domain"))

    implementation(project(":core:domain"))
    implementation(libs.koin.android)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.koin.androidx.compose)
    implementation(libs.kotlinx.collections.immutable)


    // Compose tooling
    debugImplementation(libs.androidx.compose.ui.tooling)
}