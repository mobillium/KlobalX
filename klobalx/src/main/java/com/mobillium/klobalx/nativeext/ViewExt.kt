package com.mobillium.klobalx.nativeext

import android.view.View
import androidx.annotation.DimenRes

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.width(@DimenRes widthRes: Int) {
    with(layoutParams) {
        width = context.resources.getDimensionPixelSize(widthRes)
    }
}

fun View.height(@DimenRes heightRes: Int) {
    with(layoutParams) {
        height = context.resources.getDimensionPixelSize(heightRes)
    }
}
