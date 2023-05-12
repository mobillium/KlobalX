package com.mobillium.klobalx.nativeext

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.drawable(@DrawableRes resId: Int) = ContextCompat.getDrawable(this, resId)

fun Context.color(@ColorRes resId: Int) = ContextCompat.getColor(this, resId)

fun Context.dimension(@DimenRes resId: Int) = this.resources.getDimensionPixelSize(resId)
