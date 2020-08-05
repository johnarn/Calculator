package com.example.calculator.Model;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

public class ConverterModel extends AsyncTask<String, Void, Double> {


    public Double convert(String string[]) {

        String currencyFrom = string[0];
        String currencyTo = string[1];
        String amount = string[2];

        double conversion = 0;
        try {
            URL url = new URL("http://data.fixer.io/api/convert?access_key=5d923444a85ce316c79767cfbd962799&from=" + currencyFrom + "&to=" + currencyTo + "&amount=" + amount);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            Scanner scanner = null;
            scanner = new Scanner(new BufferedInputStream(connection.getInputStream()));


            String rslt = "";
            while (scanner.hasNext()) rslt += scanner.nextLine();
            Log.i(TAG, rslt);

            conversion = new JSONObject(rslt).getJSONObject("conversion").getDouble(String.valueOf(amount));
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
    protected Double doInBackground(String... strings) {
        return convert(strings);
    }
}
