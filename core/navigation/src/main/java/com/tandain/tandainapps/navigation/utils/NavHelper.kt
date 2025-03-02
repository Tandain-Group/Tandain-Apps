package com.tandain.tandainapps.navigation.utils

import com.tandain.tandainapps.navigation.utils.DeepLinkConstant.DEEP_LINK_SCHEME_AND_HOST

object NavHelper {
    fun String.toDeeplinkBasePath() : String {
        return "$DEEP_LINK_SCHEME_AND_HOST/$this"
    }
}
