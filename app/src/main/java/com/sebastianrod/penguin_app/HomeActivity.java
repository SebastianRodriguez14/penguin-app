package com.sebastianrod.penguin_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import models.ActivitiesMethods;

public class HomeActivity extends AppCompatActivity {

    ImageView imageRandom;
    Button buttonChangeImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Integer[] images = {R.drawable.penguin01, R.drawable.penguin02, R.drawable.penguin03, R.drawable.penguin04, R.drawable.penguin05};

        imageRandom = findViewById(R.id.img_random);
        buttonChangeImage = findViewById(R.id.button_change_image);

        imageRandom.setImageResource(ActivitiesMethods.getImageRandom(images));

        buttonChangeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageRandom.setImageResource(ActivitiesMethods.getImageRandom(images));
            }
        });


    }
}