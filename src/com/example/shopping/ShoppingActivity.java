package com.example.shopping;

import java.util.ArrayList;

import com.example.fragment.HomeFragment;
import com.example.fragment.MineFragment;
import com.example.fragment.ShopFragment;
import com.example.shopping.R.layout;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ShoppingActivity extends Activity{
	private ImageView home;
	private ImageView shop;
	private ImageView person;
	private ImageView more;
	private FragmentManager fragmentManager;
	private HomeFragment homeFragment;
	private ShopFragment shopFragment;
	private MineFragment mineFragment;
	private FragmentTransaction transaction;
	private ArrayList<Fragment> fragList = new ArrayList<Fragment>();
	private Fragment currentFragment;
	private int currentIndex = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shopping_main);
		
		home = (ImageView)findViewById(R.id.home_page);
		shop = (ImageView)findViewById(R.id.business);
		person = (ImageView)findViewById(R.id.me);
		more = (ImageView)findViewById(R.id.more);
		
		home.setOnClickListener(onClickListener);
		shop.setOnClickListener(onClickListener);
		person.setOnClickListener(onClickListener);
		more.setOnClickListener(onClickListener);
		
		home.setTag(0);
		shop.setTag(1);
		person.setTag(2);
		more.setTag(3);		
		initFragment();
		
	}
	
	private void initFragment(){
		fragList.add(new HomeFragment());
		fragList.add(new ShopFragment());
		fragList.add(new MineFragment());
		home.setSelected(true);
		changeFragment(0);
	}
	
	private void changeFragment(int index){
		currentIndex = index;
		home.setSelected(index == 0);
		shop.setSelected(index == 1);
		person.setSelected(index == 2);
		more.setSelected(index == 3);
		
		transaction = getFragmentManager().beginTransaction();
		if(currentFragment != null){
			transaction.hide(currentFragment);
		}
		
		Fragment fragment = getFragmentManager().findFragmentByTag(fragList.get(index).getClass().getName());
		
		if(fragment == null){
			fragment = fragList.get(index);
		}
		currentFragment = fragment;
		
		if(!fragment.isAdded()){
			transaction.add(R.id.above,fragment,fragment.getClass().getName());
		}else{
			transaction.show(fragment);
		}
		transaction.commit();
	}
	
	
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
		
			// TODO Auto-generated method stub
			changeFragment((Integer)v.getTag());
			
		}
	};

	
}
