package com.example.fragment;

import java.util.ArrayList;

import com.example.adapter.GridAdapter;
import com.example.adapter.ShopListAdapter;
import com.example.shopping.R;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MineFragment extends Fragment{
	private View view;
	private TextView minetext;
	private ImageView setting;
	private ImageView bell;
	private ImageView headview;
	private TextView mineid;
	private ImageView downpull;
	private ListView f_list;
	private GridView gridview;
	private GridView listGrid;
	private ArrayList<Integer> img = new ArrayList<Integer>();
	private ArrayList<String> fname = new ArrayList<String>();
	private ArrayList<Integer> listimg = new ArrayList<Integer>();
	private ArrayList<String> listname = new ArrayList<String>();
	private ArrayList<Integer> f_img = new ArrayList<Integer>();
	private ArrayList<String> f_text = new ArrayList<String>();
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle savedInstancedState){
		view = inflater.inflate(R.layout.minefragment, container,false);
		minetext = (TextView)view.findViewById(R.id.mine_text);
		setting = (ImageView)view.findViewById(R.id.setting);
		bell = (ImageView)view.findViewById(R.id.bell_mine);		
		headview = (ImageView)view.findViewById(R.id.head);
		mineid = (TextView)view.findViewById(R.id.id);
		downpull = (ImageView)view.findViewById(R.id.downpull);
		f_list = (ListView)view.findViewById(R.id.wallet_list);
		gridview = (GridView)view.findViewById(R.id.mine_fountion);
		listGrid = (GridView)view.findViewById(R.id.list_fountion);
		initlist();
		initgrid(getActivity());
		initlistgrid(getActivity());
		initminelist(getActivity());
		return view;
	}
	
	private void initlist(){
		img.add(R.drawable.money);
		img.add(R.drawable.result);
		img.add(R.drawable.collection);
		fname.add("金劵");
		fname.add("评价");
		fname.add("收藏");
		listimg.add(R.drawable.credit_card);
		listimg.add(R.drawable.wait_use);
		listimg.add(R.drawable.result);
		listimg.add(R.drawable.refund);
		listname.add("待支付");
		listname.add("待使用");
		listname.add("待评价");
		listname.add("退款/售后");
		f_img.add(R.drawable.wallet);
		f_img.add(R.drawable.money);
		f_img.add(R.drawable.vip);
		f_text.add("我的钱包");
		f_text.add("抵用券");
		f_text.add("会员卡");
		
	}
	
	private void initgrid(Context context){
		Log.e("grid", "here");
		for(String i : fname){
			Log.e("fname",i);
		}
		for(int i : img){
			Log.e("img", String.valueOf(i));
		}
		GridAdapter gridAdapter = new GridAdapter(fname, img, context,1);
		gridview.setAdapter(gridAdapter);
		gridview.setNumColumns(3);
	}
	
	private void initlistgrid(Context context){
		GridAdapter gridAdapter = new GridAdapter(listname, listimg, context, 0);
		listGrid.setAdapter(gridAdapter);
	}
	
	private void initminelist(Context context){
		ShopListAdapter listAdapter = new ShopListAdapter(f_text, f_img, context,1);
		f_list.setAdapter(listAdapter);
	}
	
	
}
