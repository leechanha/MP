package com.example.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    public SharedPreferences first;
    public Boolean checkF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first=getSharedPreferences("checkFirst",MODE_PRIVATE);
        checkF=first.getBoolean("checkFirst",false);
        if(checkF==false){
            SharedPreferences.Editor editor = first.edit();
            editor.putBoolean("checkFirst",true);
            editor.commit();

            Intent intent = new Intent(MainActivity.this, Survey.class);
            startActivity(intent);
        }

        ImageButton exer=(ImageButton)findViewById(R.id.main1);
        ImageButton sche=(ImageButton)findViewById(R.id.main2);
        ImageButton page=(ImageButton)findViewById(R.id.main3);
        ImageButton set=(ImageButton)findViewById(R.id.main4);
        exer.setOnClickListener(new View.OnClickListener(){ //main1버튼 새 페이지 열기 -> Exercise
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Exercise.class);
                startActivity(intent);
            }
        });
        sche.setOnClickListener(new View.OnClickListener(){ //main2버튼 새 페이지 열기 -> My Schedule
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Schedule.class);
                startActivity(intent);
            }
        });
        page.setOnClickListener(new View.OnClickListener(){ //main3버튼 새 페이지 열기 -> My Page
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Page.class);
                startActivity(intent);
            }
        });
        set.setOnClickListener(new View.OnClickListener(){ //main4버튼 새 페이지 열기 -> App Setting
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Setting.class);
                startActivity(intent);
            }
        });
    }

}


