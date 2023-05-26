package com.mobillium.klobalx.nativeext

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import java.io.IOException

@Suppress("DEPRECATION")
fun Uri.toBitmap(context: Context): Bitmap? {
    val contentResolver: ContentResolver = context.contentResolver

    var bitmap: Bitmap? = null
    if (Build.VERSION.SDK_INT >= 29) {
        val source: ImageDecoder.Source = ImageDecoder.createSource(contentResolver, this)
        try {
            bitmap = ImageDecoder.decodeBitmap(source)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    } else {
        try {
            bitmap = MediaStore.Images.Media.getBitmap(contentResolver, this)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    return bitmap
}