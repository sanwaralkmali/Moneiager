package com.example.salah.moneiager;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {
        super(context, "moneyManagerProject_db", null, 1);
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

    public List<historyModel> getAllNotes() {
        List<historyModel> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + historyModel.TABLE_NAME + " ORDER BY " +
                historyModel.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                historyModel note = new historyModel();
                note.setId(cursor.getInt(cursor.getColumnIndex(historyModel.COLUMN_ID)));
                note.setdescription(cursor.getString(cursor.getColumnIndex(historyModel.COLUMN_DESCRIPTION)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(historyModel.COLUMN_TIMESTAMP)));
                note.setPrice(cursor.getInt(cursor.getColumnIndex(historyModel.COLUMN_PRICE)));
                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public List<historyModel> getAllNotes(String date) {
        List<historyModel> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + historyModel.TABLE_NAME +" WHERE "+ historyModel.COLUMN_TIMESTAMP +
        "='"+date+"' ORDER BY " +
                historyModel.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                historyModel note = new historyModel();
                note.setId(cursor.getInt(cursor.getColumnIndex(historyModel.COLUMN_ID)));
                note.setdescription(cursor.getString(cursor.getColumnIndex(historyModel.COLUMN_DESCRIPTION)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(historyModel.COLUMN_TIMESTAMP)));
                note.setPrice(cursor.getInt(cursor.getColumnIndex(historyModel.COLUMN_PRICE)));
                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public List<UserInfo> getUser() {
        List<UserInfo> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + UserInfo.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserInfo note = new UserInfo();
                note.setUserName(cursor.getString(cursor.getColumnIndex(UserInfo.COLUMN_UserName)));
                note.setUserEmail(cursor.getString(cursor.getColumnIndex(UserInfo.COLUMN_UserEmail)));
                note.setUserIncome(cursor.getInt(cursor.getColumnIndex(UserInfo.COLUMN_UserIncome)));
                note.setItemMax(cursor.getInt(cursor.getColumnIndex(UserInfo.COLUMN_ItemMax)));
                note.setUserMax(cursor.getInt(cursor.getColumnIndex(UserInfo.COLUMN_UserMax)));
                note.setToKeep(cursor.getInt(cursor.getColumnIndex(UserInfo.COLUMN_ToKeep)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }


    public long addItem(String description, int price) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(historyModel.COLUMN_DESCRIPTION, description);
        values.put(historyModel.COLUMN_PRICE, price);

        // insert row
        long id = db.insert(historyModel.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public long insertUser(String userName,String userEmail, int userIncome , int userMax, int itemMax, int toKeep) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(UserInfo.COLUMN_UserName, userName);
        values.put(UserInfo.COLUMN_UserEmail, userEmail);
        values.put(UserInfo.COLUMN_UserIncome, userIncome);
        values.put(UserInfo.COLUMN_UserMax, userMax);
        values.put(UserInfo.COLUMN_ItemMax, itemMax);
        values.put(UserInfo.COLUMN_ToKeep, toKeep);

        // insert row
        long id = db.insert(UserInfo.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("delete from " + historyModel.TABLE_NAME);

    }

    public int getSumPrice(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(" +historyModel.COLUMN_PRICE + ") as Total FROM " + historyModel.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            int total = cursor.getInt(cursor.getColumnIndex("Total"));
            return total;
        }
        return 0;
    }

    public void deleteUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + UserInfo.TABLE_NAME);
    }
}
