import com.ecommerce.buildlogic.utils.Modules

plugins {
    alias(libs.plugins.tandain.application)
    alias(libs.plugins.tandain.app.compose)
}

android {
    namespace = "com.tandain.tandainapps"

    // INI APA???? :V
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(Modules.Core.NAVIGATION))
    implementation(project(Modules.Features.HOME))

    implementation(libs.androidx.activity)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}