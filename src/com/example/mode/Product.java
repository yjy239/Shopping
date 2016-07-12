package com.example.mode;

public class Product {
	private String name;
	private String txtpro;
	private int price;
	private int benfit;
	
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
	
	private void setBenefit(int benefit){
		this.benfit = benefit;
	}
	private int getBenefit(){
		return benfit;
	}
	
}
