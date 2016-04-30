package com.example.kang.t18br2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if(action.equals(Intent.ACTION_BATTERY_CHANGED)){
                int level = intent.getIntExtra("level", 0);
                Toast.makeText(context, "batt :" +level, Toast.LENGTH_LONG).show();
            }else if(action.equals(Intent.ACTION_BATTERY_LOW)){
                //배터리 없을 때,

            }else if(action.equals("abcdef")){
                //
                Toast.makeText(context, "abcdef received", Toast.LENGTH_LONG).show();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction("abcdef");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    public void onMyBtnClick(View v){
        Intent intent = new Intent("abcdef");
        sendBroadcast(intent);
    }
}
