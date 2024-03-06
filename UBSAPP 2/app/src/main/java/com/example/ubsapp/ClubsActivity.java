package com.example.ubsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ClubsActivity extends AppCompatActivity {
    Button button_back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        button_back1 = findViewById(R.id.clubs_back);
        button_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });
    }

    private void openHomeActivity() {

        Intent intent = new Intent(ClubsActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}