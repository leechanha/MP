package com.example.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    public SharedPreferences first;
    public Boolean checkF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences logstat = getSharedPreferences("Login", MODE_PRIVATE);
        first=getSharedPreferences("checkFirst",MODE_PRIVATE);
        checkF=first.getBoolean("checkFirst",false);
        if(checkF==false){
            SharedPreferences.Editor editor = first.edit();
            editor.putBoolean("checkFirst",true);
            editor.commit();

            Intent intent = new Intent(MainActivity.this, Survey.class);
            startActivity(intent);
        }

        if(logstat.getBoolean("Login",false)){
            recommend();
        }
        ImageButton exer=(ImageButton)findViewById(R.id.main1);
        ImageButton sche=(ImageButton)findViewById(R.id.main2);
        ImageButton page=(ImageButton)findViewById(R.id.main3);
        ImageButton set=(ImageButton)findViewById(R.id.main4);
        exer.setOnClickListener(new View.OnClickListener(){ //main1버튼 새 페이지 열기 -> Exercise
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Exercise.class);
                startActivity(intent);
            }
        });
        sche.setOnClickListener(new View.OnClickListener(){ //main2버튼 새 페이지 열기 -> My Schedule
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Schedule.class);
                startActivity(intent);
            }
        });
        page.setOnClickListener(new View.OnClickListener(){ //main3버튼 새 페이지 열기 -> My Page
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Page.class);
                startActivity(intent);
            }
        });
        set.setOnClickListener(new View.OnClickListener(){ //main4버튼 새 페이지 열기 -> App Setting
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Setting.class);
                startActivity(intent);
            }
        });
    }
    public void recommend() {
        SharedPreferences survey = getSharedPreferences("survey", MODE_PRIVATE);
        SharedPreferences logstat = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor logedit=logstat.edit();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final float[] t = {0};
        final float[] recom = {0};
        final String[] recom_id = new String[1];

        CollectionReference productRef = db.collection("user");
        productRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                //작업이 성공적으로 마쳤을때
                if (task.isSuccessful()) {
                    //컬렉션 아래에 있는 모든 정보를 가져온다.
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        t[0]=0;
                        if (document.getId().equals(logstat.getString("ID", null))) {
                            Log.d("mytag1", "You! : "+document.getId());
                        }
                        else{
                            Log.d("mytag1", document.getId());
                        }

                        if (!document.getId().equals(logstat.getString("ID", null))) {
                            if (survey.getString("Sex", "none").equals(document.getString("sex"))) {
                                t[0] = (float) (t[0] + 0.06);
                            } else {
                                if(!survey.getString("Sex", "none").equals("none")) {
                                    t[0] = (float) (t[0] + 0.03);
                                }
                            }
                            if (survey.getString("Purpose", "none").equals(document.getString("purpose"))) {
                                t[0] = (float) (t[0] + 0.06);
                            } else {
                                if(!survey.getString("Purpose", "none").equals("none")) {
                                    t[0] = (float) (t[0] + 0.03);
                                }
                            }
                            if (survey.getString("Week", "none").equals(document.getString("week"))) {
                                t[0] = (float) (t[0] + 0.12);
                            } else {
                                if(!survey.getString("Week", "none").equals("none")) {
                                    t[0] = (float) (t[0] + 0.08);
                                    if(survey.getString("Week", "none").equals("1 day")){
                                        if(document.getString("week").equals("Over 3 days")){
                                            t[0] = (float) (t[0] - 0.04);
                                        }
                                    } else if(survey.getString("Week", "none").equals("2 days")){
                                        if(document.getString("week").equals("Rarely do")){
                                            t[0] = (float) (t[0] - 0.04);
                                        }
                                    }

                                    if(survey.getString("Week", "none").equals("Rarely do")){
                                        if(document.getString("week").equals("2 days")){
                                            t[0] = (float) (t[0] - 0.04);
                                        } else if(document.getString("week").equals("Over 3 days")){
                                            t[0] = (float) (t[0] - 0.08);
                                        }
                                    } else if(survey.getString("Week", "none").equals("Over 3 days")){
                                        if(document.getString("week").equals("1 day")){
                                            t[0] = (float) (t[0] - 0.04);
                                        } else if(document.getString("week").equals("Rarely do")){
                                            t[0] = (float) (t[0] - 0.08);
                                        }
                                    }
                                }
                            }
                            if (survey.getString("Day", "none").equals(document.getString("day"))) {
                                t[0] = (float) (t[0] + 0.12);
                            } else {
                                if(!survey.getString("Day", "none").equals("none")) {
                                    t[0] = (float) (t[0] + 0.08);
                                    if(survey.getString("Day", "none").equals("1 hour")){
                                        if(document.getString("day").equals("Over 3 hours")){
                                            t[0] = (float) (t[0] - 0.04);
                                        }
                                    } else if(survey.getString("Day", "none").equals("2 hours")){
                                        if(document.getString("day").equals("Rarely do")){
                                            t[0] = (float) (t[0] - 0.04);
                                        }
                                    }

                                    if(survey.getString("Day", "none").equals("Rarely do")){
                                        if(document.getString("day").equals("2 hours")){
                                            t[0] = (float) (t[0] - 0.04);
                                        } else if(document.getString("day").equals("Over 3 hours")){
                                            t[0] = (float) (t[0] - 0.08);
                                        }
                                    } else if(survey.getString("Day", "none").equals("Over 3 hours")){
                                        if(document.getString("day").equals("1 hour")){
                                            t[0] = (float) (t[0] - 0.04);
                                        } else if(document.getString("day").equals("Rarely do")){
                                            t[0] = (float) (t[0] - 0.08);
                                        }
                                    }
                                }
                            }
                            if (survey.getString("Push-up", "none").equals(document.getString("pushup"))) {
                                t[0] = (float) (t[0] + 0.14);
                            } else {
                                if(!survey.getString("Push-up", "none").equals("none")) {
                                    t[0] = (float) (t[0] + 0.10);
                                    if(survey.getString("Push-up", "none").equals("16-30")){
                                        if(document.getString("pushup").equals("Over 46")){
                                            t[0] = (float) (t[0] - 0.05);
                                        }
                                    } else if(survey.getString("Push-up", "none").equals("31-45")){
                                        if(document.getString("pushup").equals("Less 15")){
                                            t[0] = (float) (t[0] - 0.05);
                                        }
                                    }

                                    if(survey.getString("Push-up", "none").equals("Less 15")){
                                        if(document.getString("pushup").equals("31-45")){
                                            t[0] = (float) (t[0] - 0.05);
                                        } else if(document.getString("pushup").equals("Over 46")){
                                            t[0] = (float) (t[0] - 0.10);
                                        }
                                    } else if(survey.getString("Push-up", "none").equals("Over 46")){
                                        if(document.getString("pushup").equals("16-30")){
                                            t[0] = (float) (t[0] - 0.05);
                                        } else if(document.getString("pushup").equals("Less 15")){
                                            t[0] = (float) (t[0] - 0.10);
                                        }
                                    }
                                }
                            }
                            if (survey.getString("Plan", "none").equals(document.getString("plan"))) {
                                t[0] = (float) (t[0] + 0.20);
                            } else {
                                if(!survey.getString("Plan", "none").equals("none")) {
                                    t[0] = (float) (t[0] + 0.15);
                                    if(survey.getString("Plan", "none").equals("1 month")){
                                        if(document.getString("plan").equals("Over 3 months")){
                                            t[0] = (float) (t[0] - 0.10);
                                        }
                                    } else if(survey.getString("Plan", "none").equals("2 months")){
                                        if(document.getString("plan").equals("Never implemented a plan")){
                                            t[0] = (float) (t[0] - 0.10);
                                        }
                                    }

                                    if(survey.getString("Plan", "none").equals("Never implemented a plan")){
                                        if(document.getString("plan").equals("2 months")){
                                            t[0] = (float) (t[0] - 0.10);
                                        } else if(document.getString("plan").equals("Over 3 months")){
                                            t[0] = (float) (t[0] - 0.15);
                                        }
                                    } else if(survey.getString("Plan", "none").equals("Over 3 months")){
                                        if(document.getString("plan").equals("1 month")){
                                            t[0] = (float) (t[0] - 0.10);
                                        } else if(document.getString("plan").equals("Never implemented a plan")){
                                            t[0] = (float) (t[0] - 0.15);
                                        }
                                    }
                                }
                            }
                            if (survey.getString("Big Three", "none").equals(document.getString("exerthree"))) {
                                t[0] = (float) (t[0] + 0.30);
                            } else {
                                if(!survey.getString("Big Three", "none").equals("none")) {
                                    t[0] = (float) (t[0] + 0.20);
                                    if(survey.getString("Big Three", "none").equals("Never done it")){
                                        if(document.getString("exerthree").equals("200kg")){
                                            t[0] = (float) (t[0] - 0.10);
                                        }
                                    } else if(survey.getString("Big Three", "none").equals("200kg")){
                                        if(document.getString("exerthree").equals("Never done it")){
                                            t[0] = (float) (t[0] - 0.10);
                                        }
                                    }

                                    if(survey.getString("Big Three", "none").equals("I don't know what it is")){
                                        if(document.getString("exerthree").equals("100kg")){
                                            t[0] = (float) (t[0] - 0.10);
                                        } else if(document.getString("exerthree").equals("200kg")){
                                            t[0] = (float) (t[0] - 0.15);
                                        } else if(document.getString("exerthree").equals("Over 300kg")){
                                            t[0] = (float) (t[0] - 0.20);
                                        }
                                    } else if(survey.getString("Big Three", "none").equals("Over 300kg")){
                                        if(document.getString("exerthree").equals("100kg")){
                                            t[0] = (float) (t[0] - 0.10);
                                        } else if(document.getString("exerthree").equals("Never done it")){
                                            t[0] = (float) (t[0] - 0.15);
                                        } else if(document.getString("exerthree").equals("I don't know what it is")){
                                            t[0] = (float) (t[0] - 0.20);
                                        }
                                    }
                                }
                            }
                            Log.d("mytag1", String.valueOf(String.format("%.2f", t[0])));
                            if(t[0]>recom[0]){
                                recom[0]=t[0];
                                recom_id[0]=document.getId();
                            }
                        }

                    }
                    Log.d("mytag1", recom_id[0]);
                    Log.d("mytag1", String.valueOf(String.format("%.2f", recom[0])));

                    //그렇지 않을때
                } else {

                }
            }
        });
        logedit.putFloat("recom_score",recom[0]);
        logedit.putString("recom_id",recom_id[0]);
        logedit.commit();
    }
}


