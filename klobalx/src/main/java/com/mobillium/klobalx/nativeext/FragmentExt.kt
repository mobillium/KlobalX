package com.mobillium.klobalx.nativeext

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackBar(snackBarText: String, timeLength: Int = Snackbar.LENGTH_SHORT) {
    requireActivity().let {
        Snackbar.make(it.findViewById(android.R.id.content), snackBarText, timeLength).show()
    }
}