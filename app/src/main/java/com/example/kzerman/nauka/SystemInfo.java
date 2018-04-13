package com.example.kzerman.nauka;

import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class SystemInfo extends AppCompatActivity {

    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;
    TextView tx5;
    TextView tx6;
    TextView tx7;

    DisplayMetrics matr;
    int matrWidth =0, matrHeight=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_info);
        initialization();
        downloadInfo();
    }
    void initialization (){
        tx1 = (TextView) findViewById(R.id.info1);
        tx2 = (TextView) findViewById(R.id.info2);
        tx3 = (TextView) findViewById(R.id.info3);
        tx4 = (TextView) findViewById(R.id.info4);
        tx5 = (TextView) findViewById(R.id.info5);
        tx6 = (TextView) findViewById(R.id.info6);
        tx7 = (TextView) findViewById(R.id.info7);
        matr = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(matr);
        matrHeight = matr.heightPixels;
        matrWidth = matr.widthPixels;
        

    }

void downloadInfo(){
    tx1.setText("Model: "+ Build.MODEL+" Firma: "+Build.MANUFACTURER);
    tx2.setText("Android: "+Build.VERSION.BASE_OS+" ("+Build.VERSION.CODENAME+")");
    tx3.setText("Rozdzielczosc: "+matrWidth+"x"+matrHeight);
    tx4.setText("PhoneID: "+Build.ID);
    tx5.setText("Time: "+Build.TIME);
    tx6.setText("Ostatnia wiadomosc: "+getLastMSG());



}
String getLastMSG (){

    Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
    String msgData = "";
    if (cursor.moveToFirst()) { // must check the result to prevent exception
        do {

            for(int idx=0;idx<cursor.getColumnCount();idx++)
            {
                msgData += " " + cursor.getColumnName(idx) + ":" + cursor.getString(idx);
            }
            // use msgData
        } while (cursor.moveToNext());
    } else {
        // empty box, no SMS
        msgData = "Brak wiadomosci";
    }
    return msgData;
}


}
