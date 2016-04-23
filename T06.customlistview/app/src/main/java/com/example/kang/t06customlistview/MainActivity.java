package com.example.kang.t06customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    class MyData {
        String title;
        String desc;
        int imgIcon;

        public MyData(String title, String desc, int imgIcon) {
            this.title = title;
            this.desc = desc;
            this.imgIcon = imgIcon;
        }
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {                         //getCount는 Adapter가 관리하는 Count 개수
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {             //가장 중요한 부분, 직접 구현이 필요함
            if(convertView == null){
                LayoutInflater inf = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);  //null 값으로 넘어오기 떄문에 직접 만들어줘야함
                convertView = inf.inflate(R.layout.item_view, null);
            }

            //다른 소스는 다 똑같고 아래 부분만 수정하면 리스트뷰는 동일하다

            TextView textViewTitle = (TextView)convertView.findViewById(R.id.textViewTitle);
            TextView textViewDesc = (TextView)convertView.findViewById(R.id.textViewDesc);
            ImageView item_icon = (ImageView)convertView.findViewById(R.id.item_icon);

            MyData data = list.get(position);
            textViewTitle.setText(data.title);
            textViewDesc.setText(data.desc);
            item_icon.setImageResource(data.imgIcon);

            return convertView;

        }
    }

    ArrayList<MyData> list = new ArrayList<MyData>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int icon = 0;
        for(int i=0; i<30; i++){
            switch (i%4){
                case 0:
                    icon = android.R.drawable.ic_btn_speak_now;
                    break;
                case 1:
                    icon = android.R.drawable.ic_delete;
                    break;
                case 2:
                    icon = android.R.drawable.ic_media_next;
                    break;
                case 3:
                    icon = android.R.drawable.ic_media_ff;
                    break;
            }

             MyData data = new MyData("data" + i, "desc" + i, icon);
             list.add(data);
        }
        ListView listView = (ListView)findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }
}
