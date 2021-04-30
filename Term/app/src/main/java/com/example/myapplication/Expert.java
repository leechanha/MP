package com.example.myapplication;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.myapplication.ExpertEx.ExpertEx1;
import com.example.myapplication.ExpertEx.ExpertEx2;
import com.example.myapplication.ExpertEx.ExpertEx3;
import com.example.myapplication.ExpertEx.ExpertEx4;
import com.example.myapplication.ExpertEx.ExpertEx5;
import com.example.myapplication.ExpertEx.ExpertEx6;

public class Expert extends AppCompatActivity {
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expert);

        ImageButton Eex1=(ImageButton)findViewById(R.id.Eex1);
        ImageButton Eex2=(ImageButton)findViewById(R.id.Eex2);
        ImageButton Eex3=(ImageButton)findViewById(R.id.Eex3);
        ImageButton Eex4=(ImageButton)findViewById(R.id.Eex4);
        ImageButton Eex5=(ImageButton)findViewById(R.id.Eex5);
        ImageButton Eex6=(ImageButton)findViewById(R.id.Eex6);

        Button EexeBack = (Button) findViewById(R.id.EexeBack);

        EexeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Eex1.setOnClickListener(new View.OnClickListener(){ //Expert버튼 새 페이지 열기 -> Expert
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ExpertEx1.class);
                startActivity(intent);
            }
        });

        Eex2.setOnClickListener(new View.OnClickListener(){ //Expert버튼 새 페이지 열기 -> Expert
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ExpertEx2.class);
                startActivity(intent);
            }
        });

        Eex3.setOnClickListener(new View.OnClickListener(){ //Expert버튼 새 페이지 열기 -> Expert
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ExpertEx3.class);
                startActivity(intent);
            }
        });

        Eex4.setOnClickListener(new View.OnClickListener(){ //Expert버튼 새 페이지 열기 -> Expert
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ExpertEx4.class);
                startActivity(intent);
            }
        });

        Eex5.setOnClickListener(new View.OnClickListener(){ //Expert버튼 새 페이지 열기 -> Expert
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ExpertEx5.class);
                startActivity(intent);
            }
        });

        Eex6.setOnClickListener(new View.OnClickListener(){ //Expert버튼 새 페이지 열기 -> Expert
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ExpertEx6.class);
                startActivity(intent);
            }
        });
    }
}