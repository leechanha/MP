package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class JoinMembership extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "SignUP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_membership);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        Button joinMemb = (Button) findViewById(R.id.joinMemb);
        Button joinBack = (Button) findViewById(R.id.joinBack);

        joinBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        joinMemb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.joinMemb:
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
        String checkPassword = ((EditText) findViewById(R.id.checkPassword)).getText().toString();

        if (email.length() > 0 && password.length() > 0 && checkPassword.length() > 0) {
            if (password.equals(checkPassword)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    startToast("회원가입에 성공하였습니다");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(getApplicationContext(), Page.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    if (task.getException() != null) {
                                        startToast(task.getException().toString());
                                    }
                                }
                            }
                        });
            } else {
                startToast("비밀번호가 일치하지 않습니다");
            }
        }
        else{
            startToast("이메일 또는 비밀번호를 입력해 주세요");
        }
    }

    //리스너에서는 토스트 사용안돼서 함수만들어서 썼어욤
    private void startToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}