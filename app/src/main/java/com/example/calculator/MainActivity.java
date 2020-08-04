package com.example.calculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.Model.CalculatorModel;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalculatorModel model = new CalculatorModel();
    }

}