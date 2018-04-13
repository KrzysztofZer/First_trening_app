package com.example.kzerman.nauka;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


import static com.example.kzerman.nauka.R.id.Tnapisane;
import static com.example.kzerman.nauka.R.id.Twczytane;
import static com.example.kzerman.nauka.R.id.Wczytaj;
import static com.example.kzerman.nauka.R.id.zapis;

public class Textt extends AppCompatActivity {
    String tekst;
    String filename;
    EditText pisanie;
    TextView wczytywanie;
    TextView testowyT;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textt);
     initalize();

    }
public void initalize (){
    filename = "PrzechowywanyTekst.txt";
     pisanie = (EditText) findViewById(Tnapisane);
     wczytywanie = (TextView) findViewById(Twczytane);
    path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/testy/";

}



    public void wczytBut (View v){
        String line;
        try {
            FileInputStream fileInputStream = new FileInputStream(path + filename);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            while((line = bufferReader.readLine())!=null){
                stringBuilder.append(line+System.getProperty("line.seperator"));

            }
            fileInputStream.close();
            line = stringBuilder.toString();
            tekst = line;
            wczytywanie.setText(tekst);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void UsunBut (View v){
        File filee = new File (path + filename);
        filee.delete();





    }



    public void zaspsBut (View v) {

new File (path).mkdir();
        File filee = new File(path + filename);
        if (!filee.exists()){
            try {
               // filee.mkdirs();
                filee.createNewFile();
                FileOutputStream fileOutouStreame = new FileOutputStream(filee,true);
                fileOutouStreame.write(pisanie.getText().toString().getBytes());
            }

            catch (IOException e) {
                e.printStackTrace();

            }
        }
      else {
            try {
            FileOutputStream    fileOutouStreame = new FileOutputStream(filee,true);
                fileOutouStreame.write(pisanie.getText().toString().getBytes());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }


    }

