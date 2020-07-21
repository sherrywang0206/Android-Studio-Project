package com.team.team_project;

import androidx.appcompat.app.AppCompatActivity;

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

public class PageActivity extends AppCompatActivity {
    Button addbutton;
    Button tablebutton;
    Button foodbutton;
    Button chatbutton;
    EditText fieldheight, fieldweight, fieldage;
    RadioGroup sex, work;
    RadioButton no, low, active, high;
    TextView result,carresult,porresult,fatresult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

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

    //    public  calcBMI  (View v)  {
    private View.OnClickListener calcBMI = new View.OnClickListener() {
        public void onClick(View v) {
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
                        double TDEE = BMRboy * 1.2;
                        double TDEEcar = (TDEE*0.65)/4;
                        double TDEEpor = (TDEE*0.125)/4;
                        double TDEEfat = (TDEE*0.225)/9;
                        TextView result = (TextView) findViewById(R.id.result);
                        result.setText(nf.format(TDEE));
//                       算碳水化合物
                        TextView carresult = findViewById(R.id.carresult);
                        carresult.setText(nf.format(TDEEcar));
                        //算蛋白質
                        TextView porresult = findViewById(R.id.portineresult);
                        porresult.setText(nf.format(TDEEpor));
                        //算脂肪
                        TextView fatresult = findViewById(R.id.fatresult);
                        fatresult.setText(nf.format(TDEEfat));

                    case R.id.low:
                        TDEE = BMRboy * 1.375;
                        TDEEcar = (TDEE*0.65)/4;
                        TDEEpor = (TDEE*0.125)/4;
                        TDEEfat = (TDEE*0.225)/9;
                         result = (TextView) findViewById(R.id.result);
                         result.setText(nf.format(TDEE));
//                        算碳水化合物
                        carresult = findViewById(R.id.carresult);
                        carresult.setText(nf.format(TDEEcar));
                        //算蛋白質
                        porresult = findViewById(R.id.portineresult);
                        porresult.setText(nf.format(TDEEpor));
                        //算脂肪
                         fatresult = findViewById(R.id.fatresult);
                        fatresult.setText(nf.format(TDEEfat));
                        break;
                    case R.id.active:
                        TDEE = BMRboy * 1.55;
                        TDEEcar = (TDEE*0.65)/4;
                        TDEEpor = (TDEE*0.125)/4;
                        TDEEfat = (TDEE*0.225)/9;
                        result = (TextView) findViewById(R.id.result);
                        result.setText(nf.format(TDEE));
//                        算碳水化合物
                        carresult = findViewById(R.id.carresult);
                        carresult.setText(nf.format(TDEEcar));
                        //算蛋白質
                        porresult = findViewById(R.id.portineresult);
                        porresult.setText(nf.format(TDEEpor));
                        //算脂肪
                        fatresult = findViewById(R.id.fatresult);
                        fatresult.setText(nf.format(TDEEfat));
                        break;
                    case R.id.highactive:
                         TDEE = BMRboy * 1.725;
                        TDEEcar = (TDEE*0.65)/4;
                        TDEEpor = (TDEE*0.125)/4;
                        TDEEfat = (TDEE*0.225)/9;
                        result = (TextView) findViewById(R.id.result);
                        result.setText(nf.format(TDEE));
//                        算碳水化合物
                        carresult = findViewById(R.id.carresult);
                        carresult.setText(nf.format(TDEEcar));
                        //算蛋白質
                        porresult = findViewById(R.id.portineresult);
                        porresult.setText(nf.format(TDEEpor));
                        //算脂肪
                        fatresult = findViewById(R.id.fatresult);
                        fatresult.setText(nf.format(TDEEfat));
                        break;

                }

            } else if (sex.getCheckedRadioButtonId() == R.id.girl) {
                switch (work.getCheckedRadioButtonId()) {
                    case R.id.no:
                        double TDEE = BMRgirl * 1.2;
                        double TDEEcar = (TDEE*0.65)/4;
                        double TDEEpor = (TDEE*0.125)/4;
                        double TDEEfat = (TDEE*0.225)/9;
                        TextView result = (TextView) findViewById(R.id.result);
                        TextView carresult = findViewById(R.id.carresult);
                        //算碳水化合物
                        result.setText(nf.format(TDEE));
                        carresult.setText(nf.format(TDEEcar));
                        //算蛋白質
                        TextView porresult = findViewById(R.id.portineresult);
                        porresult.setText(nf.format(TDEEpor));
                        //算脂肪
                       TextView fatresult = findViewById(R.id.fatresult);
                        fatresult.setText(nf.format(TDEEfat));


                        break;
                    case R.id.low:
                       TDEE = BMRgirl * 1.375;
                        TDEEcar = (TDEE*0.65)/4;
                        TDEEpor = (TDEE*0.125)/4;
                        TDEEfat = (TDEE*0.225)/9;
                        result = (TextView) findViewById(R.id.result);
                        result.setText(nf.format(TDEE));
                        // 算碳水化合物
                        carresult = findViewById(R.id.carresult);
                        carresult.setText(nf.format(TDEEcar));
                        //算蛋白質
                        porresult = findViewById(R.id.portineresult);
                        porresult .setText(nf.format(TDEEpor));
                        //算脂肪
                        fatresult = findViewById(R.id.fatresult);
                        fatresult.setText(nf.format(TDEEfat));
                        break;
                    case R.id.active:
                        TDEE = BMRgirl * 1.55;
                        TDEEcar = (TDEE*0.65)/4;
                        TDEEpor = (TDEE*0.125)/4;
                        TDEEfat = (TDEE*0.225)/9;
                        result = (TextView) findViewById(R.id.result);
                        result.setText(nf.format(TDEE));
//                      算碳水化合物
                        carresult = findViewById(R.id.carresult);
                        carresult.setText(nf.format(TDEEcar));
                        //算蛋白質
                        porresult = findViewById(R.id.portineresult);
                        porresult .setText(nf.format(TDEEpor));
                        //算脂肪
                        fatresult = findViewById(R.id.fatresult);
                        fatresult.setText(nf.format(TDEEfat));
                        break;
                    case R.id.highactive:
                        TDEE = BMRgirl * 1.725;
                        TDEEcar = (TDEE*0.65)/4;
                        TDEEpor = (TDEE*0.125)/4;
                        TDEEfat = (TDEE*0.225)/9;
                       result = (TextView) findViewById(R.id.result);
                        result.setText(nf.format(TDEE));
//                      算碳水化合物
                        carresult = findViewById(R.id.carresult);
                        carresult.setText(nf.format(TDEEcar));
                        //算蛋白質
                        porresult = findViewById(R.id.portineresult);
                        porresult .setText(nf.format(TDEEpor));
                        //算脂肪
                        fatresult = findViewById(R.id.fatresult);
                        fatresult.setText(nf.format(TDEEfat));
                        break;
                }
            }
//            Intent intent = new Intent();
//            intent.setClass(PageActivity.this, AddActivity.class);
//                 Bundle bundle = new Bundle();
//                    bundle.putString("TEDD",result.getText().toString());
//                    intent.putExtras(bundle);   // 記得put進去，不然資料不會帶過去哦
//
//                startActivity(intent);
            };
        };
    };










