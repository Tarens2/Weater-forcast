package com.example.taras.weatheforcast1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.taras.weatheforcast1.model.WetherObject;

import java.util.ArrayList;

/**
 * Created by Taras on 02.05.2016.
 */
public class DB {
    private static final int DB_VERSION = 1;
    private static final String NAME_DB = "myDB";

    public static final String WEATHER_TABLE = "myweather";
    public static final String COLUMN_ID = "_id";
    public static final String date = "date";
    public static final String temp = "temp";
    public static final String description = "description";
    public static final String icon = "icon";

    private static final String DB_CREATEweather =
            "create table " + WEATHER_TABLE + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    date + " text, " + temp + " text, " + description + " text, " + icon + " text"+");";

    private final Context mCtx;
    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    public DB(Context ctx) {
        mCtx = ctx;
    }

    public void open() {
        mDBHelper = new DBHelper(mCtx, NAME_DB, null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();

    }

    public void close() {
        if (mDBHelper != null) mDBHelper.close();
    }

    public Cursor getAllData() {
        return mDB.query(WEATHER_TABLE, null, null, null, null, null, null);
    }

    public void addRec(WetherObject weObj) {
            ContentValues cv = new ContentValues();
            cv.put(date,weObj.getTime());
            cv.put(temp, weObj.getTemp());
            cv.put(description, weObj.getDescription());
            cv.put(icon,weObj.getImg());

            mDB.insert(WEATHER_TABLE, null, cv);

    }
/*
    public String getRec(int positon) {
        mDB = mDBHelper.getReadableDatabase();
        Cursor c = mDB.query(NAME_TABLE1, null, null, null, null, null, null);
        int nameColIndex = c.getColumnIndex(COLUMN_TXT);
        c.moveToPosition(positon);
        return c.getString(nameColIndex);
    }*/

    public void delRec(long id) {
        //mDB.delete(NAME_TABLE1, COLUMN_ID + " = " + id, null);
    }

    public void delAll() {
        int clearCount = mDB.delete(WEATHER_TABLE, null, null);
        Log.v(MainActivity.tag,"deleted "+clearCount);

    }

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATEweather);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
