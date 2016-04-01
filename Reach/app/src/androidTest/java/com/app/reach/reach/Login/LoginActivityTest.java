package com.app.reach.reach.Login;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.app.reach.model.AunthenticatedUser;
import com.app.reach.reach.Main.MainActivity;
import com.app.reach.reach.R;

import junit.framework.TestCase;

import org.greenrobot.eventbus.EventBus;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;


/**
 * Created by tenzin on 10/3/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest extends TestCase {

    public static final String MY_CUSTOM_TEXT = "Youhave Logged in Successfully";
    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity loginActivity;

    @Before
    public void setUp() {
        loginActivity = activityTestRule.getActivity();
    }
   /* @Test
    public void textViewIsDisplayed() {
        onView(allOf(instanceOf(EditText.class), withHint("heya")))
                .check(matches(isDisplayed()));
    }*/

    @Test
    public void validate_UsernameIsEmpty() {
        onView(withId(R.id.username)).perform(typeText(""));
        onView(withId(R.id.password)).perform(typeText(""));

        onView(withId(R.id.loginButton)).perform(click());

        onView(withId(R.id.username)).check(matches(hasErrorText(loginActivity.getString(R.string.invalid_username))));
    }

    @Test
    public void validate_PasswordIsEmpty() {

        onView(withId(R.id.username)).perform(typeText("Username"));
        onView(withId(R.id.password)).perform(typeText(""));

        onView(withId(R.id.loginButton)).perform(click());

        onView(withId(R.id.password)).check(matches(hasErrorText(loginActivity.getString(R.string.invalid_password))));
    }

    @Test
    public void validate_LoginIsSuccessful() {

        SuccessfulLoginEvent event = null;
        onView(withId(R.id.username)).perform(typeText("Username"));
        onView(withId(R.id.password)).perform(typeText("Password"));

        onView(withId(R.id.loginButton)).perform(click());
        AunthenticatedUser user = new AunthenticatedUser();
        user.setUsername("tenzin");
        user.setAccessToken("access token");
        user.setExpiresIn(3600);
        user.setRefreshToken("refresh token");
        user.setRoles("Roles");
        user.setTokenType("Token type");

        event = new SuccessfulLoginEvent(user);
        EventBus bus = EventBus.getDefault();
        bus.postSticky(event);

        intended(hasComponent(MainActivity.class.getName()));

     /*   onView(withId(R.id.main_drawer_layout)).check(matches(isDisplayed()));*/
//        onView(withId(R.id.login_content)).check(matches(not((loginActivity.getString(R.string.invalid_login)))));
     /*   onView(withId(R.id.main_drawer_layout)).check(matches(isDisplayed()));
        onView(withText(R.string.invalid_login))
                .inRoot(withDecorView(not(is(loginActivity.getWindow().getDecorView()))))
                .check(doesNotExist());*/
    }

    @Test
    public void validate_LoginIsUnSuccessful() {

        SuccessfulLoginEvent event = null;

        onView(withId(R.id.username)).perform(typeText("Username"));
        onView(withId(R.id.password)).perform(typeText("Paswword"));

        onView(withId(R.id.loginButton)).perform(click());
        AunthenticatedUser user = null;

        event = new SuccessfulLoginEvent(user);
        EventBus.getDefault().postSticky(event);

        onView(withText(R.string.invalid_login))
                .inRoot(withDecorView(not(is(loginActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }
}