package com.example.ubsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1 = findViewById(R.id.search_btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchActivity();
            }
        });
        btn2 = findViewById(R.id.exchange_btn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExchangeActivity();
            }
        });
        btn3 = findViewById(R.id.payments_btn);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPaymentsActivity();
            }

        });
        btn4 = findViewById(R.id.clubs_btn);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openClubsActivity();
            }
        });
        btn5 = findViewById(R.id.communication_btn);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCommunicationsActivity();
            }
        });

    }

    private void openCommunicationsActivity() {
        Intent intent = new Intent(HomeActivity.this, CommunicationsActivity.class);
        startActivity(intent);
    }

    private void openClubsActivity() {
        Intent intent = new Intent(HomeActivity.this, ClubsActivity.class);
        startActivity(intent);
    }

    private void openPaymentsActivity() {
        Intent intent = new Intent(HomeActivity.this, PaymentsActivity.class);
        startActivity(intent);
    }


    private void openExchangeActivity() {
        Intent intent = new Intent(HomeActivity.this, ExchangeActivity.class);
        startActivity(intent);
    }


    private void openSearchActivity() {
        Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
        startActivity(intent);
    }
}

