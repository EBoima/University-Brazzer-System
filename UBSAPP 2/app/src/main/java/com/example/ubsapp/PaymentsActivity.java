package com.example.ubsapp;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentsActivity extends AppCompatActivity {

    private Button payButton;
    private Button goBack;
    private TextView payWithCash;
    private EditText cCardNum;
    private EditText exDate;
    private EditText cHolder;
    private EditText securityCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        payButton = (Button) findViewById(R.id.payNowButton);
        goBack = (Button) findViewById(R.id.backButton);
        cCardNum = (EditText) findViewById(R.id.cardNumber);
        exDate = (EditText) findViewById(R.id.expDate);
        cHolder = (EditText) findViewById(R.id.cardHolder);
        securityCode = (EditText) findViewById(R.id.CCV);
        payWithCash = (TextView) findViewById(R.id.cashPaymentText);


        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardNum = cCardNum.getText().toString();
                String expDate = exDate.getText().toString();
                String cardHolder = cHolder.getText().toString();
                String CCV = securityCode.getText().toString();


                if (!TextUtils.isEmpty(cardNum) && !TextUtils.isEmpty(expDate)) {

                    if (TextUtils.isEmpty(cardHolder)) {
                        Toast.makeText(PaymentsActivity.this, "Make sure you enter a valid name", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (cardNum.length() < 16 || cardNum.length() > 16) {
                        Toast.makeText(PaymentsActivity.this, "Make sure you have 16 digits for CC", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (expDate.length() < 6 || expDate.length() > 6) {
                        Toast.makeText(PaymentsActivity.this, "Make sure you have 6 digits for expiration date", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (CCV.length() < 3 || CCV.length() > 3) {
                        Toast.makeText(PaymentsActivity.this, "Make sure you have 3 digits for CCV", Toast.LENGTH_SHORT).show();
                        return;
                    }try {
                        Long num = Long.parseLong(cardNum);
                        Toast.makeText(PaymentsActivity.this, "Payment Successful", Toast.LENGTH_SHORT).show();

                        Intent startMain = new Intent(PaymentsActivity.this, HomeActivity.class);
                        startActivity(startMain);



                    } catch (NumberFormatException e) {
                        Toast.makeText(PaymentsActivity.this, "Make sure you have entered numbers", Toast.LENGTH_SHORT).show();
                    }

                }


            }

        });


        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMain = new Intent(PaymentsActivity.this, HomeActivity.class);
                startActivity(startMain);
            }
        });


        payWithCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cashPage = new Intent(PaymentsActivity.this, HomeActivity.class);
                startActivity(cashPage);
            }
        });


    }
}



