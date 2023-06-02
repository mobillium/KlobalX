package com.mobillium.klobalx.nativeext

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment


fun Activity.showKeyboard() =
    WindowCompat.getInsetsController(window, window.decorView).show(WindowInsetsCompat.Type.ime())

fun Fragment.showKeyboard() = requireActivity().showKeyboard()

fun Activity.hideKeyboard() =
    WindowCompat.getInsetsController(window, window.decorView).hide(WindowInsetsCompat.Type.ime())

fun Fragment.hideKeyboard() = requireActivity().hideKeyboard()

fun EditText.showKeyboard() {
    requestFocus()
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}
