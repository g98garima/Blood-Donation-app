package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
    public ImageView splash_logo;
    public TextView splash_title, splash_slogan;


    Animation top_animation, bottom_animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*splash screen to span over the entire screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        splash_logo = findViewById(R.id.splash_logo);
        splash_title = findViewById(R.id.splash_title);
        splash_slogan = findViewById(R.id.splash_slogan);

        top_animation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom_animation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        splash_logo.setAnimation(top_animation);
        splash_title.setAnimation(bottom_animation);
        splash_slogan.setAnimation(bottom_animation);

        int SPLASH_SCREEN = 4300;

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, loginActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_SCREEN);


    }
}