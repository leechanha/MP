package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        Button LoginMemb = (Button) findViewById(R.id.Login);
        Button LoginBack = (Button) findViewById(R.id.LoginBack);

        LoginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LoginMemb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.Login:
                        signUp();
                        break;
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }


    private void signUp() {
        String email = ((EditText) findViewById(R.id.ID)).getText().toString();
        String password = ((EditText) findViewById(R.id.password)).getText().toString();
        SharedPreferences logstat = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor logedit=logstat.edit();

        if (email.length() > 0 && password.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                profileUpdate();
                                startToast("로그인에 성공하였습니다");
                                logedit.putBoolean("Login",true);
                                logedit.putString("ID",email);
                                logedit.commit();
                                Intent intent = new Intent(getApplicationContext(), Page.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                startToast("로그인에 실패하였습니다");
                            }
                        }
                    });

        } else {
            startToast("이메일 또는 비밀번호를 입력해 주세요");
        }
    }

    //리스너에서는 토스트 사용안돼서 함수만들어서 썼어욤
    private void startToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    private void profileUpdate() {

        SharedPreferences survey = getSharedPreferences("survey", MODE_PRIVATE);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        memberInfo memberInfo = new memberInfo(survey.getString("Sex", "none"), survey.getString("Purpose", "none"),
                survey.getString("Week", "none"), survey.getString("Day", "none"),
                survey.getString("Push-up", "none"), survey.getString("Plan", "none"), survey.getString("Big Three", "none"));
        db.collection("user").document(currentUser.getEmail()).set(memberInfo);
    }
}