package com.example.calculator.Controller;

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

import com.example.calculator.Model.ConverterModel;
import com.example.calculator.R;


public class MainConverterActivity extends AppCompatActivity {

    private static TextView converted_amount;
    /**
     * Views of the Converter
     */
    public Context context = this;
    private Spinner fromSpinner, toSpinner;
    private EditText editText;
    private String currencyFrom, currencyTo, amount;

    /**
     * Set the converted result to TextView after the AsyncTask ends
     *
     * @param result result of AsyncTask
     */
    public static void checkResponse(Double result) {
        converted_amount.setText(String.valueOf(result));
    }

    /**
     * Initialize all the view of the converter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_convertor);

        //Initialize the spinners list
        initializeSpinners();

        editText = findViewById(R.id.amountText);
        converted_amount = findViewById(R.id.convertedAmountView);
        final Button convertButton = findViewById(R.id.btnConvert);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currencyFrom = fromSpinner.getSelectedItem().toString();
                currencyTo = toSpinner.getSelectedItem().toString();
                amount = editText.getText().toString();
                ProgressDialog dialog = new ProgressDialog(context);
                ConverterModel converterModel = new ConverterModel(dialog);
                converterModel.execute(currencyFrom, currencyTo, amount);
            }
        });
    }


    /**
     * Initialize all the items of the list for the spinners view
     */
    private void initializeSpinners() {
        fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        // Create an ArrayAdapter
        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        fromSpinner.setAdapter(fromAdapter);

        toSpinner = (Spinner) findViewById(R.id.toSpinner);
        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toAdapter);

    }

    /**
     * Create the Hamburger icon at the ActionBar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        return true;
    }

    /**
     * Start a new Activity from the option that the user has selected.
     * Destroy the old activity so it can not be accessed.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemCalculator:
                Intent calculatorIntent = new Intent(this, MainCalculatorActivity.class);
                startActivity(calculatorIntent);
                finish();
                return true;
            case R.id.menuItemConverter:
                Intent converterIntent = new Intent(this, MainConverterActivity.class);
                startActivity(converterIntent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}