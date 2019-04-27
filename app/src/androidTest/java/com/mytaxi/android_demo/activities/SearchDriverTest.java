package com.mytaxi.android_demo.activities;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.RootMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SearchDriverTest extends ObjectRepo{
    private ViewInteraction searchDriver;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class,true,true);

    @Test
    public void searchDriver() throws InterruptedException {

        searchDriver =identifybyId(R.id.textSearch);

        searchDriver.perform(typeText("s"));
        Thread.sleep(2000);
        searchDriver.perform(typeText("a"));
        Thread.sleep(3000);

        onView(withText("Sarah Scott"))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());

    }

}
