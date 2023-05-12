package com.mobillium.klobalx.nativeext

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.window.layout.WindowMetricsCalculator

inline val Activity.className: String
    get() = this::class.java.simpleName

fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Activity.openSettingsApp() {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
    val uri =
        Uri.fromParts("package", packageName, null)
    intent.data = uri
    startActivity(intent)
}

val Activity.windowHeight: Int
    get() {
        val windowMetrics =
            WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this)

        return windowMetrics.bounds.height()
    }
