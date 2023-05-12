package com.mobillium.klobalx.nativeext

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan

fun String.getColorizedSpannable(
    flags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
    color: Int,
    vararg strings: String
): SpannableString {
    return SpannableString(this).apply {
        for (i in strings.indices) {

            val startIndex = this.indexOf(strings.get(i))
            val endIndex = startIndex + strings.get(i).length

            setSpan(
                ForegroundColorSpan(color),


                startIndex,
                endIndex,
                flags
            )
        }
    }
}