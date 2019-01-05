package com.example.salah.moneiager;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {
        super(context, "moneyManager_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserInfo.CREATE_TABLE);
        db.execSQL(historyModel.CREATE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ UserInfo.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ historyModel.TABLE_NAME);

        onCreate(db);
    }
}
