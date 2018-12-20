package com.foodmap.foodmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MarkerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker_info);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        float rating = Float.parseFloat(intent.getStringExtra("Rating"));

        //Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(name);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(rating);

    }
}
