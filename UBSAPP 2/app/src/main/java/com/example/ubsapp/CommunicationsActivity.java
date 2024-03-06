package com.example.ubsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CommunicationsActivity extends AppCompatActivity {
    Button button_back5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communications);
        button_back5 = findViewById(R.id.communications_back);
        button_back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });
    }

    private void openHomeActivity() {

        Intent intent = new Intent(CommunicationsActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}