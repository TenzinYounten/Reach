package com.app.reach.reach.Login;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.app.reach.reach.R;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by tenzin on 10/3/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest extends TestCase {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    @Test
    public void userNameEditTextHintTest() {
        onView(withId(R.id.username)).check(matches(withHint("Enter username")));
    }

    @Test
    public void passwordEditTextHintTest() {
        onView(withId(R.id.password)).check(matches(withHint("Enter password")));
    }

    @Test
    public void buttonText() {
        onView(withId(R.id.loginButton)).check(matches(withText("login")));
    }

    @Test
    public void loginButtonEnabledTest() {

        onView(withId(R.id.loginButton))
                .perform(click())
                .check(matches(isEnabled()));
    }

    @Test
    public void validateIntentSenttoActivity(){
        onView(withId(R.id.loginButton)).perform(click());




    }

}