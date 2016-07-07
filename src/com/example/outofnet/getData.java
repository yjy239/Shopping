package com.example.outofnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.mode.Shop;
import com.example.shopping.R;

public class getData {
	private Shop shopmode;
	private static int[] ShopImg = {R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop4,R.drawable.shop5,
		R.drawable.shop6,R.drawable.shop7,R.drawable.shop8,R.drawable.shop9,R.drawable.shop10};
	private List<Shop> shopList = new ArrayList<Shop>();
	
	
	public void getImg(){
		for(int i = 0;i < ShopImg.length;i++){
			shopmode = new Shop();
			shopmode.setName("shop" + (i+1));
			shopmode.setImgid(ShopImg[i]);
			shopList.add(shopmode);
		}
	}
	
	public Shop getShop(int i){
		return shopList.get(i);
	}
	
	public int shopCount(){
		return shopList.size();
	}
}
