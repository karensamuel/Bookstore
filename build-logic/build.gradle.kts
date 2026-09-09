plugins { //enable writting kotlin with pugin language
    `kotlin-dsl`
}
group = "com.example.convention.buildLogic"
dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}
gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "dev.karen.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "dev.karen.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "dev.karen.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "dev.karen.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("jvmLibrary") {
            id = "dev.karen.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
        register("searchBook") {
            id = "dev.karen.android.searchbook"
            implementationClass = "moduleplugins.SearchBookConventionPlugin"
        }
        register("core") {
            id = "dev.karen.android.core"
            implementationClass = "moduleplugins.CoreConventionPlugin"
        }
        register("book") {
            id = "dev.karen.android.book"
            implementationClass = "moduleplugins.BookConventionPlugin"
        }
        register("bookInfo") {
            id = "dev.karen.android.bookInfo"
            implementationClass = "moduleplugins.BookInfoConventionPlugin"
        }
        register("bookHistory") {
            id = "dev.karen.android.bookHistory"
            implementationClass = "moduleplugins.BookHistoryConventionPlugin"
        }

    }
}
