package com.example.shopping;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class FindShopActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.findshop);
	}
}
