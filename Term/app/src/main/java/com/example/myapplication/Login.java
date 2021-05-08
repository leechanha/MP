package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
/*        String sex = ((RadioButton) findViewById(((RadioGroup) findViewById(R.id.sex)).getCheckedRadioButtonId())).getText().toString();
        String purpose = ((RadioButton) findViewById(((RadioGroup) findViewById(R.id.purpose)).getCheckedRadioButtonId())).getText().toString();
        String week = ((RadioButton) findViewById(((RadioGroup) findViewById(R.id.week)).getCheckedRadioButtonId())).getText().toString();
        String day = ((RadioButton) findViewById(((RadioGroup) findViewById(R.id.day)).getCheckedRadioButtonId())).getText().toString();
        String pushup = ((RadioButton) findViewById(((RadioGroup) findViewById(R.id.pushup)).getCheckedRadioButtonId())).getText().toString();
        String plan = ((RadioButton) findViewById(((RadioGroup) findViewById(R.id.plan)).getCheckedRadioButtonId())).getText().toString();
        String exerthree = ((RadioButton) findViewById(((RadioGroup) findViewById(R.id.exerthree)).getCheckedRadioButtonId())).getText().toString();
        이걸로하면 될줄알았는데 안돼요ㅠ*/

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        memberInfo memberInfo = new memberInfo("a", "b", "c", "d","e","f", "g");
        db.collection("user").document(currentUser.getEmail()).set(memberInfo);
    }
}