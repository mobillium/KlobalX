package com.mobillium.klobalx.nativeext

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackBar(snackBarText: String, timeLength: Int = Snackbar.LENGTH_SHORT) {
    requireActivity().let {
        Snackbar.make(it.findViewById(android.R.id.content), snackBarText, timeLength).show()
    }
}

/**
 * Displays a toast message on the screen.
 *
 * @param message The text message to be displayed in the toast.
 * @param duration Optional duration of the toast.
 */
fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), message, duration).show()
}