import com.tandain.tandainapps.buildlogic.utils.Modules

plugins {
    alias(libs.plugins.tandain.library)
}

android {
    namespace = "com.tandain.tandainapps.component"
}

dependencies {
    implementation(project(Modules.Core.RESOURCES))
    implementation(project(Modules.Core.NAVIGATION))

    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
