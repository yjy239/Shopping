package com.example.adapter;

import java.util.LinkedList;
import java.util.List;

import com.example.shopping.R;

import android.R.integer;
import android.R.raw;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter{
	private List<String> txtlist;
	private List<Integer> list;
	private Context mContext;
	int id = 0;
	
	public GridAdapter(List<String> txtlist,List<Integer> list,Context context,int id){
		super();
		this.txtlist = txtlist;
		this.list = list;
		this.mContext = context;
		this.id = id;
	}
	
	public void clear(){
		this.mContext = null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public int getId(){
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//Log.e("positionlist", String.valueOf(position));
		ViewHolder holder;
		int Gid = getId();
		if(convertView == null){
			holder = new ViewHolder();
			switch (Gid) {
			case 0:
				convertView = LayoutInflater.from(mContext).inflate(R.layout.img_item, null);
				holder.image = (ImageView) convertView.findViewById(R.id.img_item);
				holder.text = (TextView) convertView.findViewById(R.id.txt_item);
				convertView.setTag(holder);
				break;
				
			case 1:
				convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item, null);
				holder.image = (ImageView) convertView.findViewById(R.id.mine_img);
				holder.text = (TextView) convertView.findViewById(R.id.mine_text);
				convertView.setTag(holder);
			default:
				break;
			}
			
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.image.setImageResource(list.get(position));
		holder.text.setText(txtlist.get(position));
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView image;
		TextView text;
	}

}
