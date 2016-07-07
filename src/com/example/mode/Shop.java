package com.example.mode;

import android.widget.ImageView;

public class Shop {
	private String name;
	private int Imgid;
	private ImageView Imgview;
	private String introduce;
	private Object surfaceview;
	private boolean isVIP;
	private int benefit;
	private String cityname;
	private String proname;
	
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

}
