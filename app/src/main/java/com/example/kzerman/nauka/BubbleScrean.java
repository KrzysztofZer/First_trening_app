package com.example.kzerman.nauka;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import static com.example.kzerman.nauka.R.id.VS;
import static com.example.kzerman.nauka.R.id.im2;
import static com.example.kzerman.nauka.R.id.tv2;

public class BubbleScrean extends AppCompatActivity {
private static Context context;

    ViewSwitcher vs;
    ImageView iv;
    TextView tekst;
    public int intTablicy =0;
    private GestureDetector mGestureDetector;
int[] kolory ;
String [] nazwy = new String[] {"rozowy","czerwony","pomaranczowy","zolty","chart...","zielony","wiosenno-zielony","cyan","azure","niebieski","Violet","bank millennium xD"};
    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_screan);
        BubbleScrean.context = getApplicationContext();
        initiation();
    }

    void initiation (){
        kolory = context.getResources().getIntArray(R.array.Colors);
        iv = (ImageView) findViewById(R.id.im2);
        tekst = (TextView)findViewById(R.id.tv2);
        vs = (ViewSwitcher) findViewById(VS);
        iv.setColorFilter(kolory[intTablicy]);
        tekst.setText(nazwy[intTablicy]);
        CustomeGestureDetector customGestureDetector = new CustomeGestureDetector();
        mGestureDetector = new GestureDetector(this, customGestureDetector);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ((ViewGroup) findViewById(R.id.liner)).getLayoutTransition()
                    .enableTransitionType(LayoutTransition.CHANGING);
        }


    }

class CustomeGestureDetector implements GestureDetector.OnGestureListener {

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        if (motionEvent.getX()>motionEvent1.getX())
zmienKolor(0);
            if (motionEvent.getX()<motionEvent1.getX())
zmienKolor(1);
        return false;
    }
}

public boolean onTouchEvent (MotionEvent event){
    mGestureDetector.onTouchEvent(event);
    return super.onTouchEvent(event);
}

void zmienKolor (int a){
    if (a==0){
        if (intTablicy < 11){
            intTablicy ++;
            iv.setColorFilter(kolory[intTablicy]);
            tekst.setText(nazwy[intTablicy]);
        }
        else {
            intTablicy =0;
            iv.setColorFilter(kolory[intTablicy]);
            tekst.setText(nazwy[intTablicy]);
        }}
    if (a==1){
        if (intTablicy > 0){
            intTablicy --;
            iv.setColorFilter(kolory[intTablicy]);
            tekst.setText(nazwy[intTablicy]);
        }
        else {
            intTablicy =11;
            iv.setColorFilter(kolory[intTablicy]);
            tekst.setText(nazwy[intTablicy]);
        }
    }


}


}
