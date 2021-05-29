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

import static android.view.View.GONE;


public class Page extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);
        SharedPreferences logstat = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor logedit=logstat.edit();
        MainActivity main = new MainActivity();
        SharedPreferences firstreset = getSharedPreferences("checkFirst", MODE_PRIVATE);
        Button reset = findViewById(R.id.reset);
        Button pgBack = (Button) findViewById(R.id.pgBack);
        Button join = (Button) findViewById(R.id.join);
        Button login = (Button) findViewById(R.id.login);
        Button logout = (Button) findViewById(R.id.logout);

        if(logstat.getBoolean("Login",false)){
            logout.setVisibility(View.VISIBLE);
            login.setVisibility(GONE);
        }
        else{
            logout.setVisibility(GONE);
            login.setVisibility(View.VISIBLE);
        }
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = firstreset.edit();
                main.checkF = false;
                logedit.clear();
                logedit.commit();
                editor.clear();
                editor.commit();
                finishAffinity();
                Intent intent = new Intent(Page.this, MainActivity.class);
                startActivity(intent);
                System.exit(0);
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
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(getApplicationContext(), "로그아웃 되었습니다", Toast.LENGTH_SHORT).show();
                        logout.setVisibility(GONE);
                        login.setVisibility(View.VISIBLE);
                        logedit.putBoolean("Login",false);
                        logedit.putString("ID",null);
                        logedit.commit();
                        Intent intent = new Intent(getApplicationContext(), Page.class);
                        startActivity(intent);
                        finish();
                }
            }
        });

    }
}