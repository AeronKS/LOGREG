package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "felhasznalo.db";
    public static final int DB_VERSION = 1;

    public static final String FELHASZNALO_TABLE = "felhasznalo";

    public static final String COL_ID        = "id";
    public static final String COL_EMAIL     = "email";
    public static final String COL_FELHNEV   = "felhnev";
    public static final String COL_JELSZO    = "jelszo";
    public static final String COL_TELJESNEV = "teljesnev";

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE IF NOT EXISTS " + FELHASZNALO_TABLE + "(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL + " VARCHAR(255) NOT NULL, " +
                COL_FELHNEV + " VARCHAR(255) NOT NULL, " +
                COL_JELSZO + " VARCHAR(255) NOT NULL, " +
                COL_TELJESNEV + " VARCHAR(255) NOT NULL " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = " DROP TABLE IF EXISTS " + FELHASZNALO_TABLE;
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean adatRegisztracio(String email, String felhnev, String jelszo, String teljesnev){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_EMAIL, email);
        values.put(COL_FELHNEV, felhnev);
        values.put(COL_JELSZO, jelszo);
        values.put(COL_TELJESNEV, teljesnev);
        return db.insert(FELHASZNALO_TABLE, null, values) != -1;
    }

    public Cursor adatLekerdezes(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(FELHASZNALO_TABLE, new String[]{COL_ID, COL_EMAIL, COL_FELHNEV, COL_JELSZO, COL_TELJESNEV}, null, null,
                null, null ,null);
    }

    public boolean felhnevLetezik(String felhnev) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM felhasznalo WHERE felhnev = ?", new String[]{felhnev});
        return result.getCount() == 1;
    }

    public boolean jelszoLetezik(String jelszo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM felhasznalo WHERE jelszo = ?", new String[]{jelszo});
        return result.getCount() == 1;
    }
}
