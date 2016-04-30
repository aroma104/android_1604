package com.example.kang.t21style;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView selectedText, workingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedText = (TextView)findViewById(R.id.selectedTextView);
        workingTextView = (TextView)findViewById(R.id.workingTextView);

        View.OnClickListener numberListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String value = btn.getText().toString();
                String working = workingTextView.getText().toString();
                if(working.equals("0")){
                    workingTextView.setText(value);
                }else {
                    workingTextView.setText(working+value);
                }
            }
        };

        int number = 1;

        TableLayout tableLayout = (TableLayout)findViewById(R.id.tableLayout);
        for(int i=2; i<tableLayout.getChildCount(); i++){
            TableRow row = (TableRow)tableLayout.getChildAt(i);
            for(int k=0; k<row.getChildCount(); k++){
                Button btn = (Button) row.getChildAt(k);
                btn.setText(""+number);
                btn.setOnClickListener(numberListener);
                number++;
            }
        }

        TableRow bottomRow = (TableRow)tableLayout.getChildAt(tableLayout.getChildCount()-1);
        Button deleteBtn = (Button)bottomRow.getChildAt(0);
        deleteBtn.setText("delete");
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                workingTextView.setText("0");
            }
        });

        Button zeroBtn = (Button)bottomRow.getChildAt(1);
        zeroBtn.setText("0");
        zeroBtn.setOnClickListener(numberListener);

        Button enterBtn = (Button)bottomRow.getChildAt(2);
        enterBtn.setText("enter");
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String working = workingTextView.getText().toString();
                if(working.length()>0)
                    selectedText.setText(working);
                workingTextView.setText("0");
            }
        });
    }
}
