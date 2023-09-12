package com.mobillium.klobalx.nativeext

/**
 * If the incoming value is null, we get a false value
 * */
val Boolean?.orFalse: Boolean
    get() = this ?: false

/**
 * If the incoming value is null, we get a true value
 * */
val Boolean?.orTrue: Boolean
    get() = this ?: true