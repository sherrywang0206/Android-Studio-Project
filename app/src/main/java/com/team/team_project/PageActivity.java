package com.team.team_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PageActivity extends AppCompatActivity {
    Button addbutton;
    Button tablebutton;
    Button foodbutton;
    Button chatbutton;

    Button boy;
    Button girl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(calcBMI);
        button.setOnClickListener(sexual);


        addbutton = findViewById(R.id.pencil);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });
        tablebutton = findViewById(R.id.table);
        tablebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageActivity.this, Analysis.class);
                startActivity(intent);
            }
        });

        foodbutton = findViewById(R.id.recommend);
        foodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageActivity.this, Food.class);
                startActivity(intent);
            }
        });
    }

    private View.OnClickListener calcBMI = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DecimalFormat nf = new DecimalFormat("0");
            EditText fieldheight = (EditText) findViewById(R.id.edheight);
            EditText fieldweight = (EditText) findViewById(R.id.edweight);
            EditText fieldage = (EditText) findViewById(R.id.editage);
            //身高
             int height = Integer.parseInt(fieldheight.getText().toString());
            //體重
             int weight = Integer.parseInt(fieldweight.getText().toString());
            //年齡
            int age = Integer.parseInt(fieldage.getText().toString());
            //計算出BMI
            double BMR = 66+(13.7*weight)+(5.0*height)-(6.8*age);
            double TDEE = BMR *1.2 ;

            //結果
            TextView result = (TextView) findViewById(R.id.result);
            result.setText(nf.format(TDEE));

        }
    };
    private View.OnClickListener sexual = new View.OnClickListener() {
        @Override

        public void onClick(View v) {

        }
    };
}

