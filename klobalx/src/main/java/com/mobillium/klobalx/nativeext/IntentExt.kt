package com.mobillium.klobalx.nativeext

import android.content.Intent
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Parcelable

inline fun <reified T : Parcelable> Intent.getParcelable(key: String): T? = when {
    SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}