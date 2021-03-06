package com.example.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class Page extends AppCompatActivity {
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);

        MainActivity main=new MainActivity();
        SharedPreferences firstreset=getSharedPreferences("checkFirst",MODE_PRIVATE);
        Button reset=findViewById(R.id.reset);
        Button pgBack=(Button)findViewById(R.id.pgBack);

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor = firstreset.edit();
                main.checkF=false;
                editor.clear();
                editor.commit();
            }
        });
        pgBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}