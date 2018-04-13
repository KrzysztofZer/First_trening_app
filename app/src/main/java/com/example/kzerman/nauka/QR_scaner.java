package com.example.kzerman.nauka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.kzerman.nauka.R.id.ScanButton;
import static com.example.kzerman.nauka.R.id.ZeskanowanyTekst;


public class QR_scaner extends AppCompatActivity implements View.OnClickListener {

Button scanBut;
TextView wyswietlanyTekst;
    IntentIntegrator qrscan; //scaner QR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scaner);
        initiation ();
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data


                    wyswietlanyTekst.setText(result.getContents().toString());

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    void initiation (){
        scanBut = (Button) findViewById(ScanButton);
        wyswietlanyTekst = (TextView) findViewById(ZeskanowanyTekst);
        qrscan =  new IntentIntegrator(this);
        scanBut.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        qrscan.initiateScan();
    }
}
