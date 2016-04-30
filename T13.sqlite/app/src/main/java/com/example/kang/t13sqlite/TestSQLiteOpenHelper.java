package com.example.kang.t13sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kang on 2016-04-23.
 */
public class TestSQLiteOpenHelper extends SQLiteOpenHelper{
    public TestSQLiteOpenHelper(Context context, String name,
                                SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {           //sql처음 시작할 때, 한번 생성
        String sql = "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT, " + "name TEXT, age INTEGER, address TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {      //버전 관리
        String sql = "DROP TABLE IF EXISTS student";
        db.execSQL(sql);

        onCreate(db);

    }
}
