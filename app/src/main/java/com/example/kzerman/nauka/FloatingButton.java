package com.example.kzerman.nauka;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static  com.example.kzerman.nauka.R.id.TajnyTekst;
import static com.example.kzerman.nauka.R.id.ll;

public class FloatingButton extends AppCompatActivity {

    ConstraintLayout layout;
    TextView tajny;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_button);
        initialization();
    }

    public void initialization (){
        tajny = (TextView) findViewById(TajnyTekst);
        layout = (ConstraintLayout) findViewById(ll);
        counter = -2;
    }

    public void click (View v){

        counter ++;
        switch (counter){
            case -1:
                tajny.setText("To pierwszy i ostatni raz jak mnie dotykasz!!!");
                break;
            case 0:
                tajny.setText("Nie dotykaj mnie   -_-");
                break;
            case 1:
                tajny.setText("ZOSTAW!");
                break;
            case 2:
                tajny.setText("Pozalujesz tego!!!");
                break;
            case 3:
                tajny.setText("NIEEEEEEE!!!!!!!!");
                break;
            case 4:
                tajny.setText("Fuck you");
                break;
            case 5:
                tajny.setVisibility(View.INVISIBLE);
                layout.setBackgroundColor(Color.RED);
                break;
        }


    }
}
