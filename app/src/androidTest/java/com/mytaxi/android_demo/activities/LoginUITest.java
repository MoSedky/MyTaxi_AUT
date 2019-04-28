package com.mytaxi.android_demo.activities;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginUITest extends ObjectRepo{
    GetCredentials GC=new GetCredentials();
    protected ViewInteraction title;
    protected ViewInteraction titleText;
    protected ViewInteraction username;
    protected ViewInteraction password;
    protected ViewInteraction login_btn;


    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class,true,false);

//    @Rule
//    public GrantPermissionRule mGrantPermissionRule =
//            GrantPermissionRule.grant(
//                    "android.permission.ACCESS_FINE_LOCATION");

    @Test
    public void loginUITest() {

        title=identifybyId(R.id.action_bar);
        title.check(matches(isDisplayed()));

        titleText = onView(allOf(withText(R.string.title_activity_authentication),
                    withClassName(endsWith("TextView"))));
        titleText.check(matches(isDisplayed()));

        username=identifybyId(R.id.edt_username);
        username.check(matches(isDisplayed()));

        password=identifybyId(R.id.edt_password);
        password.check(matches(isDisplayed()));

        login_btn=identifybyId(R.id.btn_login);
        login_btn.check(matches(isDisplayed()));

        try {
            GC.ReadCredentials();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
