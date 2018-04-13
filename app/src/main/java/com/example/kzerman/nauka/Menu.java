package com.example.kzerman.nauka;

import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.noob.noobcameraflash.managers.NoobCameraManager;

import java.security.Policy;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.kzerman.nauka.R.id.Liczba;
import static com.example.kzerman.nauka.R.id.Pesel;
import static com.example.kzerman.nauka.R.id.spinner;
import static com.example.kzerman.nauka.R.id.testBut;
import static com.example.kzerman.nauka.R.id.tlo;

public class Menu extends AppCompatActivity {
    Spinner Spin;
    Button testButt;
    android.hardware.Camera cam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initalize ();
        Spinuj();

    }
// initalizing
   public void  initalize (){
       Spin = (Spinner) findViewById(spinner);
       testButt = (Button) findViewById(testBut);



   }


//Buttony
    public void KliknijRandom (View v){
        TextView liczba = (TextView) findViewById(Liczba);
       int randomNum = ThreadLocalRandom.current().nextInt(1,1000000+1);
liczba.setVisibility(View.VISIBLE);
        liczba.setText(""+randomNum);

    }



    public void KliknijPesel (View v){
        TextView pesel = (TextView) findViewById(Pesel);
        pesel.setText(GeneratedPesel());

    }



    public void KliknijKolor (View v){
losujKol();
    }


    public  void DefaultColor (View v){
        ConstraintLayout r1 = (ConstraintLayout) findViewById(tlo);
        r1.setBackgroundColor(Color.WHITE);
    }

    public void GoGallery (View v){

        Intent gallery =  new Intent(this, Gallery.class);
        startActivity(gallery);
    }

    public void GoClock (View c){
        Intent clock = new Intent(this, Clock.class);
        startActivity(clock);
    }

    public void GoMaps (View v){
        Intent Maps = new Intent(this, Maps.class);
        startActivity(Maps);
    }

    public  void GoWykop (View v){
        Intent wykop = new Intent(this, Wykop.class);
        startActivity(wykop);

    }

    public void GoAD (View v){
        Intent rekl = new Intent(this, GoogleAd.class);
        startActivity(rekl);

    }

    public void GoText (View v){
        Intent text = new Intent(this, Textt.class);
        startActivity(text);
    }

    public void GoFloat (View v){
        Intent floating = new Intent(this, FloatingButton.class);
        startActivity(floating);
    }

    public  void TestBut (View v){
      testButt.setText(Spin.getSelectedItem().toString());

    }

    public void GoScaner (View v){
Intent scaner =  new Intent(this, QR_scaner.class);
        startActivity(scaner);
    }
boolean test = false;
    public void Flashlight (View v){
    CamON();
    }

public void WeatherButton (View v){
Intent weather = new Intent(this, Weather.class);
    startActivity(weather);

}

public void goBubble (View v){
    Intent bubble = new Intent(this,BubbleScrean.class);
    startActivity(bubble);
}

public void GoSystemInfo (View v){

    Intent system = new Intent(this,SystemInfo.class);
    startActivity(system);
}

public void testData (View v){
    Intent data = new Intent(this,DataTo.class);
    startActivity(data);
}

    //Funkcje

 public void CamON (){
     cam = android.hardware.Camera.open();
     android.hardware.Camera.Parameters params = cam.getParameters();
     params.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_ON);
     cam.setParameters(params);
     cam.startPreview();
     cam.autoFocus(new android.hardware.Camera.AutoFocusCallback() {
         public void onAutoFocus(boolean success, android.hardware.Camera camera) {
         }
     });
 }


    public void CamOFF (){
        cam.stopPreview();
        cam.release();
    }

    public void Spinuj (){
        String [] SpinTab;
        SpinTab = new String[]{"opcja 1", "opcja 2", "opcja 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, SpinTab);
        Spin.setAdapter(adapter);




    }

    public void losujKol(){
        ConstraintLayout r1 = (ConstraintLayout) findViewById(tlo);
        int randomCol = ThreadLocalRandom.current().nextInt(0,9+1);
        switch (randomCol){
            case 0:  r1.setBackgroundColor(Color.RED);
                break;
            case 1: r1.setBackgroundColor(Color.BLUE);
                break;
            case 2: r1.setBackgroundColor(Color.BLACK);
                break;
            case 3: r1.setBackgroundColor(Color.GREEN);
                break;
            case 4: r1.setBackgroundColor(Color.GRAY);
                break;
            case 5: r1.setBackgroundColor(Color.YELLOW);
                break;
            case 6: r1.setBackgroundColor(Color.MAGENTA);
                break;
            case 7: r1.setBackgroundColor(Color.LTGRAY);
                break;
            case 8: r1.setBackgroundColor(Color.CYAN);
                break;
            case 9: r1.setBackgroundColor(Color.DKGRAY);
                break;

        }

    }

    public String GeneratedPesel () {
        String PESEL;
        int p5;
        int p4;
        int p6;

        int p1 = ThreadLocalRandom.current().nextInt(0,9+1);
        int p2 = ThreadLocalRandom.current().nextInt(0,9+1);
        int p3 = ThreadLocalRandom.current().nextInt(0,1+1);
        if (p3 ==1)
        {p4 = ThreadLocalRandom.current().nextInt(0,2+1);}
        else
        {p4 = ThreadLocalRandom.current().nextInt(1,9+1);}
        if (p3!=2){
        p5 = ThreadLocalRandom.current().nextInt(0,3+1);}
        else
        {p5 = ThreadLocalRandom.current().nextInt(0,2+1);}

        if (p5<3&&p5!=0)
        {p6 = ThreadLocalRandom.current().nextInt(0,9+1);}
        else if (p5==0)
        {p6 = ThreadLocalRandom.current().nextInt(1,9+1);}
        else if (p4 == 1 || p4 == 3 || p4 ==5||p4==7||p4==8)
        {p6 = ThreadLocalRandom.current().nextInt(0,1+1);}
        else {
            p6 = 0;}
        int p7= ThreadLocalRandom.current().nextInt(0,9+1);
        int p8= ThreadLocalRandom.current().nextInt(0,9+1);
        int p9= ThreadLocalRandom.current().nextInt(0,9+1);
        int p10 = ThreadLocalRandom.current().nextInt(0,9+1);
        int test = p1*9+p2*7+p3*3+p4+p5*9+p6*7+p7*3+p8+p9*3+p10;
        int p11 = 0;
        while ((test+p11)%10 !=0){
            p11++;
        }
        PESEL = "" + p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 + p10 + p11;

        return PESEL;
    }

}
