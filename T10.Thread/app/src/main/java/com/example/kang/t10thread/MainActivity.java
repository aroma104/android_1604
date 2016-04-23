package com.example.kang.t10thread;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private static final int LOG_COUNT = 1;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Log.d("Thread", "Count_check : " + msg.arg1);
            if(msg.what == LOG_COUNT){
                textView.setText("count : "+msg.arg1);
                //Log.d("Thread", "Count : " + msg.arg1);
                progressBar.setProgress(msg.arg1);
            }
        }
    };


    class MyThread extends Thread{
        public void run(){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //
        }
    };
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        textView = (TextView) findViewById(R.id.textView);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=100; i++){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Log.d("thread","count : "+i);


                    Message msg = new Message();
                    msg.what = LOG_COUNT;
                    msg.arg1 = i;


                    handler.sendMessage(msg);


                }
            }
        };
        Thread th = new Thread(r);
        th.start();


        //Thread th2 = new Thread(r);
        //th2.start();

        //MyThread th3 = new MyThread();
        //th3.start();
    }
}
