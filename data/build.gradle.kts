import com.tandain.tandainapps.buildlogic.utils.Modules

plugins {
    alias(libs.plugins.tandain.library)
}

android {
    namespace = "com.tandain.tandainapps.data"
}

dependencies {
    implementation(project(Modules.DOMAIN))
    // Data sources
    implementation(project(Modules.Core.DATASTORE))
    implementation(project(Modules.Core.DATABASE))
    implementation(project(Modules.Core.NETWORK))
}