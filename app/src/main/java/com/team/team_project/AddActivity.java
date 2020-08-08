package com.team.team_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    Button tablebutton;
    Button foodbutton;
    Button profilebutton;
    Button chatbutton;

    Button addBt;
    TextView allCaltx;
    TextView leftCaltx;
    TextView allPricetx;
    private MyAdapter adapter;
    private ArrayList<foodSet> foodsets= new ArrayList<>();
    private RecyclerView recyclerView;

    //接收資料
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode,data);

        if(requestCode==1 && resultCode== Activity.RESULT_OK){

            String name=data.getExtras().getString("foodNm");
            int price =data.getExtras().getInt("foodPrice");
            double cal=data.getExtras().getDouble("foodCal");
            foodsets.add(new foodSet(name,price,cal));

             adapter=new MyAdapter(foodsets);
             recyclerView.setAdapter(adapter);


            adapter.notifyDataSetChanged();

        }
    }
    static myCal content=new myCal();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
        recyclerView.setLayoutManager(linearLayoutManager); //設定 LayoutManager
        foodsets.add(new foodSet("蛋糕",1234,5.5));

        adapter= new MyAdapter(foodsets);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        //設定 Adapter

        allCaltx=findViewById(R.id.allCal);
        leftCaltx=findViewById(R.id.leftCal);
        allPricetx=findViewById(R.id.allPrice);

        allCaltx.setText("總攝取熱量"+content.allCal+"Kcal");
        leftCaltx.setText("剩餘熱量"+content.leftCal+"Kcal");
        allPricetx.setText("金額"+content.allPrice+"元");

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
       addBt= findViewById(R.id.addBt);
        addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(AddActivity.this,AddNewActivity.class),1
                );

            }
        });


    }

    public static class  myCal{

        Double allCal;
        Double leftCal;
        int allPrice;
        myCal(){
            allCal=100.0;
            leftCal=0.0;
            allPrice=0;
        }

    }
     class foodSet{
        String foodNm;
        int foodPrice;
        Double foodCal;
        foodSet(){
            foodNm="";
            foodPrice=0;
            foodCal=0.0;
        }
        foodSet( String foodNm,  int foodPrice,Double foodCal){
            this.foodNm=foodNm;
            this.foodPrice=foodPrice;
            this.foodCal=foodCal;
        }

         public String getFoodNm() {
             return foodNm;
         }

         public void setFoodNm(String foodNm) {
             this.foodNm = foodNm;
         }

         public int getFoodPrice() {
             return foodPrice;
         }

         public void setFoodPrice(int foodPrice) {
             this.foodPrice = foodPrice;
         }

         public Double getFoodCal() {
             return foodCal;
         }

         public void setFoodCal(Double foodCal) {
             this.foodCal = foodCal;
         }

         @Override
         public String toString() {
             return "foodSet{" +
                     "foodNm='" + foodNm + '\'' +
                     ", foodPrice=" + foodPrice +
                     ", foodCal=" + foodCal +
                     '}';
         }
     }
    class MyAdapter extends RecyclerView.Adapter <MyAdapter.ViewHolder>{
        public  ArrayList<foodSet> foodsets;
         MyAdapter(ArrayList<foodSet> foodset)
        {
          foodsets=foodset;

        }
//實作viewholder
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView foodNm;
        private TextView foodPrice;
        private TextView foodCal;

        public ViewHolder(View v){
        super(v);
            foodNm=v.findViewById(R.id.foodNm);
            foodPrice=v.findViewById(R.id.foodPrice);
             foodCal= v.findViewById(R.id.foodCal);


    }
}
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_row,parent,false);
            ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
        }


        @Override //資料與元件綁定
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.foodNm.setText(foodsets.get(position).getFoodNm().toString());
            holder.foodPrice.setText(String.valueOf(foodsets.get(position).getFoodPrice()));
            holder.foodCal.setText(foodsets.get(position).getFoodCal().toString());
            Log.e("test",foodsets.get(position).getFoodNm());
        }
        @Override
        public int getItemCount() {
            return foodsets.size();
        }

    }

}
