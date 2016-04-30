package com.example.kang.t20service2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyService myService;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder binder = (MyService.MyBinder) service;
            myService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

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
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, connection , BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();

        unbindService(connection);
    }

    public void  onBtnClick(View v){
        int num = myService.getRandomNumber();
        Toast.makeText(MainActivity.this, "num : " + num, Toast.LENGTH_SHORT).show();
    }

}
