package com.example.discussit;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
=======

import android.content.Intent;
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class BaseActivity extends AppCompatActivity {

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.caro1, R.drawable.caro2, R.drawable.caro3, R.drawable.caro4, R.drawable.caro5};

<<<<<<< HEAD
    private ImageView openForum,chatbot,kalyan,irrigation,diseaseDetection;
=======
    private ImageView openForum,chatbot,kalyan;
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

<<<<<<< HEAD

        if (ContextCompat.checkSelfPermission(BaseActivity.this, Manifest.permission.CAMERA) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA},
                    50); }

=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        openForum = findViewById(R.id.openforum);
        chatbot = findViewById(R.id.chatbot);
        kalyan = findViewById(R.id.kalyan);
<<<<<<< HEAD
        irrigation = findViewById(R.id.irrigation);
        diseaseDetection = findViewById(R.id.diseaseDetection);
=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0


        openForum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this,Chatbot.class);
                startActivity(intent);
            }
        });

        kalyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this,Education.class);
                startActivity(intent);
            }
        });

<<<<<<< HEAD
        irrigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this,Irrigation.class);
                startActivity(intent);
            }
        });

        diseaseDetection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this,CameraActivity.class);
                startActivity(intent);
            }
        });

=======
>>>>>>> 759e75e13f57db66b39d99aca529f8cdc433b9c0
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
    }

