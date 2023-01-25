package com.native_module_example1;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;

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

        Toast.makeText(getCurrentActivity(),"Hello, I'm Sina Kordestani",Toast.LENGTH_SHORT).show();

    }

}