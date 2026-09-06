plugins {
    alias(libs.plugins.dev.karen.android.application.compose)

}

android {
    namespace = "com.example.bookstore"

    defaultConfig {
        applicationId = "com.example.bookstore"
        versionCode = 1
        versionName = "1.0"

    }
    buildFeatures {
        buildConfig = true
    }


}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    implementation(libs.koin.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.koin.androidx.compose)
    implementation(libs.kotlinx.collections.immutable)

    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":book:domain"))
    implementation(project(":book:presentation"))
    implementation(project(":book:data"))
    implementation(project(":bookinfo:presentation"))
    implementation(project(":searchbook:presentation"))
    implementation(project(":searchbook:domain"))
    implementation(project(":searchbook:data"))
    implementation(project(":bookinfo:domain"))
    implementation(project(":bookinfo:data"))
}



