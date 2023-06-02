package com.mobillium.klobalx.nativeext

import android.os.Build
import android.os.Bundle
import android.os.Parcelable

/**
 * Retrieves the Parcelable object with the specified key from the Bundle.
 *
 * @param key The key associated with the Parcelable object in the Bundle.
 * @return Parcelable object, or null if it's not found or incompatible with the specified type.
 */
inline fun <reified T : Parcelable> Bundle?.getParcelable(key: String): T? = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> this?.getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") (this?.getParcelable(key)) as? T
}