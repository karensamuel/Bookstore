plugins {
    alias(libs.plugins.dev.karen.android.library.compose)
}

android {
    namespace = "com.example.bookinfo.presentation"
}

dependencies {
    // Android
    implementation(libs.androidx.core.ktx)

    // Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // Preview / Debug
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(project(":core:domain"))
    implementation(project(":bookinfo:domain"))
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    implementation(libs.coil.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.koin.android)

}
