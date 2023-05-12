package com.mobillium.klobalx.nativeext

import android.content.SharedPreferences

inline fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
    return when (T::class) {
        String::class -> getString(key, defaultValue as? String) as T?
        Int::class -> getInt(key, defaultValue as? Int ?: 0) as T?
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
        Float::class -> getFloat(key, defaultValue as? Float ?: 0f) as T?
        Long::class -> getLong(key, defaultValue as? Long ?: 0L) as T?
        else -> throw UnsupportedOperationException("Unsupported type") // TODO: Add Gson library and get from GsonSerialization
    }
}

inline fun SharedPreferences.edit(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}

fun SharedPreferences.set(vararg pairs: Pair<String, Any>) {
    val editor = edit()
    pairs.forEach {
        editor.set(it)
    }
    editor.apply()
}

fun SharedPreferences.Editor.set(pair: Pair<String, Any>) {
    val (key: String, value: Any) = pair
    when (value) {
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Boolean -> putBoolean(key, value)
        is Float -> putFloat(key, value)
        is Long -> putLong(key, value)
        else -> throw UnsupportedOperationException("Unsupported type") // TODO: Add Gson library and set GsonSerialization
    }
}

fun SharedPreferences.Editor.set(key: String, value: Any) {
    when (value) {
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Boolean -> putBoolean(key, value)
        is Float -> putFloat(key, value)
        is Long -> putLong(key, value)
        else -> throw UnsupportedOperationException("Unsupported type") // TODO: Add Gson library and set GsonSerialization
    }
}
