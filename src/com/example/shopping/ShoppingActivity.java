package com.example.shopping;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ShoppingActivity extends Activity{
	private ImageView home;
	private ImageView shop;
	private ImageView person;
	private ImageView more;
	
	@Override
	protected void onCreate(Bundle savedInstanceBundle){
		super.onCreate(savedInstanceBundle);
		setContentView(R.layout.shopping_main);
		
		home = (ImageView)findViewById(R.id.home_page);
		shop = (ImageView)findViewById(R.id.business);
		person = (ImageView)findViewById(R.id.me);
		more = (ImageView)findViewById(R.id.more);
		
		home.setOnClickListener(onClickListener);
		shop.setOnClickListener(onClickListener);
		person.setOnClickListener(onClickListener);
		more.setOnClickListener(onClickListener);		
		
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.home_page:
				home.setImageResource(R.drawable.home_color);
				shop.setImageResource(R.drawable.shop_grey);
				person.setImageResource(R.drawable.person_grey);
				more.setImageResource(R.drawable.more_grey);
				break;
			case R.id.business:
				home.setImageResource(R.drawable.home_grey);
				shop.setImageResource(R.drawable.shop_color);
				person.setImageResource(R.drawable.person_grey);
				more.setImageResource(R.drawable.more_grey);
				break;
			case R.id.me:
				home.setImageResource(R.drawable.home_grey);
				shop.setImageResource(R.drawable.shop_grey);
				person.setImageResource(R.drawable.person_color);
				more.setImageResource(R.drawable.more_grey);
				break;
			case R.id.more:
				home.setImageResource(R.drawable.home_grey);
				shop.setImageResource(R.drawable.shop_grey);
				person.setImageResource(R.drawable.person_grey);
				more.setImageResource(R.drawable.more_color);
				break;
				
				default:
					;
			}
		}
	};

	
}
