package com.example.kang.t14xml;

import android.os.AsyncTask;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

/**
 * Created by Kang on 2016-04-23.
 * Pull Parser 는 라인 단위로 읽기 때문에 Dom Parser 보다 빠르다.
 */
public class MyPullParser extends AsyncTask<String, Void, String> {
    TextView textView;

    public MyPullParser(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
    }

    @Override
    protected String doInBackground(String... params) {
        String res = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new URL(params[0]).openStream(), "utf-8");

            int eventType = xpp.getEventType();
            boolean bRead = false;
            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        String tag = xpp.getName();
                        if(tag.equals("hour") || tag.equals("day") || tag.equals("temp") || tag.equals("wfKor")){
                            bRead = true;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        if(bRead){
                            res += xpp.getText() + " ";
                            bRead = false;
                        }
                        break;
                }
                eventType = xpp.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;

    }

}
