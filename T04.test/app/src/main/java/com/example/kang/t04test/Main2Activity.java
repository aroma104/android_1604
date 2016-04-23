package com.example.kang.t04test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String str = intent.getStringExtra("myId");
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();

        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Intent myIntent = new Intent();
                //myIntent.putExtra("myResult", "Main2 Result");
                //setResult(RESULT_OK, myIntent);
                //finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent();
        myIntent.putExtra("myResult", "Main2 Result");
        setResult(RESULT_OK, myIntent);

        super.onBackPressed();
    }

}
