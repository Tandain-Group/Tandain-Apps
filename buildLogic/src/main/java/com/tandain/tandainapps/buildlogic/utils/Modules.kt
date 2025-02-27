package com.ecommerce.buildlogic.utils

object Modules {
    const val DATA = ":data"
    const val DOMAIN = ":domain"
    const val SHARED = ":shared"
    const val UTILS = ":utils"

    object Core {
        const val DATA = ":core:data"
        const val DATABASE = ":core:database"
        const val DATASTORE = ":core:datastore"
        const val DOMAIN = ":core:domain"
        const val MODEL = ":core:model"
        const val NETWORK = ":core:network"
        const val RESOURCES = ":core:resources"
        const val COMPONENT = ":core:component"
        const val NAVIGATION = ":core:navigation"
    }

    object Features {
        const val HOME = ":features:home"
        const val SPLASHSCREEN = ":features:splashscreen"
    }
}