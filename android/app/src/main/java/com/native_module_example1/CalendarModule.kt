package com.native_module_example1

import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import android.util.Log
import android.widget.Toast


class CalendarModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    // add to CalendarModule.kt
    override fun getName() = "CalendarModule"

    @ReactMethod(isBlockingSynchronousMethod = true)
    fun createCalendarEvent(name: String, location: String) {
        Log.d("CalendarModule", "Create event called with name: $name and location: $location")

        Toast.makeText(reactApplicationContext, "gfhfghghj", Toast.LENGTH_SHORT)
    }

}