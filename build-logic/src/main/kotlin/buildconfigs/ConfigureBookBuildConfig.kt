package buildconfigs

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.configureBookBuildConfig() {
    buildTypes.configureEach {
        buildConfigField(
            "String",
            "GET_BOOKS_ENDPOINT",
            "\"trending/now.json\""
        )
    }
}