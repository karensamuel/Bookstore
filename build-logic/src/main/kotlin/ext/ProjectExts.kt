package ext

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

fun Project.configureKotlin(){
    extensions.configure(KotlinAndroidProjectExtension::class.java){
        jvmToolchain(17)
    }
}