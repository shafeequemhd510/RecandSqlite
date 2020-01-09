package com.example.recandsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

class DbHelper extends SQLiteOpenHelper {

    String userDetails = "userdetails";
    String col_Name = "Name";
    String col_Place = "Place";

    public DbHelper(@Nullable Context context) {
        super(context, "mydb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + userDetails + "(" + col_Name + " TEXT," + col_Place + " TEXT" + ");";
        Log.d("vw","query"+query);
        db.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

public void insertUserDetails (String name,String place){

    Log.d("vw","inlook"+name+place);
    ContentValues cv=new ContentValues();
    cv.put(col_Name,name);
    cv.put(col_Place, place);
    SQLiteDatabase db=this.getWritableDatabase();
    db.insert(userDetails,null,cv);
}
public Cursor getUserDetails(){
        SQLiteDatabase db=getReadableDatabase();
        String query="Select * from "+userDetails;
        Log.d("vw","curser"+query);
        Cursor cursor=db.rawQuery(query,null);
        return cursor;

}
}
