package com.example.kang.p01listview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MyActivity extends AppCompatActivity {

    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Intent intent = getIntent();
        String fileName = intent.getStringExtra("fileName");

        final String path = Environment.getExternalStorageDirectory() + "/Music/" + fileName;

        Button btnPlay = (Button)findViewById(R.id.btnPlay);
        Button btnStop = (Button)findViewById(R.id.btnStop);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = new MediaPlayer();
                try{
                    mp.setDataSource(path);
                    mp.prepare();
                }catch (IOException e){
                    e.printStackTrace();
                }
                mp.start();
            }

        });

        btnStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mp!=null){
                    mp.stop();
                    mp.release();
                    mp = null;
                }
            }
        });

    }
}

