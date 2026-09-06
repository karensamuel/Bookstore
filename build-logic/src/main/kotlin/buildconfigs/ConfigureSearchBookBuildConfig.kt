package buildconfigs

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.configureSearchBuildConfig() {
    buildTypes.configureEach {
        buildConfigField(
            "String",
            "SEARCH_ENDPOINT",
            "\"search.json\""
        )
    }

}
