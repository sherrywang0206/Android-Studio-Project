package com.team.team_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Analysis extends AppCompatActivity {
    Button addbutton;
    Button profilebutton;
    Button foodbutton;
    Button chatbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        addbutton  = findViewById(R.id.pencil);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analysis.this,AddActivity.class);
                startActivity(intent);
            }
        });

        profilebutton  = findViewById(R.id.profile);
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analysis.this,PageActivity.class);
                startActivity(intent);
            }
        });
        foodbutton = findViewById(R.id.recommend);
        foodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analysis.this,Food.class);
                startActivity(intent);
            }
        });
       chatbutton = findViewById(R.id.chat);
     chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Analysis.this,Chat.class);
                startActivity(intent);
            }
        });
    }
}
