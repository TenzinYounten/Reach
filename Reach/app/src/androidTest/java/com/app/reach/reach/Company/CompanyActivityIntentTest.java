package com.app.reach.reach.Company;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by tenzin on 30/3/16.
 */
@RunWith(JUnit4.class)
public class CompanyActivityIntentTest extends TestCase {

    @Rule
    public IntentsTestRule<CompanyActivity> mActivityRule = new IntentsTestRule<>(CompanyActivity.class);

/*    @Test
    public void validate_NavigationDrawerListView(){
        onView(withId(R.id.main_drawer_layout)).perform(click());

        // When I click on the an item in the ListView
        onData(allOf(is(
                instanceOf(String.class)), is("Companies")))
                .perform(click());

        // Then the TextView shows the correct text
        intended(hasComponent(ProductsActivity.class.getName()));
    }*/
    //Given the ListView is populated

}