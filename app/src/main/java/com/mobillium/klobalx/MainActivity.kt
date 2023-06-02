package com.mobillium.klobalx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mobillium.klobalx.nativeext.dpInPixels
import com.mobillium.klobalx.nativeext.gone

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.textview_welcome)?.run {
            gone()
        }

        //dp-to-px conversion
        val intDpValue = 5
        intDpValue.dpInPixels()
        val floatDpValue = 5f
        floatDpValue.dpInPixels()
        val doubleDpValue = 5.00
        doubleDpValue.dpInPixels()
    }
}