package com.mobillium.klobalx.nativeext

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.window.layout.WindowMetricsCalculator

private const val PACKAGE_SCHEME = "package"

/**
 * Returns the simple name of the Activity's class.
 */
inline val Activity.className: String
    get() = this::class.java.simpleName

/**
 * Displays a toast message on the screen.
 *
 * @param message The text message to be displayed in the toast.
 * @param duration Optional duration of the toast.
 */
fun Activity.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

/**
 * Opens the settings screen for the current application.
 */
fun Activity.openSettingsApp() {
    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        data = Uri.fromParts(PACKAGE_SCHEME, packageName, null)
        startActivity(this)
    }
}

/**
 * Property representing the height of the activity's window in pixels.
 *
 * @return The height of the activity's window in pixels.
 */
val Activity.windowHeight: Int
    get() {
        val windowMetrics =
            WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this)

        return windowMetrics.bounds.height()
    }
