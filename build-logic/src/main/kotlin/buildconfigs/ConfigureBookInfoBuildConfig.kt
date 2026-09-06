package buildconfigs

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.configureBookInfoBuildConfig() {
    buildTypes.configureEach {
        buildConfigField(
            "String",
            "BOOK_INFO_ENDPOINT",
            "\"works/\""
        )


        buildConfigField(
            "String",
            "JSON_TYPE",
            "\".json\""
        )
        buildConfigField(
            "String",
            "BOOK_AUTHOR_ENDPOINT",
            "\"authors/\""
        )
    }
}