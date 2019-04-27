package com.mytaxi.android_demo.activities;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ObjectRepo {
    protected UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    protected UiObject allowButton = device.findObject(new UiSelector().text("ALLOW"));
    protected ViewInteraction viewInteraction;

    public ViewInteraction identifybyId(int locator)
    {
        viewInteraction=onView(withId(locator));
        return viewInteraction;
    }



}
