plugins {
    alias(libs.plugins.tandain.library)
    alias(libs.plugins.tandain.feature)
}

android {
    namespace = "com.tandain.tandainapps.splashscreen"
}

dependencies {
    implementation(libs.androidx.core.splashscreen)
}
