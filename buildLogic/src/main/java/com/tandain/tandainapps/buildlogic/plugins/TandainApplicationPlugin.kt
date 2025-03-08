package com.tandain.tandainapps.buildlogic.plugins

import com.android.build.api.dsl.ApplicationExtension
import com.tandain.tandainapps.buildlogic.utils.AppConfig
import com.tandain.tandainapps.buildlogic.ext.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class TandainApplicationPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.application")
            apply(plugin = "org.jetbrains.kotlin.android")
            apply(plugin = "com.google.gms.google-services")

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureBuildType()
                with(defaultConfig) {
                    targetSdk = AppConfig.TARGET_SDK
                    applicationId = AppConfig.APP_ID
                    versionCode = AppConfig.VERSION_CODE
                    versionName = AppConfig.VERSION_NAME
                }
            }
        }
    }

    private fun ApplicationExtension.configureBuildType() {
        buildTypes {
            // Configure the build type here
            debug {

            }

            release {

            }
        }
    }
}
