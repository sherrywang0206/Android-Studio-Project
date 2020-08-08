package com.team.team_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewActivity extends AppCompatActivity {
    EditText foodNm;
    EditText foodPrice;
    EditText foodCal;
    Button addBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        foodNm=findViewById(R.id.foodNm);
        foodPrice=findViewById(R.id.foodPrice);
        foodCal=findViewById(R.id.foodCal);
        addBt=findViewById(R.id.addBt);
        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle newfood= new Bundle();
                newfood.putString("foodNm",foodNm.getText().toString());
                newfood.putInt("foodPrice",Integer.valueOf(foodPrice.getText().toString()));
                newfood.putDouble("foodCal",Double.valueOf(foodCal.getText().toString()));

                Intent intent= new Intent(AddNewActivity.this,AddActivity.class);
                setResult(Activity.RESULT_OK,intent.putExtras(newfood));
               // startActivity(intent);

                finish();

                //Intent intent = new Intent(AddNewActivity.this,AddActivity.class);
                //startActivity(intent);
            }
        });

    }

}
