package com.example.db;

import android.R.integer;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class productProvider extends ContentProvider{
	public static final int SHOP_ITEM = 0;
	public static final int SHELF_ITEM = 1;
	public static final int PRODUCT_ITEM = 2;
	public static final String AUTHORTY = "com.example.db.provider";
	private static UriMatcher uriMatcher;
	private MyDataBaseHelper dbHelper;
	
	static{
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORTY, "Product", PRODUCT_ITEM);
		uriMatcher.addURI(AUTHORTY, "Shelf", SHELF_ITEM);
		uriMatcher.addURI(AUTHORTY, "Shop", SHOP_ITEM);
	}
	
	@Override
	public boolean onCreate(){
		dbHelper = new MyDataBaseHelper(getContext(), "Shop.db", null, 1);
		return true;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		int deleteRows = 0;
		switch (uriMatcher.match(uri)) {
		case PRODUCT_ITEM:
			String productid = uri.getPathSegments().get(1);
			deleteRows = db.delete("Product", "id = ?", new String[]{productid});
			break;
		case SHELF_ITEM:
			String shelfid = uri.getPathSegments().get(1);
			deleteRows = db.delete("Shelf", "id = ?", new String[]{shelfid});
			break;
		case SHOP_ITEM:
			String shopid = uri.getPathSegments().get(1);
			deleteRows = db.delete("Shop", "id = ?", new String[]{shopid});
			break;
		default:
			break;
		}
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Uri uriReturn = null;
		switch (uriMatcher.match(uri)) {
		case PRODUCT_ITEM:
			long newproductid = db.insert("Product", null, values);
			uriReturn = uri.parse("content://" + AUTHORTY + "/Product/" + newproductid);
			break;
		case SHELF_ITEM:
			long newshelfid = db.insert("Shelf", null, values);
			uriReturn = uri.parse("content://" + AUTHORTY + "/Shelf/" + newshelfid);
			break;
		case SHOP_ITEM:
			long newshopid = db.insert("Shop", null, values);
			uriReturn = uri.parse("content://" + AUTHORTY + "/Shop/" + newshopid);
			break;

		default:
			break;
		}
		return uriReturn;
	}


	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
			String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = null;
		switch(uriMatcher.match(uri)){
		case PRODUCT_ITEM:
			String pid = uri.getPathSegments().get(1);
			cursor = db.query("Product", projection, "id = ?", new String[]{pid}, null, null, sortOrder);
			break;
		case SHELF_ITEM:
			String shelfid = uri.getPathSegments().get(1);
			cursor = db.query("Shelf", projection, "id = ?", new String[]{shelfid}, null,null, sortOrder);
			break;
		case SHOP_ITEM:
			String shopid = uri.getPathSegments().get(1);
			cursor = db.query("Shop", projection, "id = ?", new String[]{shopid}, null,null, sortOrder);
			break;
		}
		
		return cursor;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		int updateRows = 0;
		switch(uriMatcher.match(uri)){
		case PRODUCT_ITEM:
			String productid = uri.getPathSegments().get(1);
			updateRows = db.update("Product", values, "id = ?", new String[]{productid});
			break;
		case SHELF_ITEM:
			String shelfid = uri.getPathSegments().get(1);
			updateRows = db.update("Shelf", values, "id = ?", new String[]{shelfid});
			break;
		case SHOP_ITEM:
			String shopid = uri.getPathSegments().get(1);
			updateRows = db.update("Shop", values, "id = ?", new String[]{shopid});
			break;
			
		}
		return updateRows;
	}

}
