package com.example.kuldeeprautela.quizapp;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    TextView score,ques,correct_ans;
    RadioButton r1,r2,r3,r4;
    int i=0,tscore=0;
    String tag="15";
   List<Quetions> questions;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Entertainment:tag="15";
                                     getQues();
                                     break;

            case R.id.Science:tag="18";
                getQues();
                break;
            case R.id.History:tag="23";
                getQues();
                break;
            case R.id.Geography:tag="22";
                getQues();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout=(ConstraintLayout) findViewById(R.id.constraint);
        score=(TextView) findViewById(R.id.textView);
        ques=(TextView) findViewById(R.id.textView2);
        correct_ans=(TextView) findViewById(R.id.textView4);
        r1=(RadioButton) findViewById(R.id.radioButton3);
        r2=(RadioButton) findViewById(R.id.radioButton4);
        r3=(RadioButton) findViewById(R.id.radioButton5);
        r4=(RadioButton) findViewById(R.id.radio6);
        constraintLayout.setBackgroundColor(Color.CYAN);
        getQues();
    }
    public void getQues(){
        Retrofit retrofit =new Retrofit.Builder().baseUrl("https://opentdb.com/").addConverterFactory(GsonConverterFactory.create()).build();
        final Question question=retrofit.create(Question.class);
        question.getQuestion("30",tag,"easy","multiple").enqueue(new Callback<Quetions>() {
            @Override
            public void onResponse(Call<Quetions> call, Response<Quetions> response) {
      questions= response.body().getQuetions();
                set();
            }

            @Override
            public void onFailure(Call<Quetions> call, Throwable t) {
Log.d("error",t.getLocalizedMessage());
            }
        });
    }
    public void set(){
        String que=questions.get(i).getQuestion();
        String que2="";
        for(int j=0;j<que.length();j++){
            if(que.charAt(j)=='&'){
                int j1=j;
                while (que.charAt(j1)!=';'){
                    j1++;
                    Log.d("it","was here");
                }
                j=j1;
                continue;
            }else
                que2+=que.charAt(j);
        }

   ques.setText(que2);
        int no= new Random().nextInt((4-1)+ 1)+1;
        switch (no){
            case 1:r1.setText(questions.get(i).getCorrect_ans());
                   r2.setText(questions.get(i).getWrong_ans()[0]);
                   r3.setText(questions.get(i).getWrong_ans()[1]);
                   r4.setText(questions.get(i).getWrong_ans()[2]);
                   break;

            case 2:r2.setText(questions.get(i).getCorrect_ans());
                r3.setText(questions.get(i).getWrong_ans()[0]);
                r1.setText(questions.get(i).getWrong_ans()[1]);
                r4.setText(questions.get(i).getWrong_ans()[2]);
                break;
            case 3:r3.setText(questions.get(i).getCorrect_ans());
                r2.setText(questions.get(i).getWrong_ans()[0]);
                r1.setText(questions.get(i).getWrong_ans()[1]);
                r4.setText(questions.get(i).getWrong_ans()[2]);
                break;
            case 4:r4.setText(questions.get(i).getCorrect_ans());
                r4.setText(questions.get(i).getWrong_ans()[0]);
                r3.setText(questions.get(i).getWrong_ans()[1]);
                r2.setText(questions.get(i).getWrong_ans()[2]);
                break;
        }
    }
    public void f1(View view){
       final RadioButton button=(RadioButton) view;
        if(button.getText().toString().equals(questions.get(i).getCorrect_ans()))
        {
            Toast.makeText(this,"Right Ans",Toast.LENGTH_SHORT).show();
            tscore++;
            score.setText("Score : "+tscore+"/30");
        }else
            Toast.makeText(this,"Wrong Ans",Toast.LENGTH_SHORT).show();
        correct_ans.setText("Correct Ans : "+questions.get(i).getCorrect_ans());
        i++;
        new CountDownTimer(3000,1000){
            @Override
            public void onFinish() {
                button.setChecked(false);
                correct_ans.setText("");
                set();
            }

            @Override
            public void onTick(long l) {

            }
        }.start();
    }
}
