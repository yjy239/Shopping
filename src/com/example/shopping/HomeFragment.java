package com.example.shopping;

import com.example.shopping.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class HomeFragment extends Fragment{
	
	private View view;
	private EditText edittext;
	private TextView citytext;
	private ImageView down;
	private ImageView xzing;
	private ImageView bell;
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle savedInstanceState){
		view = inflater.inflate(R.layout.homefragment, container);
		edittext = (EditText)view.findViewById(R.id.findtext);
		citytext = (TextView)view.findViewById(R.id.cityname);
		down = (ImageView)view.findViewById(R.id.getcityname);
		xzing = (ImageView)view.findViewById(R.id.xzing);
		bell = (ImageView)view.findViewById(R.id.message);
		return view;
	}
}
