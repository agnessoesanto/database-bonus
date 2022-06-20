package com.example.lat24mei22;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "MyDB";

    private static final String TB_NAME= "Users";
    private static final String KEY_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_NIK = "nik";
    private static final String KEY_PASS = "password";

    public DBHandler(Context c) {
        super(c, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Query = "CREATE TABLE "+TB_NAME+"("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_NAMA+" TEXT, "+KEY_PASS+" TEXT, "+KEY_NAMA+" TEXT)";
        Log.d("SQLITE", "MSGS");
        db.execSQL(Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TB_NAME);
        onCreate(db);
    }

    //   public boolean insertUser(String nama, String pasword) {
    //       SQLiteDatabase db = this.getWritableDatabase();
    //       ContentValues cv = new ContentValues();
    //       cv.put("nama", nama);
    //       cv.put("password", pasword);
    //       db.insert(TB_NAME,null,cv);
    //       db.close()
    //       return true;
    //   }

    public boolean insertUser(DataModel user) {
        Log.d("SQLITE", "INSERTING USER");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAMA,user.getNama());
        cv.put(KEY_PASS,user.getPassword());
        cv.put(KEY_NIK, user.getnik());
        db.insert(TB_NAME,null,cv);
        db.close();
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM"+TB_NAME+" WHERE id="+id,null);
        return result;
    }


    /*public List<DataModel> getAll() {
        List <DataModel> userList = new ArrayList<DataModel>();
        String query = "SELECT * FROM "+TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query,null);
        if(c.moveToFirst()) {
            do {
                DataModel u = new DataModel();
                u.setId(Integer.parseInt(c.getString(0)));
                u.setNama(c.getString(1));
                u.setPassword(c.getString(2));
                userList.add(u);
            }while (c.moveToNext());
        }

        return userList;
    }*/

    public Cursor getAll() {
        String query = "SELECT * FROM " + TB_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = null;
        if(db != null){
            c = db.rawQuery(query, null);
        }
        return c;
    }
}
