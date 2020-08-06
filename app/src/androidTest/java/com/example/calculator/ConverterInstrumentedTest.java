package com.example.calculator;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.calculator.Controller.MainConverterActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ConverterInstrumentedTest {

    @Rule
    public ActivityTestRule<MainConverterActivity> mainConverterActivityTestRule = new ActivityTestRule<MainConverterActivity>(MainConverterActivity.class);
    private MainConverterActivity mainConverterActivity;

    @Before
    public void setUp() {
        mainConverterActivity = mainConverterActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mainConverterActivity.findViewById(R.id.btnConvert);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mainConverterActivity = null;
    }


}
