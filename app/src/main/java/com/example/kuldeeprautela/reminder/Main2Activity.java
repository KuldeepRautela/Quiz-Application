package com.example.kuldeeprautela.reminder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

          String s,s2=" ";
    Intent intent;
           int j=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("data","it worked");
        if(keyCode==KeyEvent.KEYCODE_BACK){
        intent=new Intent(Main2Activity.this,MainActivity.class);
        setResult(25);

            finish();

        }
        return super.onKeyDown(keyCode, event);
    }
        EditText editText;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button) findViewById(R.id.button);
        final Calendar calendar=Calendar.getInstance();
        final Context context=this;
        final int hour,minute;
      editText=(EditText) findViewById(R.id.editText);
         intent=getIntent();
         if(intent.getStringExtra("content").length()>1){
             editText.setText(intent.getStringExtra("content"));
             j+=2;
         }

        hour=calendar.get(Calendar.HOUR);
        minute=calendar.get(Calendar.MINUTE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog=new TimePickerDialog(Main2Activity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String s="";
                        Calendar calendar1=Calendar.getInstance();
                        calendar1.set(Calendar.HOUR_OF_DAY,i);
                        calendar1.set(Calendar.MINUTE,i1);
                        if(calendar1.get(Calendar.AM_PM)==Calendar.AM)
                            s="am";
                        else
                            s="pm";
                        intent.putExtra("am_or_pm",s);
                        intent.putExtra("hour",i+"");
                        intent.putExtra("minute",i1+"");
                         s2=i+" "+i1;
                        j+=1;
                           }
                },hour,minute,android.text.format.DateFormat.is24HourFormat(Main2Activity.this));
                timePickerDialog.show();
        }
    });
}
      public void f1(View view){
           if(j!=0){
               intent.putExtra("change",s2);
          intent.putExtra("content",editText.getText().toString());
         if(j==1)
          setResult(1,intent);
         else
             setResult(2,intent);
          finish();}else {
               Toast.makeText(this,"Choose a time that's important",Toast.LENGTH_LONG).show();
           }
      }
 }
