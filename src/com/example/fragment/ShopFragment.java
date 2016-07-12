package com.example.fragment;

import com.example.shopping.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopFragment extends Fragment{
	private View view;
	private TextView allshop;
	private TextView benefitshop;
	private ImageView findcity;
	private ImageView location;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle savedInstanceState){
		view = inflater.inflate(R.layout.shopfragment, container,false);
		allshop = (TextView)view.findViewById(R.id.allshop);
		benefitshop = (TextView)view.findViewById(R.id.benefitshop);
		findcity = (ImageView)view.findViewById(R.id.find_city);
		location = (ImageView)view.findViewById(R.id.get_location);
	
		return view;
		
	}
}
