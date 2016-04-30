package com.example.kang.t24fragment2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        FragmentManager fm = getSupportFragmentManager();
        //getFragmentManager();
        Fragment fr = fm.findFragmentById(R.id.frame);      //어디에 추가 되었는지 선언

        switch (v.getId()){
            case R.id.btnAdd:
                if(fr == null){
                    fr = new BlankFragment();
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.add(R.id.frame, fr, "counter");
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
            case R.id.btnRemove:
                if(fr != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.remove(fr);
                    tr.commit();
                    fm.popBackStack();
                }
                break;
            case R.id.btnReplace:
                if(fr != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fr.getTag().equals("counter")){
                        BlankFragment2 fr2 = new BlankFragment2();
                        tr.replace(R.id.frame, fr2, "text");
                    }else {
                        BlankFragment fr1 =  new BlankFragment();
                        tr.replace(R.id.frame, fr1, "counter");
                    }
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
            case R.id.btnHide:
                if(fr != null){
                    FragmentTransaction tr = fm.beginTransaction();
                    if(fr.isHidden()) {
                        tr.show(fr);
                    }else {
                        tr.hide(fr);
                    }
                    tr.addToBackStack(null);
                    tr.commit();
                }
                break;
        }
    }
}
