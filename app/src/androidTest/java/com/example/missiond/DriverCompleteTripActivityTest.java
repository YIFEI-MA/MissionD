package com.example.missiond;

import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertNotNull;

public class DriverCompleteTripActivityTest {

    @Rule
    public ActivityTestRule<DriverCompleteTripActivity> mActivityTestRule = new ActivityTestRule<DriverCompleteTripActivity>(DriverCompleteTripActivity.class);

    private DriverCompleteTripActivity mActivity=null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ScanQRcode.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }


    /*
This tests whether the ScanQRcodetActivity is launched when the button is clicked.
 */
    @Test
    public void testLaunchOfScanQRcodetActivityOnButtonClick(){
        assertNotNull(mActivity.findViewById(R.id.DriverBack));

        onView(withId(R.id.DriverBack)).perform(click());

        Activity scanActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);

        assertNotNull(scanActivity);

        scanActivity.finish();

    }

    @After
    public void tearDown() throws Exception {
    }
}