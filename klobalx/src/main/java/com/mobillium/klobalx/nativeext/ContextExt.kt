package com.mobillium.klobalx.nativeext

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.PersistableBundle
import java.util.Locale

private const val EXTRA_IS_SENSITIVE = "android.content.extra.IS_SENSITIVE"

/**
 * Copies the provided text to the clipboard in the Android context.
 *
 * @param text The text to be copied.
 * @param isSensitive Determines whether the copied text is considered sensitive or not.
 */
fun Context.copyToClipboard(text: String, isSensitive: Boolean = false) {
    ClipData.newPlainText(
        EMPTY_STRING,
        text
    ).also { clipData ->

        (getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager)?.let { clipboardManager ->
            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> {
                    clipData.description.extras = PersistableBundle().apply {
                        putBoolean(ClipDescription.EXTRA_IS_SENSITIVE, isSensitive)
                    }
                }

                Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                    clipData.description.extras = PersistableBundle().apply {
                        putBoolean(EXTRA_IS_SENSITIVE, true)
                    }
                }
            }

            clipboardManager.setPrimaryClip(clipData)
        }
    }
}

/**
 * Checks if an app with the specified package name is installed on the device.
 *
 * @param packageName The package name of the app to check.
 * @return `true` if the app is installed, `false` otherwise.
 */
fun Context.isAppInstalledOnDevice(packageName: String): Boolean {
    runCatching {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager.getApplicationInfo(
                packageName,
                PackageManager.ApplicationInfoFlags.of(PackageManager.GET_META_DATA.toLong())
            )

            return true
        }
        @Suppress("DEPRECATION")
        packageManager.getApplicationInfo(
            packageName,
            PackageManager.GET_META_DATA
        )

        return true
    }.getOrElse {
        return false
    }
}

/**
 * Sets the application locale to the specified language and returns a new Context instance with
 * the updated configuration.
 *
 * @param language The language code to set the application locale to.
 * @return A new Context instance with the updated configuration reflecting the specified language.
 */
fun Context.setAppLocale(language: String): Context {
    val locale = Locale(language).also {
        Locale.setDefault(it)
    }

    val config = resources.configuration.apply {
        setLocale(locale)
        setLayoutDirection(locale)
    }

    return createConfigurationContext(config)
}

fun Context.drawable(@DrawableRes resId: Int) = ContextCompat.getDrawable(this, resId)

fun Context.color(@ColorRes resId: Int) = ContextCompat.getColor(this, resId)

fun Context.dimension(@DimenRes resId: Int) = this.resources.getDimensionPixelSize(resId)

