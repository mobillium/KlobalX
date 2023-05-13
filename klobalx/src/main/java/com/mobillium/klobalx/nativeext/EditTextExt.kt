package com.mobillium.klobalx.nativeext

import android.text.InputFilter
import android.text.Spanned
import android.widget.EditText

/**
 * This extension function is used to reject emojis from an EditText view.
 * It adds an InputFilter to the EditText's filters array that checks each character
 * being typed or pasted into the EditText. If the character is an emoji, it is rejected
 * and an empty string is returned. This function ensures that the EditText only accepts
 * text input without any emojis.
 */
fun EditText.rejectEmojis() {
    filters += arrayOf(object : InputFilter {
        override fun filter(
            source: CharSequence?,
            start: Int,
            end: Int,
            dest: Spanned?,
            dstart: Int,
            dend: Int,
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
