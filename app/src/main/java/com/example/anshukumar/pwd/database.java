package com.example.anshukumar.pwd;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Anshu Kumar on 10/20/2017.
 */

public class database extends SQLiteOpenHelper {
    public final static String DatabaseName="Student.db";
    public final static String TableName="SignUp";
    public final static String cols1="userId";
    public final static String cols2="name";
    public final static String cols3="email";
    public final static String cols4="password";
    public database(Context context) {
        super(context, DatabaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + DatabaseName +"(UserId Text,Name Text,Email_id Text Unique,Password Vrachar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("Drop table if exists"+DatabaseName);
        onCreate(sqLiteDatabase);
    }
    public boolean datainserted(String userid,String name,String email,String pwd) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(cols1,userid);
        contentValues.put(cols2,name);
        contentValues.put(cols3,email);
        contentValues.put(cols4,pwd);
       long flag =  sqLiteDatabase.insert(TableName,null,contentValues);
        if(flag==-1)
            return false;
        else
            return true;
    }
}
