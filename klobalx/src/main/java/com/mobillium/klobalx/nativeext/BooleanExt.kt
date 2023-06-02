package com.mobillium.klobalx.nativeext

val Boolean?.orFalse: Boolean
    get() = this ?: false
