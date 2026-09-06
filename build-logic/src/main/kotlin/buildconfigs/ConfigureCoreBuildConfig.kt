package buildconfigs

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.configureCoreBuildConfig() {
    buildTypes.configureEach {
        buildConfigField(
            "String",
            "BASE_URL",
            "\"https://openlibrary.org/\""
        )
    }
}
