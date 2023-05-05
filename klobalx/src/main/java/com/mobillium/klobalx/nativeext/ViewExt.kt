package com.mobillium.klobalx.nativeext

import android.view.View

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility =
        View.INVISIBLE
}
