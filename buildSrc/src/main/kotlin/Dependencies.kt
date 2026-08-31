import org.gradle.api.artifacts.dsl.DependencyHandler

import org.gradle.kotlin.dsl.project

object Dependencies {

    // ==================== Build Plugins ====================

    const val androidGradlePlugin =
        "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"

    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"


    // ==================== Android ====================

    const val appCompat =
        "androidx.appcompat:appcompat:${Versions.appCompat}"

    const val material =
        "com.google.android.material:material:${Versions.material}"
    const val coreKtx =
        "androidx.core:core-ktx:${Versions.coreKtx}"

    const val activityCompose =
        "androidx.activity:activity-compose:${Versions.activityCompose}"

    const val lifecycleRuntimeKtx =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigation}"

    const val navigationRuntimeKtx =
        "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"


    // ==================== Compose ====================

    const val composeMaterial =
        "androidx.compose.material3:material3:${Versions.composeMaterial3}"

    const val composeUi =
        "androidx.compose.ui:ui:${Versions.compose}"

    const val composeUiGraphics =
        "androidx.compose.ui:ui-graphics:${Versions.compose}"

    const val composeUiTooling =
        "androidx.compose.ui:ui-tooling:${Versions.compose}"

    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"

    const val composeRuntime =
        "androidx.compose.runtime:runtime:${Versions.compose}"


    // ==================== Ktor ====================

    const val ktorClientCore =
        "io.ktor:ktor-client-core:${Versions.ktor}"

    const val ktorClientAndroid =
        "io.ktor:ktor-client-android:${Versions.ktor}"

    const val ktorContentNegotiation =
        "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"

    const val ktorSerializationKotlinxJson =
        "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"


    // ==================== Koin ====================

    const val koinAndroid =
        "io.insert-koin:koin-android:${Versions.koin}"

    const val koinCompose =
        "io.insert-koin:koin-androidx-compose:${Versions.koin}"


    // ==================== Kotlin ====================

    const val immutableCollections =
        "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.immutableCollections}"


    // ==================== Room ====================

    const val roomRuntime =
        "androidx.room:room-runtime:${Versions.room}"

    const val roomCompiler =
        "androidx.room:room-compiler:${Versions.room}"

    const val roomKtx =
        "androidx.room:room-ktx:${Versions.room}"


    // ==================== Testing ====================

    const val junit =
        "junit:junit:${Versions.junit}"

    const val androidXJunit =
        "androidx.test.ext:junit:${Versions.androidXJunit}"

    const val espressoCore =
        "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val composeUiTestJunit4 =
        "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    const val composeUiTestManifest =
        "androidx.compose.ui:ui-test-manifest:${Versions.compose}"
    // ==================== Coil ====================

    const val coilCompose =
        "io.coil-kt:coil-compose:${Versions.coil}"
    const val composeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"
}
// ==================== Dependency Functions ====================

fun DependencyHandler.ktor() {
    implementation(Dependencies.ktorClientCore)
    implementation(Dependencies.ktorClientAndroid)
    implementation(Dependencies.ktorContentNegotiation)
    implementation(Dependencies.ktorSerializationKotlinxJson)
}

fun DependencyHandler.koin() {
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.koinCompose)
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeUiToolingPreview)
    implementation(Dependencies.composeMaterial)
}
fun DependencyHandler.android() {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.lifecycleViewModelKtx)
    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.navigationRuntimeKtx)
}
fun DependencyHandler.test() {
    test(Dependencies.junit)

    androidTest(Dependencies.androidXJunit)
    androidTest(Dependencies.espressoCore)
    androidTest(Dependencies.composeUiTestJunit4)

    debugImplementation(Dependencies.composeUiTestManifest)
}
// ==================== Module Dependencies ====================

fun DependencyHandler.coreDomain() {
    implementation(project(":core:domain"))
}

fun DependencyHandler.coreData() {
    implementation(project(":core:data"))
}

fun DependencyHandler.bookDomain() {
    implementation(project(":book:domain"))
}

fun DependencyHandler.bookPresentation() {
    implementation(project(":book:presentation"))
}

fun DependencyHandler.bookData() {
    implementation(project(":book:data"))
}

fun DependencyHandler.bookInfoPresentation() {
    implementation(project(":bookinfo:presentation"))
}

fun DependencyHandler.bookInfoDomain() {
    implementation(project(":bookinfo:domain"))
}

fun DependencyHandler.bookInfoData() {
    implementation(project(":bookinfo:data"))
}

fun DependencyHandler.searchBookPresentation() {
    implementation(project(":searchbook:presentation"))
}

fun DependencyHandler.searchBookDomain() {
    implementation(project(":searchbook:domain"))
}

fun DependencyHandler.searchBookData() {
    implementation(project(":searchbook:data"))
}
fun DependencyHandler.androidUi() {
    implementation(Dependencies.appCompat)
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.material)
}
fun DependencyHandler.koinAndroid() {
    implementation(Dependencies.koinAndroid)
}