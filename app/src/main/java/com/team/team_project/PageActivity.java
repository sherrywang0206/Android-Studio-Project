package com.team.team_project;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup;

import java.text.DecimalFormat;

public class PageActivity extends Activity {

    Button addbutton;
    Button tablebutton;
    Button foodbutton;
    Button chatbutton;
    EditText fieldheight, fieldweight, fieldage;
    RadioGroup sex, work;
    RadioButton no, low, active, high;
    TextView result,carresult,porresult,fatresult;
    Double TDEE,TDEEcar,TDEEpor,TDEEfat;

    private GlobalV gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        gv= (GlobalV) getApplication();


        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(calcBMI);
        sex = findViewById(R.id.sex);
        work = findViewById(R.id.work);
        no = findViewById(R.id.no);
        low = findViewById(R.id.low);
        active = findViewById(R.id.active);
        high = findViewById(R.id.highactive);
        fieldheight = (EditText) findViewById(R.id.edheight);
        fieldweight = (EditText) findViewById(R.id.edweight);
        fieldage = (EditText) findViewById(R.id.editage);
        result = (TextView) findViewById(R.id.result);
        carresult =(TextView)  findViewById(R.id.carresult);
        porresult = (TextView) findViewById(R.id.portineresult);
        fatresult = (TextView) findViewById(R.id.fatresult);
        DecimalFormat nf = new DecimalFormat("0");

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
        chatbutton = findViewById(R.id.chat);
        chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageActivity.this,Chat.class);
                startActivity(intent);
            }
        });
//        gv.setCal(160.0);
//        result.setText((nf.format( gv.getCal())));
    }

    public View.OnClickListener calcBMI = new View.OnClickListener() {

        public void onClick(View v) {

//            GlobalVariable gv = (GlobalVariable)getApplicationContext();
            DecimalFormat nf = new DecimalFormat("0");
            //身高
            double height = Double.parseDouble(fieldheight.getText().toString());
            //體重
            double weight = Double.parseDouble(fieldweight.getText().toString());
            //年齡
            int age = Integer.parseInt(fieldage.getText().toString());

            double BMRboy = 66 + (13.7 * weight) + (5.0 * height) - (6.8 * age);
            double BMRgirl = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);

            if (sex.getCheckedRadioButtonId() == R.id.boy) {

                switch (work.getCheckedRadioButtonId()) {

                    case R.id.no:
//                         TDEE =BMRboy * 1.2;
                        // TDEEcar = (TDEE*0.65)/4;
//                         TDEEpor = (TDEE*0.125)/4;
//                        TDEEfat = (TDEE*0.225)/9;

                        gv.setCal((BMRboy * 1.2));
                        gv.setCarbonhydrate((gv.getCal() * 0.65) / 4);
                        gv.setProtein((gv.getCal() * 0.125 / 4));
                        gv.setFat((gv.getCal() * 0.225 / 9));

                        //開算
                        result.setText((nf.format( gv.getCal())));
                        carresult.setText(nf.format(gv.getCarbohydrate()));
                        porresult.setText(nf.format(gv.getProtein()));
                        fatresult.setText(nf.format(gv.getFat()));

//                        result.setText(nf.format(TDEE));
//                        carresult.setText(nf.format(TDEEcar));
//                        porresult.setText(nf.format(TDEEpor));
//                        fatresult.setText(nf.format(TDEEfat));


                    case R.id.low:


                        gv.setCal(BMRboy * 1.375);
                        gv.setCarbonhydrate((gv.getCal() * 0.65) / 4);
                        gv.setProtein((gv.getCal() * 0.125 / 4));
                        gv.setFat((gv.getCal() * 0.225 / 9));
//                        TDEE =BMRboy * 1.375;
//                        TDEEcar = (TDEE*0.65)/4;
//                        TDEEpor = (TDEE*0.125)/4;
//                        TDEEfat = (TDEE*0.225)/9;

                        result.setText(nf.format(gv.getCal()));
                        carresult.setText(nf.format(gv.getCarbohydrate()));
                        porresult.setText(nf.format(gv.getProtein()));
                        fatresult.setText(nf.format(gv.getFat()));

//                        result.setText(nf.format(TDEE));
//                        carresult.setText(nf.format(TDEEcar));
//                        porresult.setText(nf.format(TDEEpor));
//                        fatresult.setText(nf.format(TDEEfat));

                        break;
                    case R.id.active:
                        gv.setCal(BMRboy * 1.55);
                        gv.setCarbonhydrate((gv.getCal() * 0.65) / 4);
                        gv.setProtein((gv.getCal() * 0.125 / 4));
                        gv.setFat((gv.getCal() * 0.225 / 9));
//                        TDEE =BMRboy * 1.55;
//                        TDEEcar = (TDEE*0.65)/4;
//                        TDEEpor = (TDEE*0.125)/4;
//                        TDEEfat = (TDEE*0.225)/9;

                        result.setText(nf.format(gv.getCal()));
                        carresult.setText(nf.format(gv.getCarbohydrate()));
                        porresult.setText(nf.format(gv.getProtein()));
                        fatresult.setText(nf.format(gv.getFat()));
//                        result.setText(nf.format(TDEE));
//                        carresult.setText(nf.format(TDEEcar));
//                        porresult.setText(nf.format(TDEEpor));
//                        fatresult.setText(nf.format(TDEEfat));
                        break;
                    case R.id.highactive:
                        gv.setCal(BMRboy * 1.725);
                        gv.setCarbonhydrate((gv.getCal() * 0.65) / 4);
                        gv.setProtein((gv.getCal() * 0.125 / 4));
                        gv.setFat((gv.getCal() * 0.225 / 9));
//                        TDEE =BMRboy * 1.75;
//                        TDEEcar = (TDEE*0.65)/4;
//                        TDEEpor = (TDEE*0.125)/4;
//                        TDEEfat = (TDEE*0.225)/9;
                        result.setText(nf.format(gv.getCal()));
                        carresult.setText(nf.format(gv.getCarbohydrate()));
                        porresult.setText(nf.format(gv.getProtein()));
                        fatresult.setText(nf.format(gv.getFat()))  ;
//                        result.setText(nf.format(TDEE));
//                        carresult.setText(nf.format(TDEEcar));
//                        porresult.setText(nf.format(TDEEpor));
//                        fatresult.setText(nf.format(TDEEfat));
                        break;

                }
            }else if (sex.getCheckedRadioButtonId() == R.id.girl) {

                switch (work.getCheckedRadioButtonId()) {
                    case R.id.no:
                        gv.setCal( BMRgirl * 1.2);
                        gv.setCarbonhydrate((gv.getCal()*0.65)/4);
                        gv.setProtein((gv.getCal()*0.125/4));
                        gv.setFat((gv.getCal()*0.225/9));
//                        TDEE =BMRgirl * 1.2;
//                        TDEEcar = (TDEE*0.65)/4;
//                        TDEEpor = (TDEE*0.125)/4;
//                        TDEEfat = (TDEE*0.225)/9;

                        result.setText(nf.format(gv.getCal()));
                        carresult.setText(nf.format(gv.getCarbohydrate()));
                        porresult.setText(nf.format(gv.getProtein()));
                        fatresult.setText(nf.format(gv.getFat()));

//                        result.setText(nf.format(TDEE));
//                        carresult.setText(nf.format(TDEEcar));
//                        porresult.setText(nf.format(TDEEpor));
//                        fatresult.setText(nf.format(TDEEfat));
                        break;
                    case R.id.low:
                        gv.setCal( BMRgirl * 1.375);
                        gv.setCarbonhydrate((gv.getCal()*0.65)/4);
                        gv.setProtein((gv.getCal()*0.125/4));
                        gv.setFat((gv.getCal()*0.225/9));
//                        TDEE =BMRgirl * 1.375;
//                        TDEEcar = (TDEE*0.65)/4;
//                        TDEEpor = (TDEE*0.125)/4;
//                        TDEEfat = (TDEE*0.225)/9;

                        result.setText(nf.format(gv.getCal()));
                        carresult.setText(nf.format(gv.getCarbohydrate()));
                        porresult .setText(nf.format(gv.getProtein()));
                        fatresult.setText(nf.format(gv.getFat()));

//                        result.setText(nf.format(TDEE));
//                        carresult.setText(nf.format(TDEEcar));
//                        porresult.setText(nf.format(TDEEpor));
//                        fatresult.setText(nf.format(TDEEfat));
                        break;
                    case R.id.active:
                        gv.setCal( BMRgirl * 1.55);
                        gv.setCarbonhydrate((gv.getCal()*0.65)/4);
                        gv.setProtein((gv.getCal()*0.125/4));
                        gv.setFat((gv.getCal()*0.225/9));

//                        TDEE =BMRgirl * 1.55;
//                        TDEEcar = (TDEE*0.65)/4;
//                        TDEEpor = (TDEE*0.125)/4;
//                        TDEEfat = (TDEE*0.225)/9;

                        result.setText(nf.format(gv.getCal()));
                        carresult.setText(nf.format(gv.getCarbohydrate()));
                        porresult .setText(nf.format(gv.getProtein()));
                        fatresult.setText(nf.format(gv.getFat()));

//                        result.setText(nf.format(TDEE));
//                        carresult.setText(nf.format(TDEEcar));
//                        porresult.setText(nf.format(TDEEpor));
//                        fatresult.setText(nf.format(TDEEfat));
                        break;
                    case R.id.highactive:
                        gv.setCal( BMRgirl * 1.725);
                        gv.setCarbonhydrate((gv.getCal()*0.65)/4);
                        gv.setProtein((gv.getCal()*0.125/4));
                        gv.setFat((gv.getCal()*0.225/9));

//                        TDEE =BMRgirl * 1.725;
//                        TDEEcar = (TDEE*0.65)/4;
//                        TDEEpor = (TDEE*0.125)/4;
//                        TDEEfat = (TDEE*0.225)/9;
//
                        result.setText(nf.format(gv.getCal()));
                        carresult.setText(nf.format(gv.getCarbohydrate()));
                        porresult .setText(nf.format(gv.getProtein()));
                        fatresult.setText(nf.format(gv.getFat()));

//                        result.setText(nf.format(TDEE));
//                        carresult.setText(nf.format(TDEEcar));
//                        porresult.setText(nf.format(TDEEpor));
//                        fatresult.setText(nf.format(TDEEfat));
                        break;
                }
            }
            };
        };
    };










