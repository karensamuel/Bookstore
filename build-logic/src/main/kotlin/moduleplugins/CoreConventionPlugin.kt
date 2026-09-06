package moduleplugins

import buildconfigs.configureCoreBuildConfig
import com.android.build.api.dsl.LibraryExtension
import ext.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class CoreConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {

            pluginManager.apply("dev.karen.android.library")

            val libs = versionCatalog()

            extensions.configure<LibraryExtension> {

                buildFeatures {
                    buildConfig = true
                }

                configureCoreBuildConfig()
            }
        }
    }
}