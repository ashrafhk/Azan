package com.example.ashrafhussain.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DB_Helper extends SQLiteOpenHelper {

    public  static  final  String DATABASE_NAME = "Student.db";
    public  static  final  String TABLE_NAME  = "student_table";

    private static final String TAG = "DatabaseHelper";

    public  static  String COL_1  = "ID";
    public  static  String COL_2  = "NAME";

    public DB_Helper(Context context) {
        super(context, DATABASE_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +COL_2+" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        db.close();
    }

    public boolean addData(String item){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    /**
     * Returns all the data from database
     * @return
     */
    public Cursor getdatalist(){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    /**
     * Returns only the ID that matches the name passed in
     * @param name
     * @return
     */
    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT " + COL_1 + " FROM " + TABLE_NAME + " WHERE " + COL_2 + " = '" + name + "'";

        Cursor data = db.rawQuery(query, null);
        return data;
    }
    /**
     * Updates the name field
     * @param id
     * @param newName
     * @param oldName
     */
    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "UPDATE " + TABLE_NAME + " SET " + COL_2 + " = '" + newName + "' WHERE "
                        + COL_1 + " = '" + id + "'" + " AND " + COL_2 + " = '" + oldName + "'";

        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    /**
     * Delete from database
     * @param id
     * @param name
     */
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "DELETE FROM " +TABLE_NAME+ " WHERE " +COL_1+ " = '"+id+"'" + " AND " +COL_2+ " = '"+name+"'";

        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }
}
