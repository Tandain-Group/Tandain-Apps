plugins {
    alias(libs.plugins.tandain.library)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.tandain.tandainapps.navigation"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.navigation.runtime.ktx)
}
