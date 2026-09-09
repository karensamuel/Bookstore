package ext

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

fun Project.configureKotlin() {
    extensions.configure(KotlinAndroidProjectExtension::class.java) {
        jvmToolchain(17)
    }
}

fun Project.configureKotlinJvm() {
    extensions.configure(KotlinJvmProjectExtension::class.java) {
        jvmToolchain(17)
    }
}