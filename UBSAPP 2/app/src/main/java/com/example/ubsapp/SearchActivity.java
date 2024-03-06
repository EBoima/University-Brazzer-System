package com.example.ubsapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchActivity extends AppCompatActivity {
    Button button_back4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        button_back4 = findViewById(R.id.search_back);
        button_back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.this.openHomeActivity();
            }
        });


        RecyclerView recyclerView = findViewById(R.id.result_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Users[] myUserData = new Users[]{
                new Users("Free Pizza", "Sign up for an event and enjoy free pizza at ERB 101!!", R.drawable.pizza),
                new Users("Coffee Break", "Hangout with your friends at the UC market while enjoying delicious coffee from us !!", R.drawable.coffeebreak),
                new Users("Fundamentals of physics -10th edition (Halliday & Resnick)", "Book on sale for 20% off. Grab your offer now!!", R.drawable.book1),
                new Users("Physics by David Homer", "Physics book on the store 2014 edition.", R.drawable.book2),
                new Users("Algebra I", "Beginners' algebra is now available at the store.", R.drawable.bookai),
                new Users("Algebra II", "Prentice Hall Mathematics.", R.drawable.bookaii),
                new Users("Java Programming", "The Absolute java for Beginners Guide.", R.drawable.javabook),
                new Users("Uta Hoodie", "Blue &Orange UTA printed Hoodies available at the store now! check it out.", R.drawable.uta_hoodie1),
                new Users("Swag Hoodie", "Checkout the store for Offer!", R.drawable.uta_hoodie2)

        };
        MySearchAdapter mySearchAdapter = new MySearchAdapter(myUserData, SearchActivity.this);
        recyclerView.setAdapter(mySearchAdapter);

    }

    private void openHomeActivity() {
        Intent intent = new Intent(SearchActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}