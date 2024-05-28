package com.example.my_finance;
import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Datab extends SQLiteOpenHelper  {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyFIn.db";

    public static final String COLUMN_ID = "_id";
    public static final String TABLE_NAME = "MyFinance";
    public static final String COLUMN_MONTH ="month";
    public static final String COLUMN_MONTH_Profit ="profit";
    public static final String COLUMN_MONTH_wastes="wastes";
    private SQLiteDatabase mDataBase;


    Datab(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  }



    @Override
    public  void onCreate(SQLiteDatabase db ) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_MONTH+"TEXT"+COLUMN_MONTH_Profit+"INTEGER"+COLUMN_MONTH_wastes+"INTEGER);";
        db.execSQL(query);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int old_version, int new_Version) {

    }
    public long insert(String month,int profit,int Waste){
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_MONTH,month);
        cv.put(COLUMN_MONTH_Profit,profit);
        cv.put(COLUMN_MONTH_wastes,Waste);
        return (mDataBase.insert(TABLE_NAME, null,cv));
    }
    public void delete(int id){
        mDataBase.delete(TABLE_NAME,COLUMN_ID+"= ?", new String[] { String.valueOf(id) });
    }

}


