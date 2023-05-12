package com.mobillium.klobalx.nativeext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.TypedValue
import java.util.Locale

fun Context.convertDpToPx(dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        this.resources.displayMetrics
    )
}

fun Context.copyToClipboard(text: String) {
    ClipData.newPlainText(
        EMPTY_STRING,
        text
    ).also {
        (getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager)?.setPrimaryClip(it)
    }
}

fun Context.isAppInstalledOnDevice(packageName: String): Boolean {
    runCatching {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager.getApplicationInfo(
                packageName,
                PackageManager.ApplicationInfoFlags.of(PackageManager.GET_META_DATA.toLong())
            )

            return true
        }

        packageManager.getApplicationInfo(
            packageName,
            PackageManager.GET_META_DATA
        )

        return true
    }.getOrElse {
        return false
    }
}

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