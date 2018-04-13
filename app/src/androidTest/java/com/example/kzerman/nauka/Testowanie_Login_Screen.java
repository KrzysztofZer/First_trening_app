package com.example.kzerman.nauka;

import android.content.ComponentName;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.matchers.JUnitMatchers.containsString;
import android.support.test.espresso.intent.Intents;
/**
 * Created by k.zerman on 29-Jan-18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Testowanie_Login_Screen {
  /*  @Rule
    public ActivityTestRule<MainScreen> mActivityRule =
            new ActivityTestRule(MainScreen.class);
*/
  @Rule
  public IntentsTestRule<MainScreen> intentsTestRule =
          new IntentsTestRule<>(MainScreen.class);


    @Test
    public void logowanie_puste_pole () throws InterruptedException {

        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.IncorrectPass)).check(matches(withText(containsString("Wrong password"))));
        onView(withId(R.id.Pass)).perform(typeText("xD"));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        intended(hasComponent(Menu.class.getName()));

    }

}
