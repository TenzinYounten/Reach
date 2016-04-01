package com.app.reach.reach.Login;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.app.reach.model.AunthenticatedUser;
import com.app.reach.reach.Main.MainActivity;
import com.app.reach.reach.R;

import junit.framework.TestCase;

import org.greenrobot.eventbus.EventBus;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by tenzin on 29/3/16.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityIntentTest extends TestCase {

    @Rule
    public IntentsTestRule<LoginActivity> mActivityRule = new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void validate_IntentChangeonLogin() {
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

    }
}
