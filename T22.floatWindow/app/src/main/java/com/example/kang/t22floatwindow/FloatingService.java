package com.example.kang.t22floatwindow;

/**
 * Created by Kang on 2016-04-30.
 */
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;


public class FloatingService extends Service {
    public FloatingService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    WindowManager wm;
    LinearLayout ll;
    Button btnStop;
    WindowManager.LayoutParams params;

    @Override
    public void onCreate() {
        super.onCreate();
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        ll = new LinearLayout(this);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        ll.setBackgroundColor(Color.argb(55, 255, 0,0));
        ll.setLayoutParams(llParams);



        btnStop = new Button(this);
        ViewGroup.LayoutParams btnParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        btnStop.setLayoutParams(btnParams);
        btnStop.setText("stop");
        ll.addView(btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.removeView(ll);
                stopSelf();
            }
        });


        params = new WindowManager.LayoutParams(
                400, 160,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSPARENT
        );
        params.x = 0;
        params.y = 0;
        params.gravity = Gravity.CENTER | Gravity.CENTER;


        wm.addView(ll, params);

        ll.setOnTouchListener(new View.OnTouchListener(){
            WindowManager.LayoutParams updatedParams = params;

            int x,y;
            float touchedX, touchedY;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        x = updatedParams.x;
                        y = updatedParams.y;

                        touchedX = motionEvent.getRawX();
                        touchedY = motionEvent.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        updatedParams.x = x + (int)(motionEvent.getRawX() - touchedX);      //드래그 할 때마다, 윈도우 업데이트 되어라
                        updatedParams.y = y + (int)(motionEvent.getRawY() - touchedY);
                        wm.updateViewLayout(ll, updatedParams);
                        break;
                }
                return false;
            }
        });
    }

}
