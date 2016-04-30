package com.example.kang.t14xml;

import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Kang on 2016-04-23.
 * DOM Parser 는 트리 전체를 읽기 때문에 Pull Parser보다 느리다
 */
public class MyDomParser extends AsyncTask<String, Void, Document> {
    TextView textView;

    //alt + insert = constructor
    public MyDomParser(TextView textView) {
        this.textView = textView;
    }

    private String getElementText(Element dataElement, String tag) {

        NodeList dayNodeList = dataElement.getElementsByTagName(tag);
        Element dayElement = (Element) dayNodeList.item(0);

        NodeList textNodeList = dayElement.getChildNodes();
        String val = textNodeList.item(0).getNodeValue();

        return val;

    }

    @Override
    protected void onPostExecute(Document document) {
        super.onPostExecute(document);
        String res = "";
        NodeList nodeList = document.getElementsByTagName("data");
        for(int i=0; i<nodeList.getLength(); i++){
            Element dataElement = (Element) nodeList.item(i);
            String day      = getElementText(dataElement, "day");
            String hour     = getElementText(dataElement, "hour");
            String temp     = getElementText(dataElement, "temp");
            String wfKor    = getElementText(dataElement, "wfKor");

            res += "day : " +day + " hour : " +hour+ " temp : " +temp+ " wfKor : " +wfKor;
            res +="\n";
        }
        textView.setText(res);
    }

    @Override
    protected Document doInBackground(String... params) {
        URL url = null;
        Document document = null;
        try {
            url = new URL(params[0]);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            document = builder.parse(url.openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }
}
