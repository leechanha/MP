package com.example.myapplication;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class Exercise extends AppCompatActivity {
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);

        ImageButton b=(ImageButton)findViewById(R.id.beginner);
        ImageButton i=(ImageButton)findViewById(R.id.intermediate);
        ImageButton e=(ImageButton)findViewById(R.id.expert);

        Button exeBack=(Button)findViewById(R.id.exeBack);

        b.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Beginner.class);
                startActivity(intent);
            }
        });
        i.setOnClickListener(new View.OnClickListener(){ //intermediate버튼 새 페이지 열기 -> Intermediate
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Intermediate.class);
                startActivity(intent);
            }
        });
        e.setOnClickListener(new View.OnClickListener(){ //expert버튼 새 페이지 열기 -> Expert
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Expert.class);
                startActivity(intent);
            }
        });

        exeBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}