package com.tandain.tandainapps.buildlogic.plugins

import com.android.build.gradle.LibraryExtension
import com.tandain.tandainapps.buildlogic.ext.configureKotlinAndroid
import com.tandain.tandainapps.buildlogic.ext.libs
import com.tandain.tandainapps.buildlogic.utils.AppConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class TandainLibraryPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.library")
            apply(plugin = "org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
            }
        }
    }
}