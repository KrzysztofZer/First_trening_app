package com.example.kzerman.nauka;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.JsonReader;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.kzerman.nauka.R.id.City;
import static com.example.kzerman.nauka.R.id.FinalTekst;

public class Weather extends AppCompatActivity {
    TextView FinalT;
    EditText Miasto;
    HttpURLConnection connection;
    BufferedReader reader;
    URL url;
    double temperatura;
    StringBuffer buffer;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    initialization();
    }

    //Initializacja
 public void initialization (){
     FinalT = (TextView) findViewById(FinalTekst);
     FinalT.setMovementMethod(new ScrollingMovementMethod());
     Miasto = (EditText) findViewById(City);


 }

 //baza miast
 public String MiatoDoAPI (){
String latitude;

     if (Miasto.getText().toString().equalsIgnoreCase("warszawa")||Miasto.getText().toString().equalsIgnoreCase("warsaw"))
         latitude = "52.2297,21.0122";
     else if (Miasto.getText().toString().equalsIgnoreCase("krakow")||Miasto.getText().toString().equalsIgnoreCase("kraków"))
         latitude = "50.0647,19.9450";
     else if (Miasto.getText().toString().equalsIgnoreCase("lodz")||Miasto.getText().toString().equalsIgnoreCase("lódź"))
         latitude = "51.7592,19.4560";
     else if (Miasto.getText().toString().equalsIgnoreCase("gdansk")||Miasto.getText().toString().equalsIgnoreCase("gdansk"))
         latitude = "54.3520,18.6466";
     else
         latitude = "brak";
     return latitude;
 }

 // Konwerter na celcjusza
 public double doCelcjusza (double temp){
        temp = (temp-32)/1.8;
        temp *= 100;
        temp = Math.round(temp);
        temp/= 100;
        return temp;
    }

 //formatowanie pola miasta
    public void miastopoformacie () {
        Miasto.setText(Miasto.getText().toString().replaceAll(" ",""));

    }

    //Przycisk Potwierdz
    public void PotwierdzBut (View v){
            miastopoformacie();
        if (Miasto.getText().toString() == "Miasto")
        FinalT.setText("Wpierw wpisz miasto");
        else{
            String latitude = MiatoDoAPI();
            if (latitude == "brak")
                FinalT.setText("Brak takiego miasta w bazie danych");
            else{



                    new JASONTask().execute("https://api.darksky.net/forecast/c19496ba82c7c36994843f3345fb48a0/"+latitude);



            }
        }
    }

    //Wywolywanie i obsluga JSON
    public class JASONTask extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Weather.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }
        @Override
        protected String doInBackground(String... urls) {
            try {
               URL url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStream stream = null;
            try {
                stream = connection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            reader = new BufferedReader(new InputStreamReader(stream));
            buffer = new StringBuffer();
            String line = "";
            try {
                while ((line = reader.readLine()) != null){
                    buffer.append(line);

                }
              return buffer.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }




            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            JSONObject obiekt = null;
            try {
                obiekt = new JSONObject(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            FinalT.setText("Po stworzeniu obiektu");


            if (obiekt.has("currently")) {
                JSONObject current = null;
                try {
                    current = obiekt.getJSONObject("currently");
                    if (current.has("temperature")){
                        temperatura = current.getDouble("temperature");

                    }
                    else
                        FinalT.setText("Brak temperature");

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                FinalT.setText("Po zebraniu temperatury");

                FinalT.setText("Temperatura w " + Miasto.getText().toString() + " wynosi " + temperatura + " stopni Fahrenheita (" + doCelcjusza(temperatura)+" stopni Celcjusza)");

            }

            else
            FinalT.setText("brak currently");


            if (connection != null){
                connection.disconnect();
            }
            if (reader != null) try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pDialog.dismiss();
        }
    }



}


