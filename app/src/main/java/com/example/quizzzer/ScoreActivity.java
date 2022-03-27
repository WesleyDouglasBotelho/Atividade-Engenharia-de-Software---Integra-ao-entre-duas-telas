package com.example.quizzzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView scored, total;
    private Button doneBtn;
    private Button btncompartilhar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scored=findViewById(R.id.scored);
        total=findViewById(R.id.total);
        doneBtn=findViewById(R.id.done_btn);
        btncompartilhar = findViewById(R.id.btnCompatilhar);


        scored.setText(String.valueOf(getIntent().getIntExtra("score", 0)));
        total.setText("do total de " + String.valueOf(getIntent().getIntExtra("total", 0)));


        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btncompartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nEu consegui " + scored + " de 5, você também pode tentar!!\n \n \n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    e.toString();
                }

            }
        });


    }
}