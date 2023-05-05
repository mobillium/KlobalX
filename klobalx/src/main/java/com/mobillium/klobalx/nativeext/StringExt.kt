package com.mobillium.klobalx.nativeext

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan

fun String.getColorizedSpannable(color: Int, vararg strings: String): SpannableString {
    return SpannableString(this).apply {
        for (i in strings.indices) {

            val startIndex = this.indexOf(strings.get(i))
            val endIndeks = startIndex + strings.get(i).length

            setSpan(
                ForegroundColorSpan(color),


                startIndex,
                endIndeks,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }
}