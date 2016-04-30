package com.example.kang.t11asyctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    class MyTask extends AsyncTask<Integer, Float, String>{

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            textView.setText("count : " + values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);

        }

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
                publishProgress((float)i);
            }
            return "dpne";
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.kang.t11AsyncTask.R.layout.activity_main);
        textView = (TextView)findViewById(com.example.kang.t11AsyncTask.R.id.textView);
        MyTask task = new MyTask();
        task.execute(100,200,300);
    }
}
