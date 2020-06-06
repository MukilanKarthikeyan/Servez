package com.example.servezy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "People.db";
    public static final String TABLE_NAME = "people_table";
    public static final String COL_1 = "FirstName";
    public static final String COL_2 = "LastName";
    public static final String COL_3 = "PhoneNumber";
    public static final String COL_4 = "HomeAddress";
    public static final String COL_5 = "Volunteer";     //true/false, with false being those in need

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + TABLE_NAME + " (FirstName TEXT,LastName TEXT,PhoneNumber BIGINT,HomeAddress TEXT,Volunteer BOOLEAN)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
