package com.mobillium.klobalx.nativeext

import android.os.Build
import android.os.Bundle
import android.os.Parcelable

inline fun <reified T : Parcelable> Bundle?.getParcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> this?.getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") (this?.getParcelable(key)) as? T
}