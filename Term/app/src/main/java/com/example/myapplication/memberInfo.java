package com.example.myapplication;

import android.widget.RadioButton;
import android.widget.RadioGroup;

public class memberInfo {

    private String sex;
    private String purpose;
    private String week;
    private String day;
    private String pushup;
    private String plan;
    private String exerthree;

    public memberInfo(String sex, String purpose, String week, String day, String pushup, String paln, String exerthree){
        this.sex=sex;
        this.purpose=purpose;
        this.week=week;
        this.day=day;
        this.pushup=pushup;
        this.plan=paln;
        this.exerthree=exerthree;
    }

    public String getSex(){
        return this.sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }

    public String getPurpose(){
        return this.purpose;
    }
    public void setPurpose(String purpose){
        this.purpose=purpose;
    }

    public String getWeek(){
        return this.week;
    }
    public void setWeek(String week){
        this.week=week;
    }

    public String getDay(){
        return this.day;
    }
    public void setDay(String day){
        this.day=day;
    }

    public String getPushup(){
        return this.pushup;
    }
    public void setPushup(String pushup){
        this.pushup=pushup;
    }

    public String getPlan(){
        return this.plan;
    }
    public void setPlan(String plan){
        this.plan=plan;
    }

    public String getExerthree(){
        return this.exerthree;
    }
    public void setExerthree(String exerthree){
        this.plan=exerthree;
    }

}
