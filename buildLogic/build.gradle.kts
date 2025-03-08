plugins {
    `kotlin-dsl`
}

group = "com.tandain.tandainapps.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        create("tandainApplicationPlugin") {
            id = libs.plugins.tandain.application.get().pluginId
            implementationClass = "com.tandain.tandainapps.buildlogic.plugins.TandainApplicationPlugin"
        }
        create("tandainComposeApplicationPlugin") {
            id = libs.plugins.tandain.app.compose.get().pluginId
            implementationClass = "com.tandain.tandainapps.buildlogic.plugins.TandainComposeApplicationPlugin"
        }
        create("tandainComposeLibraryPlugin") {
            id = libs.plugins.tandain.lib.compose.get().pluginId
            implementationClass = "com.tandain.tandainapps.buildlogic.plugins.TandainComposeLibraryPlugin"
        }
        create("tandainLibraryPlugin") {
            id = libs.plugins.tandain.library.get().pluginId
            implementationClass = "com.tandain.tandainapps.buildlogic.plugins.TandainLibraryPlugin"
        }
        create("tandainFeaturePlugin") {
            id = libs.plugins.tandain.feature.get().pluginId
            implementationClass = "com.tandain.tandainapps.buildlogic.plugins.TandainFeaturePlugin"
        }
        create("tandainRoomPlugin") {
            id = libs.plugins.tandain.room.get().pluginId
            implementationClass = "com.tandain.tandainapps.buildlogic.plugins.TandainRoomPlugin"
        }
    }
}
