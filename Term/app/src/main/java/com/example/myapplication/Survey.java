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
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Survey extends AppCompatActivity {

    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);
        SharedPreferences survey=getSharedPreferences("survey",MODE_PRIVATE);
        SharedPreferences.Editor editor=survey.edit();

        RadioGroup sex;
        RadioButton sex1;
        RadioButton sex2;
        RadioGroup purpose;
        RadioButton purpose1;
        RadioButton purpose2;
        RadioButton purpose3;
        RadioGroup week;
        RadioButton weekno;
        RadioButton week1;
        RadioButton week2;
        RadioButton week3;
        RadioGroup day;
        RadioButton dayno;
        RadioButton day1;
        RadioButton day2;
        RadioButton day3;
        RadioGroup pushup;
        RadioButton push1;
        RadioButton push2;
        RadioButton push3;
        RadioButton push4;
        RadioGroup plan;
        RadioButton planno;
        RadioButton plan1;
        RadioButton plan2;
        RadioButton plan3;
        RadioGroup exerthree;
        RadioButton exerthreeno1;
        RadioButton exerthreeno2;
        RadioButton exerthree1;
        RadioButton exerthree2;
        RadioButton exerthree3;
        Button submit;

        sex=(RadioGroup)findViewById(R.id.sex);
        sex1=(RadioButton)findViewById(R.id.sex1);
        sex2=(RadioButton)findViewById(R.id.sex2);
        purpose=(RadioGroup)findViewById(R.id.purpose);
        purpose1=(RadioButton)findViewById(R.id.purpose1);
        purpose2=(RadioButton)findViewById(R.id.purpose2);
        purpose3=(RadioButton)findViewById(R.id.purpose3);
        submit=(Button)findViewById(R.id.submit);
        week=(RadioGroup)findViewById(R.id.week);
        weekno=(RadioButton)findViewById(R.id.weekno);
        week1=(RadioButton)findViewById(R.id.week1);
        week2=(RadioButton)findViewById(R.id.week2);
        week3=(RadioButton)findViewById(R.id.week3);
        day=(RadioGroup)findViewById(R.id.day);
        dayno=(RadioButton)findViewById(R.id.dayno);
        day1=(RadioButton)findViewById(R.id.day1);
        day2=(RadioButton)findViewById(R.id.day2);
        day3=(RadioButton)findViewById(R.id.day3);
        pushup=(RadioGroup)findViewById(R.id.pushup);
        push1=(RadioButton)findViewById(R.id.push1);
        push2=(RadioButton)findViewById(R.id.push2);
        push3=(RadioButton)findViewById(R.id.push3);
        push4=(RadioButton)findViewById(R.id.push4);
        plan=(RadioGroup)findViewById(R.id.plan);
        planno=(RadioButton)findViewById(R.id.planno);
        plan1=(RadioButton)findViewById(R.id.plan1);
        plan2=(RadioButton)findViewById(R.id.plan2);
        plan3=(RadioButton)findViewById(R.id.plan3);
        exerthree=(RadioGroup)findViewById(R.id.exerthree);
        exerthreeno1=(RadioButton)findViewById(R.id.exerthreeno1);
        exerthreeno2=(RadioButton)findViewById(R.id.exerthreeno2);
        exerthree1=(RadioButton)findViewById(R.id.exerthree1);
        exerthree2=(RadioButton)findViewById(R.id.exerthree2);
        exerthree3=(RadioButton)findViewById(R.id.exerthree3);

        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                int sexsel= sex.getCheckedRadioButtonId();
                if(sex1.isChecked()){
                    editor.putString("Sex","Male");
                }
                if(sex2.isChecked()){
                    editor.putString("Sex","Female");
                }

                int pursel= purpose.getCheckedRadioButtonId();
                if(purpose1.isChecked()){
                    editor.putString("Purpose","Diet");
                }
                if(purpose2.isChecked()){
                    editor.putString("Purpose","Bulk Up");
                }
                if(purpose3.isChecked()) {
                    editor.putString("Purpose", "Health");
                }

                int weeksel= week.getCheckedRadioButtonId();
                if(weekno.isChecked()){
                    editor.putString("Week","Rarely do");
                }
                if(week1.isChecked()){
                    editor.putString("Week","1 day");
                }
                if(week2.isChecked()){
                    editor.putString("Week","2 days");
                }
                if(week3.isChecked()){
                    editor.putString("Week","Over 3 days");
                }

                int daysel= day.getCheckedRadioButtonId();
                if(dayno.isChecked()){
                    editor.putString("Day","Rarely do");
                }
                if(day1.isChecked()){
                    editor.putString("Day","1 hour");
                }
                if(day2.isChecked()){
                    editor.putString("Day","2 hours");
                }
                if(day3.isChecked()){
                    editor.putString("Day","Over 3 hours");
                }

                int pushsel= pushup.getCheckedRadioButtonId();
                if(push1.isChecked()){
                    editor.putString("Push-up","Less 15");
                }
                if(push2.isChecked()){
                    editor.putString("Push-up","16-30");
                }
                if(push3.isChecked()){
                    editor.putString("Push-up","31-45");
                }
                if(push4.isChecked()){
                    editor.putString("Push-up","Over 46");
                }

                int plansel= plan.getCheckedRadioButtonId();
                if(planno.isChecked()){
                    editor.putString("Plan","Never implemented a plan");
                }
                if(plan1.isChecked()){
                    editor.putString("Plan","1 month");
                }
                if(plan2.isChecked()){
                    editor.putString("Plan","2 months");
                }
                if(plan3.isChecked()){
                    editor.putString("Plan","Over 3 months");
                }

                int exerthreesel= exerthree.getCheckedRadioButtonId();
                if(exerthreeno1.isChecked()){
                    editor.putString("Big Three","I don't know what it is");
                }
                if(exerthreeno2.isChecked()){
                    editor.putString("Big Three","Never done it");
                }
                if(exerthree1.isChecked()){
                    editor.putString("Big Three","100kg");
                }
                if(exerthree2.isChecked()){
                    editor.putString("Big Three","200kg");
                }
                if(exerthree3.isChecked()){
                    editor.putString("Big Three","Over 300kg");
                }

                editor.commit();
                finish();
            }
        });
    }
}
