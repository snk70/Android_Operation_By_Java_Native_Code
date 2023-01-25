package com.native_module_example1;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;
import java.util.HashMap;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class CalendarModule extends ReactContextBaseJavaModule {

    // add to CalendarModule.java
    @Override
    public String getName() {
        return "CalendarModule";
    }

    CalendarModule(ReactApplicationContext context) {
        super(context);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public void createCalendarEvent(String name, String location) {
        Log.d("CalendarModule", "Create event called with name: " + name
                + " and location: " + location);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public void sinaEvent(String msg) {

        MyService.isPlaying = true;
//        startService(new Intent(MainActivity.this, MyService.class));
        getCurrentActivity().startService(new Intent(getCurrentActivity(), MyService.class));

        Toast.makeText(getCurrentActivity(), msg, Toast.LENGTH_SHORT).show();
    }

}