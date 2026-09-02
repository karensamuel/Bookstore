import com.android.build.api.dsl.LibraryExtension
import ext.configureKotlin
import ext.version
import ext.versionCatalog
import org.gradle.api.Project
import org.gradle.api.Plugin
import kotlin.jvm.java

class AndroidLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
     with(target){
         pluginManager.apply("com.android.library")
         val libs = versionCatalog()
         extensions.configure(LibraryExtension::class.java){
             compileSdk = libs.version("compileSdk").toInt()
             defaultConfig{
                 minSdk = libs.version("minSdk").toInt()

                 testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

             }
         }
         configureKotlin()
     }
    }
}