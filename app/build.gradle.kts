plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.bookstore"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.bookstore"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    android()
    compose()
    koin()
    test()

    implementation(Dependencies.immutableCollections)

    coreDomain()
    coreData()

    bookDomain()
    bookPresentation()
    bookData()

    bookInfoPresentation()
    bookInfoDomain()
    bookInfoData()

    searchBookPresentation()
    searchBookDomain()
    searchBookData()}



