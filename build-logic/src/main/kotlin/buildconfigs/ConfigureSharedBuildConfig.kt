package buildconfigs

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.configureSharedBuildConfig(size: String) {
    buildTypes.configureEach {
        buildConfigField(
            "String",
            "COVER_BASE_URL",
            "\"https://covers.openlibrary.org/b/id/\""
        )

        buildConfigField(
            "String",
            "COVER_SIZE",
            "\"$size\""
        )
    }
}