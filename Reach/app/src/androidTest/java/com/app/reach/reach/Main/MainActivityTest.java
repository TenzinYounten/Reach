package com.app.reach.reach.Main;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.app.reach.reach.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by tenzin on 10/3/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void helloWorldTest() {
        onView(withId(R.id.loggedIn))
                .check(matches(withText("Youhave Logged in Successfully")));

    }
 /*   @Test
    public void helloWorldButtonTest(){

        onView(withId(R.id.button))
                .perform(click())
                .check(matches(isEnabled()));

    }*/

}