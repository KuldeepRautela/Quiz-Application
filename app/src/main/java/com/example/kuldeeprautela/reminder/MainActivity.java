package com.example.kuldeeprautela.reminder;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.transition.Transition;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button button;
    Recycle recycle;
    ListView listView;
    ArrayList<String> arrayList,arrayList2;
    Calendar calendar;
    SQLiteDatabase sqLiteDatabase;
    int j,id=0;
    String edit="";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendar = Calendar.getInstance();
        button = (Button) findViewById(R.id.button4);
        listView = (ListView) findViewById(R.id.listView);
        sqLiteDatabase=this.openOrCreateDatabase("MyDb",MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS  Notes(data VARCHAR(40),time VARCHAR(8))");
        final Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM Notes",null);
        int i,j1;
        i=cursor.getColumnIndex("data");
        j1=cursor.getColumnIndex("time");
        arrayList = new ArrayList<>();
        while(cursor.moveToNext()){
            arrayList.add(cursor.getString(i));
        }
        recycle=new Recycle(this,R.layout.recyler,arrayList);
        listView.setAdapter(recycle);
        arrayList2 =new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("content","k");
                startActivityForResult(intent, 1);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, final View view, final int index, long l) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("What do you want to do ?").setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        j=i;
                        edit=arrayList.get(index);
                        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                        intent.putExtra("content",arrayList.get(index));
                        startActivityForResult(intent,2);
                    }
                }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            delete(index);
                            }
                        }
                );
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;
            }
        });
    }
      public void delete(int index){
          Cursor cursor1=sqLiteDatabase.rawQuery("SELECT * FROM Notes WHERE data=\'"+arrayList.get(index)+"\'",null);
          cursor1.moveToFirst();
          String time=cursor1.getString(cursor1.getColumnIndex("time"));
          sqLiteDatabase.execSQL("DELETE FROM Notes WHERE data=\'"+arrayList.get(index)+"\'");
          Cursor c= sqLiteDatabase.rawQuery("SELECT * FROM Notes",null);
          ArrayList<String> temp=new ArrayList<>();
          while (c.moveToNext()){
              temp.add(c.getString(c.getColumnIndex("data")));
          }
          arrayList.clear();
          recycle=new Recycle(MainActivity.this,R.layout.recyler,arrayList);
          listView.setAdapter(recycle);
          arrayList=temp;
          recycle=new Recycle(MainActivity.this,R.layout.recyler,arrayList);
          listView.setAdapter(recycle);
          String []s=time.split(" ");
          calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(s[0]));
          calendar.set(Calendar.MINUTE,Integer.parseInt(s[1]));
          calendar.set(Calendar.SECOND,0);
          alarm("cancle","");

      }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String s="", content;
        int hour=0 ,minute=0;
        if(resultCode!=25) {
            if(!data.getStringExtra("change").equals(" ")) {
                hour=Integer.parseInt(data.getStringExtra("hour"));
                minute=Integer.parseInt(data.getStringExtra("minute"));
                s =  hour+ " " +minute;
            }
            content = data.getStringExtra("content");
            if (requestCode == 1) {
                arrayList.add(content);
                sqLiteDatabase.execSQL("INSERT INTO Notes(data,time) VALUES(\'" + content + "\',\'" + s + "\')");
                   setAlarm(data,hour,minute);
                recycle=new Recycle(MainActivity.this,R.layout.recyler,arrayList);
                listView.setAdapter(recycle);
                alarm("set",content);
            } else {
                String con= data.getStringExtra("content");
                if(data.getStringExtra("change").equals(" ")){
                    sqLiteDatabase.execSQL("UPDATE Notes SET data=\'"+con+"\' WHERE data=\'"+edit+"\'");
                }else {
                    String s1=hour+" "+minute+" "+data.getStringExtra("am_or_pm");
                    sqLiteDatabase.execSQL("UPDATE Notes SET data=\'"+con+"\',time=\'"+s1+"\' WHERE data=\'"+edit+"\'");
                    Cursor cursor1=sqLiteDatabase.rawQuery("SELECT * FROM Notes WHERE data=\'"+edit+"\'",null);
                    cursor1.moveToFirst();
                    String s2=cursor1.getString(cursor1.getColumnIndex("time"));
                    String []time=s2.split(" ");
                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(time[0]));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(time[1]));
                    if(time[2].equals("am"))
                        calendar.set(Calendar.AM_PM,Calendar.AM);
                    else
                        calendar.set(Calendar.AM_PM,Calendar.PM);
                    alarm("edit",con);
                    time=s1.split(" ");
                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(time[0]));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(time[1]));
                    if(time[2].equals("am"))
                        calendar.set(Calendar.AM_PM,Calendar.AM);
                    else
                        calendar.set(Calendar.AM_PM,Calendar.PM);

                    alarm("set",con);
                }

                ArrayList<String> temp=new ArrayList<>();
                Cursor c= sqLiteDatabase.rawQuery("SELECT * FROM Notes",null);
                while (c.moveToNext()){
                    temp.add(c.getString(c.getColumnIndex("data")));
                }
                arrayList.clear();
                recycle=new Recycle(MainActivity.this,R.layout.recyler,arrayList);
                listView.setAdapter(recycle);
                arrayList=temp;
                recycle=new Recycle(MainActivity.this,R.layout.recyler,arrayList);
                listView.setAdapter(recycle);

            }
        }
    }
    public void setAlarm(Intent data,int hour,int minute){
        if(data.getStringExtra("am_or_pm").equals("am"))
            calendar.set(Calendar.AM_PM,Calendar.AM);
        else
            calendar.set(Calendar.AM_PM,Calendar.PM);

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
    }
    public void alarm(String s,String content){
        Intent intent=new Intent(MainActivity.this,Alarm.class);
        intent.putExtra("content",content);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,id,intent,0);
        AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        id++;
        if(s.equals("set"))
        alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
        else{
            alarmManager.cancel(pendingIntent);
        }
    }


}
