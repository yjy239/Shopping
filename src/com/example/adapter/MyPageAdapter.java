package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MyPageAdapter extends PagerAdapter{
	
	private List<View> viewlist;
	
	public MyPageAdapter(List<View> viewlist){
		this.viewlist = viewlist;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(viewlist != null){
			return viewlist.size();
		}
		return 0;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
	
	@Override
	public void destroyItem(View arg0,int arg1,Object arg2){
		((ViewPager)arg0).removeView(viewlist.get(arg1));
	}
	
	@Override
	public Object instantiateItem(View arg0,int arg1){
		((ViewPager)arg0).addView(viewlist.get(arg1),0);
		return viewlist.get(arg1);
	}
	
	
	
}
