package com.example.kang.t25notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(this, NotiActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.test);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("TITLE");
        builder.setContentText("TEXT");
        builder.setSubText("SUB TEXT");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(bm);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);            //버튼 클릭하면 바로 사라짐
        Notification noti = builder.build();


        manager.notify(1234, noti);

    }

}
