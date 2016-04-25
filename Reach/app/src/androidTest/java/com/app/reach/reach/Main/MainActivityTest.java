package com.app.reach.reach.Main;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import com.app.reach.model.AunthenticatedUser;
import com.app.reach.reach.Login.SuccessfulLoginEvent;
import com.app.reach.reach.R;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by tenzin on 10/3/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
//
//    @Test
//    public void helloWorldTest() {
//        onView(withId(R.id.loggedIn))
//                .check(matches(withText("Youhave Logged in Successfully")));
//
//    }
 /*   @Test
    public void helloWorldButtonTest(){

        onView(withId(R.id.button))
                .perform(click())
                .check(matches(isEnabled()));

    }*/

    @Test
    public void validate_signInButtonVisibile() {
        AunthenticatedUser user = new AunthenticatedUser();
        user = null;
        SuccessfulLoginEvent event;
        event = new SuccessfulLoginEvent(user);

     /*   if (event == null) {
            onView(withId(R.id.goToLogin)).check(matches((isDisplayed())));
        }*/
    }

    @Test
    public void validate_menuIsInflated() {
        DrawerLayout drawer;
        onView(withId(R.id.main_drawer_layout)).perform(click());
        onView(withId(R.id.main_drawer_layout)).check(matches(isDisplayed()));
    }

    private String getString(int resId) {
        return getInstrumentation().getTargetContext().getString(resId);
    }

    @Test
    public void validate_navigationDrawer() {
        onView(withId(R.id.main_drawer_layout)).perform(actionOpenDrawer());
        onView(withId(R.id.main_drawer_layout)).perform(actionCloseDrawer());
    /*    onView(withContentDescription(getString(R.string.navigation_drawer_close))).perform(click());
*/
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
    }





}

  /*  @Test
    public void validate_onCategorySelect() {
        onView(withContentDescription(getString(R.string.navigation_drawer_open)))
                .perform(click());
        onView(Matchers.allOf(ViewMatchers.withId(R.id.nav_companies), hasSibling(ViewMatchers.withText("Companies")))).perform(click());
*/

      /*  if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/






