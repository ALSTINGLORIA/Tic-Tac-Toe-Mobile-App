package com.example.tic_tac_toe_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class start_screen extends AppCompatActivity {
Intent startIntent;
TextView gameTitle;
LottieAnimationView splashScreenAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gameTitle = findViewById(R.id.gameTitle);
        splashScreenAnimation = findViewById(R.id.splashScreenAnimation);
        startIntent = new Intent(start_screen.this,ResultScreen.class);
        Animation title_animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.title_animation);
        gameTitle.startAnimation(title_animation);
        splashScreenAnimation.setAnimation(R.raw.tic_tac_toe_animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(startIntent);
            }
        },4000);

    }
}