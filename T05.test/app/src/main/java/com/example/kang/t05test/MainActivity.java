package com.example.kang.t05test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] list = {"hello", "world", "oracle", "java",
                    "hello", "world", "oracle", "java",
                    "hello", "world", "oracle", "java",
                    "hello", "world", "oracle", "java"
                    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = list[position];
                //Toast.makeText(MainActivity.this, "position : " + position, Toast.LENGTH_LONG).show();        //position 값 찾기
                Toast.makeText(MainActivity.this, "position : " + str, Toast.LENGTH_LONG).show();               //str 값 찾기
            }
        });
    }
}
