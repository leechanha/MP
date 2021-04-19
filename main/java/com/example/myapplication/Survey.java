package com.example.myapplication;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Survey extends AppCompatActivity {


    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);
        SharedPreferences servey=getSharedPreferences("servey",MODE_PRIVATE);
        SharedPreferences.Editor editor=servey.edit();

        RadioGroup pushup;
        RadioButton push1;
        RadioButton push2;
        RadioButton push3;
        RadioButton push4;
        RadioGroup situp;
        RadioButton sit1;
        RadioButton sit2;
        RadioButton sit3;
        RadioButton sit4;
        RadioGroup sex;
        RadioButton sex1;
        RadioButton sex2;
        Spinner edit_age;
        Spinner edit_purpose;
        Button submit;

        pushup=findViewById(R.id.pushup);
        push1=findViewById(R.id.push1);
        push2=findViewById(R.id.push2);
        push3=findViewById(R.id.push3);
        push4=findViewById(R.id.push4);
        situp=findViewById(R.id.situp);
        sit1=findViewById(R.id.sit1);
        sit2=findViewById(R.id.sit2);
        sit3=findViewById(R.id.sit3);
        sit4=findViewById(R.id.sit4);
        sex=findViewById(R.id.sex);
        sex1=findViewById(R.id.sex1);
        sex2=findViewById(R.id.sex2);
        edit_age=findViewById(R.id.age);
        edit_purpose=findViewById(R.id.purpose);
        submit=findViewById(R.id.submit);
        String age=edit_age.getSelectedItem().toString();
        String purpose=edit_purpose.getSelectedItem().toString();
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int pushsel= pushup.getCheckedRadioButtonId();
                if(push1.getId()==pushsel){
                    editor.putString("Push-up","0-15");
                }
                if(push2.getId()==pushsel){
                    editor.putString("Push-up","16-30");
                }
                if(push3.getId()==pushsel){
                    editor.putString("Push-up","31-45");
                }
                if(push4.getId()==pushsel){
                    editor.putString("Push-up","46-");
                }
                int sitsel= situp.getCheckedRadioButtonId();
                if(sit1.getId()==sitsel){
                    editor.putString("Push-up","0-15");
                }
                if(sit2.getId()==sitsel){
                    editor.putString("Push-up","16-30");
                }
                if(sit3.getId()==sitsel){
                    editor.putString("Push-up","31-45");
                }
                if(sit4.getId()==sitsel){
                    editor.putString("Push-up","46-");
                }
                int sexsel= sex.getCheckedRadioButtonId();
                if(sex1.getId()==sitsel){
                    editor.putString("Push-up","Male");
                }
                if(sex2.getId()==sitsel){
                    editor.putString("Push-up","Female");
                }
                editor.putString("Age",age);
                editor.putString("Purpose",purpose);
                editor.commit();
                finish();
            }
        });
    }
}