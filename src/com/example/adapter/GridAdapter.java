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
	
	public GridAdapter(List<String> txtlist,List<Integer> list,Context context){
		super();
		this.txtlist = txtlist;
		this.list = list;
		this.mContext = context;
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Log.e("positionlist", String.valueOf(position));
		ViewHolder holder;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.img_item, null);
			holder.image = (ImageView) convertView.findViewById(R.id.img_item);
			holder.text = (TextView) convertView.findViewById(R.id.txt_item);
			convertView.setTag(holder);
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
