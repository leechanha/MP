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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class Page extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);

        MainActivity main = new MainActivity();
        SharedPreferences firstreset = getSharedPreferences("checkFirst", MODE_PRIVATE);
        Button reset = findViewById(R.id.reset);
        Button pgBack = (Button) findViewById(R.id.pgBack);
        Button join = (Button) findViewById(R.id.join);
        Button login = (Button) findViewById(R.id.login);
        Button logout = (Button) findViewById(R.id.logout);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = firstreset.edit();
                main.checkF = false;
                editor.clear();
                editor.commit();
            }
        });

        pgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        join.setOnClickListener(new View.OnClickListener() { //beginner버튼 새 페이지 열기 -> Beginner
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JoinMembership.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(getApplicationContext(), "로그아웃 되었습니다", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }
}