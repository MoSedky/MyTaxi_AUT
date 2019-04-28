package com.mytaxi.android_demo.activities;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginFieldsTest extends LoginUITest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class,true,true);

    @Test
    public void loginFieldsTest(String usernameTxt, String passwordTxt) throws InterruptedException {
        //Intents.init();
//        mActivityTestRule.launchActivity(new Intent());
//        intended(hasComponent(MainActivity.class.getName()));
        username=identifybyId(R.id.edt_username);
        username.perform(typeText(usernameTxt));
        password=identifybyId(R.id.edt_password);
        password.perform(typeText(passwordTxt));
        login_btn=identifybyId(R.id.btn_login);
        login_btn.perform(click());

        Thread.sleep(5000);
        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));

    }

}
