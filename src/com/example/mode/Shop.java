package com.example.mode;

import java.util.ArrayList;

import com.example.db.MyDataBaseHelper;

import android.R.integer;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ImageView;

public class Shop extends ArrayList<Aisle>{
	private String name;
	private int Imgid;
	private ImageView Imgview;
	private String introduce;
	private Object surfaceview;
	private boolean isVIP;
	private int benefit;
	private String cityname;
	private String proname;
	private String sort;
	private MyDataBaseHelper dbHelper;
	
	public Shop(int nAisle,int nShelf,int nProduct){
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		for(int i = 0;i < nShelf;i++){
			values.put("name", "shop" + i);
			values.put("ImgId", String.valueOf(Imgid));
			values.put("introduce", introduce);
			values.put("vip", true);
			values.put("cityname", "нч");
			values.put("proname", "нч");
			add(new Aisle(nShelf, nProduct));
		}
	}
	
	public Shop() {
		// TODO Auto-generated constructor stub
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setImgid(int id){
		this.Imgid = id;
	}
	
	public int getImgId(){
		return Imgid;
	}
	
	public void setImageView(ImageView Imgview){
		this.Imgview = Imgview;
	}
	
	public ImageView getImageView(){
		return Imgview;
	}
	
	public void setIntroduce(String introduce){
		this.introduce = introduce;
	}
	
	public String getIntroduce(){
		return introduce;
	}
	
	public void setVIP(boolean vip){
		this.isVIP = vip;
	}
	
	public boolean getvip(){
		return isVIP;
	}
	
	public void setbenefit(int benefit){
		this.benefit = benefit;
	}
	
	public int getbenefit(){
		return benefit;
	}
	
	public void setcityName(String cirtname){
		this.cityname = cityname;
	}
	
	public String getcityName(){
		return cityname;
	}
	
	public void setproName(String proname){
		this.proname = proname;
	}
	
	public String getproName(){
		return proname;
	}
	
	public void setSort(String sort){
		this.sort = sort;
	}
	
	public String getSort(){
		return sort;
	}

}
