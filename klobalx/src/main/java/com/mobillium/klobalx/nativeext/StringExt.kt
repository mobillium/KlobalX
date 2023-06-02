package com.mobillium.klobalx.nativeext

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan

fun String.getColorizedSpannable(
    vararg strings: String,
    color: Int,
    flags: Int = Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
): SpannableString {
    return SpannableString(this).apply {
        strings.forEach { string ->
            val startIndex = this.indexOf(string)
            val endIndex = startIndex + string.length

            setSpan(
                ForegroundColorSpan(color),
                startIndex,
                endIndex,
                flags
            )
        }
    }
}