package com.mytaxi.android_demo.activities;
import android.support.test.espresso.ViewInteraction;

import com.github.mjeanroy.junit4.runif.RunIf;
import com.github.mjeanroy.junit4.runif.RunIfCondition;

import java.lang.annotation.Annotation;

public class LocationPermissionDisplayed implements RunIf{

    public boolean triggered(ViewInteraction permissionDialog) {
        return permissionDialog != null;
    }

    @Override
    public Class<? extends RunIfCondition> value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
