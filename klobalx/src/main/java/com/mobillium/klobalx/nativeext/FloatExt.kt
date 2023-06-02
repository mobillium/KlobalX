package com.mobillium.klobalx.nativeext

val Float?.orZero: Float
    get() = this ?: 0.0f
