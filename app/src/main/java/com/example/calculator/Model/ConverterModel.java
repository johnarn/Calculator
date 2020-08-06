package com.example.calculator.Model;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.example.calculator.MainConverterActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

/**
 * ConverterModel contains all the business logic of the converter app
 * Connects to fixer.io and receives the rates of the currencies
 */
public class ConverterModel extends AsyncTask<String, Void, Double> {

    public Double conversion = 0.0;
    private ProgressDialog dialog;

    /**
     * Constructor for the progress dialog
     *
     * @param dialog progressDialog
     */
    public ConverterModel(ProgressDialog dialog) {
        this.dialog = dialog;
    }


    /**
     * Show the progress dialog
     */
    @Override
    protected void onPreExecute() {
        dialog.setMessage("Waiting..");
        dialog.show();
        super.onPreExecute();
    }

    /**
     * Connect to fixer.io and receives the rates of the currencies
     * After that calculate the result of the new currency and return it
     *
     * @param string ArrayList of String that contains with order:
     *               -From currency
     *               -To currency
     *               -Amount that the user wants to convert
     * @return the converted amount
     */
    @Override
    protected Double doInBackground(String... string) {
        String currencyFrom = string[0];
        String currencyTo = string[1];
        String amount = string[2];

        double rateTo = 0, rateFrom = 0;
        try {

            //Connect to fixer.io
            URL url = new URL("http://data.fixer.io/api/latest?access_key=5d923444a85ce316c79767cfbd962799");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Read from the response of fixer.io the rates of the two currencies
            Scanner scanner = null;
            scanner = new Scanner(new BufferedInputStream(connection.getInputStream()));
            StringBuilder rslt = new StringBuilder();
            while (scanner.hasNext()) rslt.append(scanner.nextLine());
            Log.i(TAG, rslt.toString());
            rateFrom = new JSONObject(rslt.toString()).getJSONObject("rates").getDouble(currencyFrom);
            rateTo = new JSONObject(rslt.toString()).getJSONObject("rates").getDouble(currencyTo);

            //Calculate the new amount
            conversion = (Double.parseDouble(amount) / rateFrom) * rateTo;
            scanner.close();
            return conversion;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return conversion;
    }

    /**
     * When all have ended dismiss the progress dialog and update the TextView
     *
     * @param aDouble converted amount to new currency
     */
    @Override
    protected void onPostExecute(Double aDouble) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        super.onPostExecute(aDouble);
        MainConverterActivity.checkResponse(aDouble);
    }
}
