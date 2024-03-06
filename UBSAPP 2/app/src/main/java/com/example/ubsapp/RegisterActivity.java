package com.example.ubsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    TextView banner, alreadyRegistered;
    private EditText editTextFullName, editTextEmail, editTextPassword, editTextConPassword;
    private Button registerButton;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerButton=findViewById(R.id.registerButton);
        editTextFullName=findViewById(R.id.fullName);
        editTextEmail=findViewById(R.id.email);
        editTextPassword=findViewById(R.id.password);
        editTextConPassword=findViewById(R.id.conpassword);
        alreadyRegistered=findViewById(R.id.alreadyRegistered);
        firebaseFirestore=FirebaseFirestore.getInstance();


        /* ref = firebaseFirestore.collection("the users").document(); */

        mAuth = FirebaseAuth.getInstance();

       /* if(mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),TestPage.class));
            finish();
        } */

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if(editTextFullName.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please type a name", Toast.LENGTH_SHORT).show();

                }else if(editTextEmail.getText().toString().equals("")) {
                    Toast.makeText(RegisterActivity.this, "Please type an email id", Toast.LENGTH_SHORT).show();

                }else if(!editTextEmail.getText().toString().contains("@mavs.uta.edu") && !email.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Make sure you have UTA email", Toast.LENGTH_LONG).show();

                }else if(editTextPassword.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please type a password", Toast.LENGTH_SHORT).show();

                }else if(editTextPassword.getText().toString().length() < 8) {
                    Toast.makeText(RegisterActivity.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();

                }else if(!editTextConPassword.getText().toString().equals(editTextPassword.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();

                }else {

                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful())
                                    {
                                        // send verification link
                                        FirebaseUser fuser = mAuth.getCurrentUser();
                                        fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(RegisterActivity.this, "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.d(TAG, "onFailure: Email not sent " + e.getMessage());
                                            }
                                        });

                                        userID = mAuth.getCurrentUser().getUid();
                                        DocumentReference documentReference = firebaseFirestore.collection("the users").document(userID);
                                        Map<String, Object> reg_entry = new HashMap<>();
                                        reg_entry.put("Name", editTextFullName.getText().toString());
                                        reg_entry.put("Email", editTextEmail.getText().toString());

                                        documentReference.set(reg_entry).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(RegisterActivity.this, "Successfully added", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Log.d("Error", e.getMessage());
                                                    }
                                                });
                                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                    } else {
                                        //   String myId = ref.getId();
                                        Toast.makeText(RegisterActivity.this, "Failed to register! Try again.", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                }
            }
        });

        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(goToLogin);
            }
        });
    }
}