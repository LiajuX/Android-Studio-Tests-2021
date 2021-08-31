package com.example.carteiradevacinao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS VACCINE");

        sqLiteDatabase.execSQL("CREATE TABLE VACCINE(\n" +
                "\tID_VACCINE INT NOT NULL,\n" +
                "\tNAME VARCHAR(50) NOT NULL,\n" +
                "\tDATE VARCHAR(8) NOT NULL,\n" +
                "\tCLINIC VARCHAR(50) NOT NULL,\n" +
                "\tDOSE INT NOT NULL,\n" +
                "\tPRIMARY KEY (ID_VACCINE)\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS VACCINE");
    }

    public void insertVaccine(Integer id, String name, String date, String clinic, Integer dose) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("ID_VACCINE", id);
        cv.put("NAME", name);
        cv.put("DATE", date);
        cv.put("CLINIC", clinic);
        cv.put("DOSE", dose);
        db.insert("VACCINE","ID_VACCINE",cv);
    }

    Cursor listAllVaccines() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cur = db.rawQuery("SELECT ID_VACCINE,NAME,DATE,CLINIC,DOSE FROM VACCINE ORDER BY ID_VACCINE",null);

        return cur;
    }

    public void updateVaccine(Integer id, String name, String date, String clinic, Integer dose) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("ID_VACCINE", id);
        cv.put("NAME", name);
        cv.put("DATE", date);
        cv.put("CLINIC", clinic);
        cv.put("DOSE", dose);
        db.update("VACCINE",cv,"ID_VACCINE=?",new String[]{id.toString()});
    }

    public void deleteVaccine(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("VACCINE","ID_VACCINE=?",new String[]{id});
    }
}
