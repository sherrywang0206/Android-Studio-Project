package com.team.team_project;

import android.app.Application;

import java.util.DuplicateFormatFlagsException;

public class GlobalV extends Application {
    private double cal;
    private double carbonhydrate;
    private double protein;
    private double fat;
    @Override
    public void onCreate() {
        super.onCreate();
        setCal(CAL);

    }
    public Double getCal() {

        return cal;
    }
    public Double getCarbohydrate(){
        return carbonhydrate;
    }
    public Double getProtein(){
        return protein;
    }
    public Double getFat(){
        return fat;
    };
    public void setCal(Double cal) {
        this.cal = cal;
    }
    public void setCarbonhydrate(Double carbonhydrate) {
        this.carbonhydrate = carbonhydrate;
    }
    public void setProtein(Double protein) {
        this.protein = protein;
    }
    public void setFat(Double fat) {
        this.fat = fat;
    }
    private static final Double CAL = 100.0;
//    初始值
}

