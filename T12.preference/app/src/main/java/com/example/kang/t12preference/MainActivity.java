package com.example.kang.t12preference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("mySettings", MODE_PRIVATE);
        String name = pref.getString("name", "default");

        Toast.makeText(this, name, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences pref = getSharedPreferences("mySettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        EditText editText = (EditText)findViewById(R.id.editText);
        String value = editText.getText().toString();

        editor.putString("name", value);
        editor.commit();

    }

}
