package com.example.calculator;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainConverterActivity extends AppCompatActivity {

    public Context context = this;
    private Spinner fromSpinner, toSpinner;
    private EditText editText;
    private TextView converted_amount;
    private String currencyFrom, currencyTo, amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_convertor);

        initializeSpinners();

        editText = findViewById(R.id.amountText);
        converted_amount = findViewById(R.id.convertedAmountView);


        System.out.println(currencyFrom + currencyTo + amount);

        final Button convertButton = findViewById(R.id.btnConvert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyFrom = fromSpinner.getSelectedItem().toString();
                currencyTo = toSpinner.getSelectedItem().toString();
                amount = editText.getText().toString();
                ProgressDialog dialog = new ProgressDialog(context);
                FixerReceiver fixerReceiver = new FixerReceiver(dialog, converted_amount);
                fixerReceiver.execute(currencyFrom, currencyTo, amount);
            }
        });


    }

    private void initializeSpinners() {
        fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        fromSpinner.setAdapter(fromAdapter);

        toSpinner = (Spinner) findViewById(R.id.toSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        toSpinner.setAdapter(toAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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