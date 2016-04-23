package com.example.kang.t03test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //체크박스 클릭 시 기능
        CheckBox myCheck =(CheckBox)findViewById(R.id.checkbox);
        myCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                Toast.makeText(MainActivity.this, "CheckBox change :" + isChecked, Toast.LENGTH_LONG).show();
            }
        });
        //라디오버튼 클릭 시 기능
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.radio1:
                        Toast.makeText(MainActivity.this, "radio1 selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio2:
                        Toast.makeText(MainActivity.this, "radio2 selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio3:
                        Toast.makeText(MainActivity.this, "radio3 selected", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //텍스트 기입 후, 버튼 클릭 기능
        final EditText editText = (EditText)findViewById(R.id.editText);
        Button btnOK = (Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String str = editText.getText().toString();
                Toast.makeText(MainActivity.this, "text : " + str, Toast.LENGTH_LONG).show();
                editText.setText("");
            }
        });


    }
}
