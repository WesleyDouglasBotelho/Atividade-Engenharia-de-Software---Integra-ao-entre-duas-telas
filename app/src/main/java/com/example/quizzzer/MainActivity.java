package com.example.quizzzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startBtn, bookmarkBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.start_button);
        bookmarkBtn=findViewById(R.id.bookmarks_button);




        startBtn.setOnClickListener(view -> {
            Intent categoryIntent = new Intent(MainActivity.this, CategoriesActivity.class);
            startActivity(categoryIntent);
        });

        bookmarkBtn.setOnClickListener(view -> {
            Intent bookmarkIntent = new Intent(MainActivity.this, BookmarkActivity.class);
            startActivity(bookmarkIntent);
        });


    }
}