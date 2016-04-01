package com.app.reach.reach.Main;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.app.reach.reach.Login.LoginActivity;
import com.app.reach.reach.R;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by tenzin on 30/3/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityIntentTest extends TestCase {

    @Rule
    public IntentsTestRule<MainActivity> mActivityRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void validate_onLoginClickedStartLoginActivity() {
        onView(withId(R.id.goToLogin)).perform(click());
        intended(hasComponent(LoginActivity.class.getName()));
    }

   /* @Test
    public void validate_onNavigationBarItemClicked() {
        onData(allOf(is(instanceOf(String.class)), is("Companies"))).perform(click());

        // clicking the item should close the drawer.
        onView(withId(R.id.main_drawer_layout)).perform((actionCloseDrawer()));

        // The text view will now display "You picked: Pickle"
        intended(hasComponent(CompanyActivity.class.getName()));
    *//*    onView(withContentDescription(getString(R.string.navigation_drawer_close))).perform(click());
*//*
    }
    private static ViewAction actionOpenDrawer() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(DrawerLayout.class);
            }

            @Override
            public String getDescription() {
                return "open drawer";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((DrawerLayout) view).openDrawer(GravityCompat.START);
            }
        };
    }

    private static ViewAction actionCloseDrawer() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(DrawerLayout.class);
            }

            @Override
            public String getDescription() {
                return "close drawer";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((DrawerLayout) view).closeDrawer(GravityCompat.START);
            }
        };
    }*/
}
