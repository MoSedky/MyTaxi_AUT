package com.mytaxi.android_demo.activities;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@LargeTest
@RunWith(AndroidJUnit4.class)
public class LaunchAppTest {
    UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    UiObject allowButton = device.findObject(new UiSelector().text("ALLOW"));

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Before
    public void isPermissionDisplayed(){
        org.junit.Assume.assumeTrue(allowButton.exists());

    }

    @Test
    public void a_shouldDisplayPermissionRequestDialogAtStartup() throws Exception{

        assertViewWithTextIsVisible(device, "ALLOW");
        assertViewWithTextIsVisible(device, "DENY");
        denyCurrentPermission(device);
    }

    public void assertViewWithTextIsVisible(UiDevice device, String text) {

        allowButton = device.findObject(new UiSelector().text(text));
        if (!allowButton.exists()) {
            throw new AssertionError("View with text <" + text + "> not found!");
        }
    }

    public void denyCurrentPermission(UiDevice device) throws UiObjectNotFoundException {
        UiObject denyButton = device.findObject(new UiSelector().text("DENY"));
        denyButton.click();

    }
}
