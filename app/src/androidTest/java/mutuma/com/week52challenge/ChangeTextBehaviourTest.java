package mutuma.com.week52challenge;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class ChangeTextBehaviourTest {
    private String stringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        stringToBetyped = "1234";
    }

    @Test
    public void changeText_sameActivity() {
        // Type text
        onView(withId(R.id.amount_to_save))
                .perform(typeText(stringToBetyped), closeSoftKeyboard());


        // Check that the text was changed.
        onView(withId(R.id.amount_to_save))
                .check(matches(withText(stringToBetyped)));
    }
}
