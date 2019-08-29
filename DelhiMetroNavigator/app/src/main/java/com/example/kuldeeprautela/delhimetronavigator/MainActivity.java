package com.example.kuldeeprautela.delhimetronavigator;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
 ConstraintLayout constraintLayout;
 RecyclerView recyclerView;
 AutoCompleteTextView autoCompleteTextView1,autoCompleteTextView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout =(ConstraintLayout) findViewById(R.id.constraintLayout);
        autoCompleteTextView1=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView2=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,Metro.allStations);
        autoCompleteTextView1.setAdapter(arrayAdapter);
        autoCompleteTextView2.setAdapter(arrayAdapter);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);

    }
    public void f1(View view){
       constraintLayout.animate().translationY(-100f).setDuration(1000);
       String s1="",s2="";
       s1=autoCompleteTextView1.getText().toString();
       s2=autoCompleteTextView2.getText().toString();
       if(s1!="" && s2!=""){
           Metro metro=new Metro();
           RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,metro.metro(s1,s2));
           recyclerView.setLayoutManager(new LinearLayoutManager(this));
           recyclerView.setAdapter(recyclerAdapter);

       }

    }
}
