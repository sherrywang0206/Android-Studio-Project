package com.team.team_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class Food extends AppCompatActivity {
    Button addbutton;
    Button tablebutton;
    Button profilebutton;
    Button chatbuttom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        addbutton  = findViewById(R.id.pencil);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food.this,AddActivity.class);
                startActivity(intent);
            }
        });
        tablebutton  = findViewById(R.id.table);
        tablebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food.this,Analysis.class);
                startActivity(intent);
            }
        });

        profilebutton  = findViewById(R.id.profile);
        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food.this,PageActivity.class);
                startActivity(intent);
            }
        });
        chatbuttom = findViewById(R.id.chat);
       chatbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Food.this,Chat.class);
                startActivity(intent);
            }
        });


            }

        }


