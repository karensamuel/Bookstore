plugins {
    alias(libs.plugins.dev.karen.android.library.compose)
}

android {
    namespace = "com.example.book.presentation"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation(libs.coil.compose)

    implementation(libs.koin.android)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(project(":core:domain"))
    implementation(project(":book:domain"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.koin.androidx.compose)
    implementation(libs.kotlinx.collections.immutable)
}