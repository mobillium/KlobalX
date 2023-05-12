package com.mobillium.klobalx

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mobillium.klobalx.nativeext.edit
import com.mobillium.klobalx.nativeext.get
import com.mobillium.klobalx.nativeext.put
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Locale

@RunWith(AndroidJUnit4::class)
class SharedPreferencesExtensionsInstrumentedTest {
    private lateinit var sharedPreferences: SharedPreferences

    @Before
    fun setup() {
        val context: Context = ApplicationProvider.getApplicationContext()
        sharedPreferences = context.getSharedPreferences("test_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit { clear() }
    }

    @Test
    fun testSharedPreferencesExtensions() {
        // Put values into SharedPreferences
        sharedPreferences.put(
            "name" to "John",
            "age" to 25,
            "isMarried" to true,
            "length" to 2.1f,
            "long" to 21L,
        )

        defaultAssert()
    }

    @Test
    fun `testSharedPreferencesExtensions put Different way`() {
        // Put values into SharedPreferences
        sharedPreferences.put(
            "name" to "John",
            "age" to 25,
            "isMarried" to true,
            "length" to 2.1f,
            "long" to 21L
        )

        defaultAssert()
    }

    @Test
    fun `testSharedPreferencesExtensions Put None`() {
        // Put values into SharedPreferences
        sharedPreferences.put()


        val name = sharedPreferences.get<String>("name")
        val age = sharedPreferences.get<Int>("age")
        val isMarried = sharedPreferences.get<Boolean>("isMarried")
        val length = sharedPreferences.get<Float>("length")
        val long = sharedPreferences.get<Long>("long")

        // Assert values
        assertEquals(null, name)
        assertEquals(0, age)
        assertEquals(false, isMarried)
        assertEquals(0f, length)
        assertEquals(0L, long)
    }

    @Test
    fun `testSharedPreferencesExtensions Put None But With Default`() {
        // Put values into SharedPreferences
        sharedPreferences.put()


        val name = sharedPreferences.get<String>("name", "John")
        val age = sharedPreferences.get<Int>("age", 25)
        val isMarried = sharedPreferences.get<Boolean>("isMarried", true)
        val length = sharedPreferences.get<Float>("length", 2.1f)
        val long = sharedPreferences.get<Long>("long", 21L)

        // Assert values
        assertEquals("John", name)
        assertEquals(25, age)
        assertEquals(true, isMarried)
        assertEquals(2.1f, length)
        assertEquals(21L, long)
    }

    @Test
    fun `testSharedPreferencesExtensions Put CustomType`() {
        // Put values into SharedPreferences
        assertThrows(UnsupportedOperationException::class.java) {
            sharedPreferences.put("locale" to Locale.CANADA)
        }
    }

    @Test
    fun `testSharedPreferencesExtensions Get CustomType`() {
        // Put values into SharedPreferences
        assertThrows(UnsupportedOperationException::class.java) {
            sharedPreferences.get<Locale>("locale")
        }
    }

    private fun defaultAssert() {
        // Get default values from SharedPreferences
        val name = sharedPreferences.get<String>("name")
        val age = sharedPreferences.get<Int>("age")
        val isMarried = sharedPreferences.get<Boolean>("isMarried")
        val length = sharedPreferences.get<Float>("length")
        val long = sharedPreferences.get<Long>("long")

        // Assert values
        assertEquals("John", name)
        assertEquals(25, age)
        assertEquals(true, isMarried)
        assertEquals(2.1f, length)
        assertEquals(21L, long)
    }

    @After
    fun clear() {
        sharedPreferences.edit { clear() }
    }
}