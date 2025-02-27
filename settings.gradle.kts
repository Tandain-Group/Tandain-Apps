pluginManagement {
    includeBuild("buildLogic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "Tandain"
include(":app")

include(":data")
include(":domain")
include(":shared")
include(":utils")

include(":core")
include(":core:network")
include(":core:database")
include(":core:resources")
include(":core:component")
include(":core:datastore")
include(":core:navigation")

include(":features")
include(":features:home")
include(":features:splashscreen")
