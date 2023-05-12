package com.mobillium.klobalx.nativeext

import android.text.InputFilter
import android.text.Spanned
import android.widget.EditText

fun EditText.rejectEmojis() {
    filters += arrayOf(object : InputFilter {
        override fun filter(
            source: CharSequence?,
            start: Int,
            end: Int,
            dest: Spanned?,
            dstart: Int,
            dend: Int
        ): CharSequence? {
            for (index in start until end) {
                val type = Character.getType(source?.get(index) ?: '\u0000')
                if (type == Character.SURROGATE.toInt() || type == Character.OTHER_SYMBOL.toInt()) {
                    return EMPTY_STRING
                }
            }
            return null
        }
    })
}
