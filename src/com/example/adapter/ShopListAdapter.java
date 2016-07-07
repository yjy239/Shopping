package com.example.adapter;

import java.util.ArrayList;

import com.example.shopping.R;

import android.content.Context;
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
	
	public ShopListAdapter(ArrayList<String>nameList,ArrayList<Integer>imgList,Context context){
		super();
		this.nameList = nameList;
		this.imgList = imgList;
		this.context = context;
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


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
			viewHolder.imageview = (ImageView)convertView.findViewById(R.id.list_img);
			viewHolder.textview = (TextView)convertView.findViewById(R.id.list_shop);
			viewHolder.textview2 = (TextView)convertView.findViewById(R.id.list_intro);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder)convertView.getTag();
		}
		viewHolder.imageview.setImageResource(imgList.get(position));
		viewHolder.textview.setText(nameList.get(position));
		viewHolder.textview2.setText("ÎÒÎª¿Õ");
		return convertView;
	}
	
	class ViewHolder{
		ImageView imageview;
		TextView textview;
		TextView textview2;
	}
	

}
