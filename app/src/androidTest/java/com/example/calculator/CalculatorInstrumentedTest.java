package com.example.calculator;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.calculator.Controller.MainCalculatorActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CalculatorInstrumentedTest {

    @Rule
    public ActivityTestRule<MainCalculatorActivity> mainCalculatorActivityTestRule = new ActivityTestRule<MainCalculatorActivity>(MainCalculatorActivity.class);
    private MainCalculatorActivity mainCalculatorActivity;

    @Before
    public void setUp() {
        mainCalculatorActivity = mainCalculatorActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mainCalculatorActivity.findViewById(R.id.btnEqual);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mainCalculatorActivity = null;
    }


}
