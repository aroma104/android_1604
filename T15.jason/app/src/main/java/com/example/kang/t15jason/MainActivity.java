package com.example.kang.t15jason;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //jason object 3개 생성
    String str = "[{'name' : 'kim', 'tel' : '010-8888-8888', 'age' : 20}," +
                "{'name' : 'park', 'tel' : '010-7777-7777', 'age' : 30}," +
                "{'name' : 'lee', 'tel' : '010-6666-666-', 'age' : 40}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONArray array = new JSONArray(str);
            for(int i=0; i<array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
                String name = obj.getString("name");
                String tel = obj.getString("tel");
                int age = obj.getInt("age");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
