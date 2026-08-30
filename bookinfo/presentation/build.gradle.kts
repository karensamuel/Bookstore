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
    implementation("androidx.compose.material:material-icons-extended")
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    implementation("io.coil-kt:coil-compose:2.7.0")
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.kotlinx.collections.immutable)
    implementation(libs.koin.android)

}
