package com.example.kang.t07media;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay = (Button)findViewById(R.id.btnPlay);
        Button btnStop = (Button)findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mp == null){                             //재생중이 아닐 경우, 재생
                    String path= Environment.getExternalStorageDirectory()+"/Download/test.mp3";       //음악이 들어 있는 경로 기입
                    mp = new MediaPlayer();
                    try {
                        mp.setDataSource(path);
                        mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mp.start();
                } else{                                     //재생중일 경우, 재생중입니다. 메세지 발생
                    Toast.makeText(MainActivity.this, "재생중입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mp != null){
                    mp.stop();
                    mp.release();
                    mp = null;
                }
            }
        });

    }
}
