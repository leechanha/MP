package com.example.myapplication;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.myapplication.IntermediateEx.IntermediateEx1;
import com.example.myapplication.IntermediateEx.IntermediateEx2;
import com.example.myapplication.IntermediateEx.IntermediateEx3;
import com.example.myapplication.IntermediateEx.IntermediateEx4;
import com.example.myapplication.IntermediateEx.IntermediateEx5;
import com.example.myapplication.IntermediateEx.IntermediateEx6;


public class Intermediate extends AppCompatActivity {
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intermediate);

        ImageButton Iex1=(ImageButton)findViewById(R.id.Iex1);
        ImageButton Iex2=(ImageButton)findViewById(R.id.Iex2);
        ImageButton Iex3=(ImageButton)findViewById(R.id.Iex3);
        ImageButton Iex4=(ImageButton)findViewById(R.id.Iex4);
        ImageButton Iex5=(ImageButton)findViewById(R.id.Iex5);
        ImageButton Iex6=(ImageButton)findViewById(R.id.Iex6);

        Button IexeBack = (Button) findViewById(R.id.IexeBack);

        IexeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Iex1.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), IntermediateEx1.class);
                startActivity(intent);
            }
        });

        Iex2.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), IntermediateEx2.class);
                startActivity(intent);
            }
        });

        Iex3.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), IntermediateEx3.class);
                startActivity(intent);
            }
        });

        Iex4.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), IntermediateEx4.class);
                startActivity(intent);
            }
        });

        Iex5.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), IntermediateEx5.class);
                startActivity(intent);
            }
        });

        Iex6.setOnClickListener(new View.OnClickListener(){ //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), IntermediateEx6.class);
                startActivity(intent);
            }
        });
    }
}