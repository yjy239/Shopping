package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MyDataBaseHelper extends SQLiteOpenHelper{
	private Context mContext;
	
	public static final String CREATE_PRODUCT = "create table Product(" 
			+"id integer primary key autoincrement,"
			+"name text," + "txtpro text," + "price integer," + "benefit integer)";
	
	public static final String CREATE_SHELF = "create table Shelf("
			+"id integer primary key autoincrement,"
			+"sort text)";
	
	public static final String CREATE_SHOP = "create table Shop("
			+"id integer primary key autoincrement,"
			+"name text," + "ImgId integer," + "introduct text," + "vip boolean," + "benefit integer,"
			+"proname text," + "cityname text," + "sort text)";
	
	
	public MyDataBaseHelper(Context context,String name,CursorFactory factory,int version){
		super(context, name, factory, version);
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PRODUCT);
		db.execSQL(CREATE_SHELF);
		db.execSQL(CREATE_SHOP);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	

}
