package com.example.calculator;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

class FixerReceiver extends AsyncTask<String, Void, Double> {

    public Double conversion = 0.0;
    private ProgressDialog dialog;
    private TextView converted_amount;

    public FixerReceiver(ProgressDialog dialog, TextView converted_amount) {
        this.dialog = dialog;
        this.converted_amount = converted_amount;
    }


    @Override
    protected void onPreExecute() {
        dialog.setMessage("Waiting..");
        dialog.show();
        super.onPreExecute();
    }

    @Override
    protected Double doInBackground(String... string) {
        String currencyFrom = string[0];
        String currencyTo = string[1];
        String amount = string[2];

        double rateTo = 0, rateFrom;
        try {
            URL url = new URL("http://data.fixer.io/api/latest?access_key=5d923444a85ce316c79767cfbd962799");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Scanner scanner = null;
            scanner = new Scanner(new BufferedInputStream(connection.getInputStream()));


            String rslt = "";
            while (scanner.hasNext()) rslt += scanner.nextLine();
            Log.i(TAG, rslt);
            rateFrom = new JSONObject(rslt).getJSONObject("rates").getDouble(currencyFrom);
            rateTo = new JSONObject(rslt).getJSONObject("rates").getDouble(currencyTo);

            System.out.println("RATEFROM: " + rateFrom + " RATETO: " + rateTo + " AMOUNT: " + amount);


            conversion = (Double.parseDouble(amount) / rateFrom) * rateTo;
            System.out.println("CONV: " + conversion);
            scanner.close();
            return conversion;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return conversion;
    }

    @Override
    protected void onPostExecute(Double aDouble) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }

        converted_amount.setText(conversion.toString());
        super.onPostExecute(aDouble);
    }
}
