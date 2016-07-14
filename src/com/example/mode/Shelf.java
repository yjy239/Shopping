package com.example.mode;

import java.util.ArrayList;

import android.R.integer;

public class Shelf extends ArrayList<Product>{
	private int id;
	private String sort;
	public Shelf(int n,int id,String sort) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.sort = this.sort;
		Achieve.fill(this, Product.achievement, n);
	}
	
	public void setid(int id){
		this.id = id;
	}
	public int getid(){
		return id;
	}
	
	public void setsort(String sort){
		this.sort = sort;
	}
	
	public String getsort(){
		return sort;
	}
}
