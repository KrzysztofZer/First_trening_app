package com.example.kzerman.nauka;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.content.ContentValues.TAG;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by k.zerman on 29-Jan-18.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class Testowanie_Menu {
    @Rule
    public IntentsTestRule<Menu> intentsTestRule =
            new IntentsTestRule<>(Menu.class);


    @Test
    public void pogoda() throws InterruptedException {
        onView(withId(R.id.button2)).perform(click());
        String sprawdz = onView(withId(R.id.Liczba)).toString();

            Thread.sleep(1500);

        if (czy_numer(sprawdz))
           System.err.print("liczba");
        else
            Log.d(TAG, "pogoda: nie liczba");
    }

static boolean czy_numer (String a){
        if (android.text.TextUtils.isDigitsOnly(a))
        return true;
        else
            return false;
}


}
