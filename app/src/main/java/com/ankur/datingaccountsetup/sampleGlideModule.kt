package com.ankur.datingaccountsetup

import com.bumptech.glide.module.AppGlideModule

class sampleGlideModule: AppGlideModule() {

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}