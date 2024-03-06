package com.example.ubsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExchangeActivity extends AppCompatActivity {
    Button button_back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView;
        int[] images;
        String[] placeNames;
        String[] placeGuide;
        setContentView(R.layout.activity_exchange);
        recyclerView = findViewById(R.id.recycler_view);
        button_back3 = findViewById(R.id.exchange_back);
        button_back3.setOnClickListener(v -> ExchangeActivity.this.openHomeActivity());


        images = new int[]{R.drawable.utae1, R.drawable.utae2, R.drawable.utae3, R.drawable.utae5, R.drawable.utae6};

        placeNames = new String[]{"Homecoming Bash", "Commencement Ceremony", "UTA Sanitation Day", "TEDxUTA event", "UTA Rodeo"};

        placeGuide = new String[]{"https://events.uta.edu/event/homecoming_bash",
                "https://www.utacollegepark.com/events/events-calendar/index.php",
                "https://securelb.imodules.com/s/1909/giving/19/form.aspx?sid=1909&gid=2&pgid=1006&cid=2175&authkey=lE%2FT0fb6wuOW9soHgZdrxsr1tcIDNTx6pE1piEHNjRlMUE8yJSKmkA%3D%3D",
                "https://www.uta.edu/news/news-releases/2021/01/04/excel-program",
                "https://securelb.imodules.com/s/1909/giving/19/form.aspx?sid=1909&gid=2&pgid=1006&cid=2175&fid=2175"};

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        MyExchangeAdapter Adapter = new MyExchangeAdapter(ExchangeActivity.this, images, placeNames, placeGuide);
        recyclerView.setAdapter(Adapter);

    }

    private void openHomeActivity() {

        Intent intent = new Intent(ExchangeActivity.this, HomeActivity.class);
        startActivity(intent);
    }

}