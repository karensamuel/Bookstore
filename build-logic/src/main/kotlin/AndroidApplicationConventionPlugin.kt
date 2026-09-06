import com.android.build.api.dsl.ApplicationExtension
import ext.configureKotlin
import ext.version
import ext.versionCatalog
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            val libs = versionCatalog()
            extensions.configure(ApplicationExtension::class.java) {
                compileSdk = libs.version("compileSdk").toInt()
                defaultConfig {
                    minSdk = libs.version("minSdk").toInt()
                    targetSdk = libs.version("targetSdk").toInt()

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }
            }
            configureKotlin()
        }
    }
}