package com.example.kang.t11asyctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    class MyTask extends AsyncTask<Integer, Float, String>{

        @Override
        protected String doInBackground(Integer... params) {
            int max = params[0];
            int a = params[1];
            int b = params[2];

            for(int i=0; i<max; i++){
                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Log.d("async", "count : " + i);
            }
            return null;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyTask task = new MyTask();
        task.execute(100);
    }
}
