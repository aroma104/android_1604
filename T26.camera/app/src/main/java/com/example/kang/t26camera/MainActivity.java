package com.example.kang.t26camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int TAKE_PHOTO = 1;

    public void onBtnClick(View v){
        String dirPath = Environment.getExternalStorageDirectory() + "/TTT";            //처음 생성 할 때, 조건 삽입(폴더가 있는지 없는지 판단)
        File dir = new File(dirPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        String path = dirPath + "/26.jpg";

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));

        startActivityForResult(intent, TAKE_PHOTO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TAKE_PHOTO){
            if(resultCode == RESULT_OK){
                String dirPath = Environment.getExternalStorageDirectory() + "/TTT";
                String path = dirPath + "/26.jpg";

                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                Bitmap bm;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 4;               //4px당 1px로 만들어라. (사이즈 줄이는 방법)

                bm = BitmapFactory.decodeFile(path, options);
                imageView.setImageBitmap(bm);

                //파일 사이즈가 너무 크면 ImageView 에 올릴 수 없다.

            }
        }
    }
}
