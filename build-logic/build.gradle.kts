plugins { //enable writting lotlin with pugin language
    `kotlin-dsl`
}
group = "com.example.convention.buildLogic"
dependencies{
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}
gradlePlugin {
    plugins{
        register("androidLibrary"){
            id = "dev.karen.android.library"
            implementationClass ="AndroidLibraryConventionPlugin"
        }

    }
}