plugins {
    alias(libs.plugins.dev.karen.jvm.library)
}

dependencies {
    implementation(project(":core:domain"))
}
