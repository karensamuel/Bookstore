plugins {
    alias(libs.plugins.ksp)
alias(libs.plugins.dev.karen.android.bookhistory)
}

android {
    namespace = "com.example.history.data"
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    implementation(libs.kotlinx.collections.immutable)

    //room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    //koin
    implementation(libs.koin.android)

    implementation(project(":history:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
}