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

inline fun <reified T : Parcelable> Bundle.getParcelableArrayList(key: String): ArrayList<T>? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelableArrayList(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableArrayList(key)
}

inline fun <reified T: Parcelable> Bundle.getParcelableArray(key: String): Array<out Parcelable>? = when {
    Build.VERSION.SDK_INT >= 33 -> getParcelableArray(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableArray(key)
}