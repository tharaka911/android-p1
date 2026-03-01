package com.nawwa.app1;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class X extends BroadcastReceiver {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("Broadcast", "all green getting data form receiver");
        Toast.makeText(context, "all green getting data form receiver", Toast.LENGTH_SHORT).show();

        boolean isAirplaneModeEnabled = intent.getBooleanExtra("state", false);
        if (isAirplaneModeEnabled) {
            //need to open BrodcastActivity here
            Intent i = new Intent(context, BrodcastActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }




    }
}
