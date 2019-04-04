package com.example.administrator.androidck;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MySQLite extends SQLiteOpenHelper {
    public static final String DBName = "Demo_Sqlite";
    public static final int VERSION = 1;
    public static final String TABLE_SACH ="SACH";

    public static final String SACH_ID ="ID";
    public static final String SACH_TenSach = "TenSach";
    public static final String SACH_LoaiSach ="LoaiSach";
    public static final String SACH_TacGia ="TacGia";
    public static final String SACH_NXB ="NXB";
    public static final String SACH_SL ="SoLuong";


    public SQLiteDatabase mDB;

    public MySQLite(Context context) {
        super(context, DBName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String mQuery = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INT)",
                                            TABLE_SACH,SACH_ID,SACH_TenSach,SACH_LoaiSach,SACH_TacGia,SACH_NXB,SACH_SL);


            db.execSQL(mQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void OpenDB(){
        mDB = getWritableDatabase();
    }

    public void CloseDB(){
        if (mDB!= null){
            mDB.close();
        }

    }


    public List<Sach> getAll(){
        List<Sach> sachList = new ArrayList<>();
        String mQuery = String.format("SELECT * FROM %s",TABLE_SACH);
        Cursor cursor = mDB.rawQuery(mQuery,null);
        if (cursor.moveToFirst()){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                Sach item = new Sach();
                item.setTenSach(cursor.getString(cursor.getColumnIndex(SACH_TenSach)));
                item.setLoaiSach(cursor.getString(cursor.getColumnIndex(SACH_LoaiSach)));
                item.setTacGia(cursor.getString(cursor.getColumnIndex(SACH_TacGia)));
                item.setNXB(cursor.getString(cursor.getColumnIndex(SACH_NXB)));
                item.setSoLuongSach(cursor.getInt(cursor.getColumnIndex(SACH_SL)));
                sachList.add(item);
            }
            cursor.close();
        }
        return sachList;
    }



    public void addItem(Sach item){
        ContentValues values = new ContentValues();
        values.put(SACH_TenSach,item.getTenSach());
        values.put(SACH_LoaiSach,item.getLoaiSach());
        values.put(SACH_TacGia,item.getTacGia());
        values.put(SACH_NXB,item.getNXB());
        values.put(SACH_SL,item.getSoLuongSach());
        mDB.insert(TABLE_SACH,null,values);

    }



    public void DeleteData(Sach item){
        String mQuery = String.format("%s = %s",SACH_TenSach,"'"+item.getTenSach()+"'");
        mDB.delete(TABLE_SACH,mQuery,null);

    }



    public  void UpdateData(String Ten,int SL){
        String mQuery = String.format("%s = %s",SACH_TenSach,"'"+Ten+"'");
        ContentValues values = new ContentValues();
        values.put(SACH_SL,SL);
        mDB.update(TABLE_SACH,values,mQuery,null);
    }


}
