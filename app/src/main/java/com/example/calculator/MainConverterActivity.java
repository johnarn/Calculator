package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculator.Model.CalculatorModel;
import com.example.calculator.Model.ConverterModel;

public class MainConverterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_convertor);

        ConverterModel converterModel = new ConverterModel();

        System.out.println(converterModel.execute("USD", "EUR", "25"));




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menuItemCalculator:
                Intent calculatorIntent = new Intent(this, MainCalculatorActivity.class);
                startActivity(calculatorIntent);
                return true;
            case R.id.menuItemConverter:
                Intent converterIntent = new Intent(this, MainConverterActivity.class);
                startActivity(converterIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}