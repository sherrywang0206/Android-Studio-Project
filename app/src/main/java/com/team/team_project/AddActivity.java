package com.team.team_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class AddActivity extends AppCompatActivity {
    Button tablebutton;
    Button foodbutton;
    Button profilebutton;
    Button chatbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        tablebutton  = findViewById(R.id.table);
        tablebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this,Analysis.class);
                startActivity(intent);
            }
        });
        foodbutton  = findViewById(R.id.recommend);
        foodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this,Food.class);
                startActivity(intent);
            }
        });
        profilebutton  = findViewById(R.id.profile);
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this,PageActivity.class);
                startActivity(intent);
            }
        });
        chatbutton = findViewById(R.id.chat);
        chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this,Chat.class);
                startActivity(intent);
            }
        });
//        Bundle bundle = getIntent().getExtras();
//        TextView result = bundle.getString("TDEE");
//        DecimalFormat nf = new DecimalFormat("0");
//        result = (TextView) findViewById(R.id.TDEE);
//        result.setText(nf.format(TDEE));

    }
}
