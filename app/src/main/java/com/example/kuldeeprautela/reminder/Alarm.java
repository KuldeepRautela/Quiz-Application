package com.example.kuldeeprautela.reminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Kuldeep Rautela on 8/17/2019.
 */

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,intent.getStringExtra("content"),Toast.LENGTH_LONG).show();
          }
}
