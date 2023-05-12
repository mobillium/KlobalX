package com.mobillium.klobalx.nativeext

import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.width(@DimenRes width: Int) {
    val layoutParams = this.layoutParams

    layoutParams.width = context.resources.getDimensionPixelSize(width)
    this.layoutParams = layoutParams
}

fun View.height(@DimenRes height: Int) {
    val layoutParams = this.layoutParams

    layoutParams.height = context.resources.getDimensionPixelSize(height)
    this.layoutParams = layoutParams
}