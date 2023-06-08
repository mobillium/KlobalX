package com.mobillium.klobalx.nativeext

import android.content.Intent
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Parcelable

/**
 * Retrieves the Parcelable object with the specified key from the Intent extras.
 *
 * @param key The key associated with the Parcelable object in the Intent extras.
 * @return Parcelable object, or null if it's not found or incompatible with the specified type.
 */
inline fun <reified T : Parcelable> Intent.getParcelable(key: String): T? = when {
    SDK_INT >= Build.VERSION_CODES.TIRAMISU -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}

inline fun <reified T : Parcelable> Intent.getParcelableArrayList(key: String): ArrayList<T>? =
    when {
        SDK_INT >= 33 -> getParcelableArrayListExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelableArrayListExtra(key)
    }