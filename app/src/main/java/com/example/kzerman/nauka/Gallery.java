package com.example.kzerman.nauka;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


import static android.widget.ImageSwitcher.*;
import static com.example.kzerman.nauka.R.id.button;
import static com.example.kzerman.nauka.R.id.imageSwitcher;
import static com.example.kzerman.nauka.R.id.layoutt;
import static com.example.kzerman.nauka.R.id.nextImageButton;

public class Gallery extends AppCompatActivity {

    int imageSwitcherImages[] = {R.drawable.untitle3d,R.drawable.untitled,R.drawable.forest,R.drawable.forest2,R.drawable.forest3};
    int switcherImage = imageSwitcherImages.length;
    int counter = -1;
    ImageSwitcher imswticher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery3);
         imswticher = (ImageSwitcher) findViewById(imageSwitcher);
        Button nextBut = (Button) findViewById(nextImageButton);

        imswticher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ConstraintLayout ly = (ConstraintLayout) findViewById(layoutt);
                ly.setBackgroundColor(Color.BLACK);
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT
                ));
                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(R.drawable.untitle3d);
                return switcherImageView;
            }
        });
        Animation animationOut = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        Animation animationIn = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);

        imswticher.setOutAnimation(animationOut);
        imswticher.setInAnimation(animationIn);
    }
public void nextImageButton (View v){
    counter ++;
    if (counter == switcherImage)
        counter = 0;
    imswticher.setImageResource(imageSwitcherImages[counter]);

    }

    }


