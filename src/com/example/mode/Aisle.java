package com.example.mode;

import java.util.ArrayList;

import com.example.db.MyDataBaseHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Aisle extends ArrayList<Shelf>{
	private MyDataBaseHelper dbHelper;
	public Aisle(int nShelf,int nProduct){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		for(int i = 0;i < nShelf;i++){
			values.put("sort", String.valueOf(i));
			add(new Shelf(nProduct,i,String.valueOf(i)));
		}
	}
}
