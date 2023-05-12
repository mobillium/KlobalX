package com.mobillium.klobalx.nativeext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment


fun Activity.hideKeyboard() {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val focusedView = currentFocus ?: View(this)
    inputMethodManager.hideSoftInputFromWindow(focusedView.windowToken, 0)
}

fun Fragment.hideKeyboard() {
    val inputMethodManager = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val focusedView = activity?.currentFocus ?: View(context)
    inputMethodManager.hideSoftInputFromWindow(focusedView.windowToken, 0)
}

fun EditText.hideKeyboard() {
    clearFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager?.hideSoftInputFromWindow(windowToken, 0)
}


fun EditText.showKeyboard() {
    requestFocus()
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}