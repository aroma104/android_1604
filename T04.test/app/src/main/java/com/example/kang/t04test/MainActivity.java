package com.example.kang.t04test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int myReqCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("myId", "abcd");
                startActivityForResult(intent, myReqCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == myReqCode){
            if(resultCode == RESULT_OK){
                String res = data.getStringExtra("myResult");
                Toast.makeText(this, "res : " + res, Toast.LENGTH_LONG).show();
            }
        }

    }
}
