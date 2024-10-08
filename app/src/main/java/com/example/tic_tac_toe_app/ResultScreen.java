package com.example.tic_tac_toe_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultScreen extends AppCompatActivity {
    Button resetBtn;
    TextView resultTxt;
    Intent playIntent;
    Intent winnerIntent;
    int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resetBtn = findViewById(R.id.resetBtn);
        resultTxt = findViewById(R.id.resultTxt);
        playIntent = new Intent(ResultScreen.this, MainActivity.class);
        winnerIntent = getIntent();

        if (flag == 0) {
            String winner = winnerIntent.getStringExtra("winner");
            resultTxt.setText("Result:" + winner);
        }
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(playIntent);
            }
        });
    }
}