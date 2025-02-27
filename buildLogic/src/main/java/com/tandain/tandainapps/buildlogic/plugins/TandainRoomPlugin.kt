package com.tandain.tandainapps.buildlogic.plugins

import com.google.devtools.ksp.gradle.KspExtension
import com.tandain.tandainapps.buildlogic.ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class TandainRoomPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.google.devtools.ksp")
            extensions.configure<KspExtension> {
                arg("room.generateKotlin", "true")
            }
            configureRoomDependencies()
        }
    }

    private fun Project.configureRoomDependencies() {
        dependencies {
            add("implementation", libs.findLibrary("room-runtime").get())
            add("implementation", libs.findLibrary("room-ktx").get())
            add("ksp", libs.findLibrary("room-compiler").get())
        }
    }
}
