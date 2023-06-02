package com.mobillium.klobalx.nativeext

import android.content.Context
import androidx.fragment.app.Fragment

context(Context)
fun Number.dpInPixels(): Int {
    return convertDpToPixels(this@Context, this)
}

context(Fragment)
fun Number.dpInPixels(): Int {
    return convertDpToPixels(requireContext(), this)
}

private fun convertDpToPixels(context: Context, dp: Number): Int {
    return (dp.toFloat() * context.resources.displayMetrics.density).toInt()
}