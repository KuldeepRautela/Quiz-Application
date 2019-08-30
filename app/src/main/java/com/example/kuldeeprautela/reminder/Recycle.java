package com.example.kuldeeprautela.reminder;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kuldeep Rautela on 8/28/2019.
 */

public class Recycle extends ArrayAdapter<String> {
    Context context;
    List<String> list;
    int resource;
    public Recycle(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.list=objects;
        this.resource=resource;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.recyler,null,true);
        TextView textView= view.findViewById(R.id.textView);
        textView.setText(list.get(position));
        return view;
    }
}
