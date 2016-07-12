package com.example.adapter;

import java.util.ArrayList;

import com.example.shopping.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShopListAdapter extends BaseAdapter{
	private ArrayList<String>nameList;
	private ArrayList<Integer>imgList;
	private Context context;
	private int id;
	
	public ShopListAdapter(ArrayList<String>nameList,ArrayList<Integer>imgList,Context context,int id){
		super();
		this.nameList = nameList;
		this.imgList = imgList;
		this.context = context;
		this.id = id;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return nameList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private int getid(){
		return id;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		int i = getid();
		if(convertView == null){
			viewHolder = new ViewHolder();
			switch (i) {
			case 0:
				convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
				viewHolder.imageview = (ImageView)convertView.findViewById(R.id.list_img);
				viewHolder.textview = (TextView)convertView.findViewById(R.id.list_shop);
				viewHolder.textview2 = (TextView)convertView.findViewById(R.id.list_intro);
				viewHolder.textview2.setText("ÎÒÎª¿Õ");
				break;
				
			case 1:
				convertView = LayoutInflater.from(context).inflate(R.layout.mine_item, null);
				viewHolder.imageview = (ImageView)convertView.findViewById(R.id.f_img);
				viewHolder.textview = (TextView)convertView.findViewById(R.id.f_text);
				viewHolder.textview2 = (TextView)convertView.findViewById(R.id.f_balance);
				viewHolder.textview2.setText("0");

			default:
				break;
			}
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		viewHolder.imageview.setImageResource(imgList.get(position));
		viewHolder.textview.setText(nameList.get(position));
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView imageview;
		TextView textview;
		TextView textview2;
	}
	
	

}
