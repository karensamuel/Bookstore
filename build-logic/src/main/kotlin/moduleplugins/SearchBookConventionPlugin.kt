package moduleplugins

import buildconfigs.configureSearchBuildConfig
import buildconfigs.configureSharedBuildConfig
import com.android.build.api.dsl.LibraryExtension
import ext.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SearchBookConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {

            pluginManager.apply("dev.karen.android.library")

            val libs = versionCatalog()

            extensions.configure<LibraryExtension> {

                buildFeatures {
                    buildConfig = true
                }
                configureSharedBuildConfig("M")
                configureSearchBuildConfig()
            }
        }
    }
}