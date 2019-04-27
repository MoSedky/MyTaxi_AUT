package com.mytaxi.android_demo.activities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class OpenDriverProfile extends ObjectRepo {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class,true,true);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    LaunchAppTest launchAppTest=new LaunchAppTest();
    LoginUITest loginUITest=new LoginUITest();
    LoginFieldsTest loginFieldsTest=new LoginFieldsTest();
    SearchDriverTest searchDriverTest=new SearchDriverTest();
    GetCredentials getCredentials=new GetCredentials();

    @Test
    public void openDriverProfile() throws Exception {
        //launchAppTest.a_shouldDisplayPermissionRequestDialogAtStartup();
        loginUITest.loginUITest();
        String[] upToDateCred=getCredentials.ReadCredentials();
        loginFieldsTest.loginFieldsTest(upToDateCred[0],upToDateCred[1]);
        searchDriverTest.searchDriver();
    }
}
