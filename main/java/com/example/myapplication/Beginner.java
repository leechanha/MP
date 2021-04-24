package com.example.myapplication;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.myapplication.BeginnerEx.BeginnerEx1;
import com.example.myapplication.BeginnerEx.BeginnerEx2;
import com.example.myapplication.BeginnerEx.BeginnerEx3;
import com.example.myapplication.BeginnerEx.BeginnerEx4;
import com.example.myapplication.BeginnerEx.BeginnerEx5;
import com.example.myapplication.BeginnerEx.BeginnerEx6;


public class Beginner extends AppCompatActivity {
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beginner);

        ImageButton Bex1=(ImageButton)findViewById(R.id.Bex1);
        ImageButton Bex2=(ImageButton)findViewById(R.id.Bex2);
        ImageButton Bex3=(ImageButton)findViewById(R.id.Bex3);
        ImageButton Bex4=(ImageButton)findViewById(R.id.Bex4);
        ImageButton Bex5=(ImageButton)findViewById(R.id.Bex5);
        ImageButton Bex6=(ImageButton)findViewById(R.id.Bex6);

        Button BexeBack = (Button) findViewById(R.id.BexeBack);

        BexeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bex1.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), BeginnerEx1.class);
                startActivity(intent);
            }
        });

        Bex2.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), BeginnerEx2.class);
                startActivity(intent);
            }
        });

        Bex3.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), BeginnerEx3.class);
                startActivity(intent);
            }
        });

        Bex4.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), BeginnerEx4.class);
                startActivity(intent);
            }
        });

        Bex5.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), BeginnerEx5.class);
                startActivity(intent);
            }
        });

        Bex6.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), BeginnerEx6.class);
                startActivity(intent);
            }
        });

    }
}