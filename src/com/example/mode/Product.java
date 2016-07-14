package com.example.mode;

import java.util.Random;

import com.example.db.MyDataBaseHelper;

import android.R.integer;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class Product {
	private int id;
	private String name;
	private String txtpro;
	private int price;
	private double benefit;
	private static MyDataBaseHelper dbHelper;
	
	public Product(int id,String name,String txtpro,int price,double benefit){
		this.id = id;
		this.name = name;
		this.txtpro = txtpro;
		this.price = price;
		this.benefit = benefit;
	}
	
	private void setid(int id){
		this.id = id;
	}
	private int getid(){
		return id;
	}
	
	private void setName(String name){
		this.name = name;
	}
	private String getName(){
		return name;
	}
	
	private void setTextpro(String txtpro){
		this.txtpro = txtpro;
	}
	private String getTextpro(){
		return txtpro;
	}
	
	private void setPrice(int price){
		this.price = price;
	}
	private int getPrice(){
		return price;
	}
	
	private void setBenefit(double benefit){
		this.benefit = benefit;
	}
	private double getBenefit(){
		return benefit;
	}
	
	public static achievement<Product> achievement = new achievement<Product>() {
		int i = 0;
		final int counter = i++;
		@Override
		public Product next() {
			// TODO Auto-generated method stub
			Random random = new Random(47);
			int rand = random.nextInt(1000);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			Uri uri = Uri.parse("content://com.example.db.provider/Product");
			ContentValues values = new ContentValues();
			values.put("name", "shop" + counter);
			values.put("txtpro", "Пе");
			values.put("price", rand);
			values.put("benefit", 9.8);
			db.insert("Product", null, values);
			return new Product(counter,"shop" + counter,"Пе",rand,9.8);
		}
		
		
		
	};


	
}
