package com.example.fragment;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

import com.example.adapter.GridAdapter;
import com.example.adapter.MyPageAdapter;
import com.example.adapter.ShopListAdapter;
import com.example.mode.Shop;
import com.example.mywidget.MyEditText;
import com.example.mywidget.MyListView;
import com.example.mywidget.MyViewPager;
import com.example.outofnet.getData;
import com.example.shopping.R;
import com.example.shopping.R.id;
import com.example.shopping.R.layout;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

@SuppressLint("NewApi")
public class HomeFragment extends Fragment{
	
	private View view;
	private MyEditText edittext;
	private TextView citytext;
	private ImageView down;
	private ImageView xzing;
	private ImageView bell;
	private ImageView imageview;
	private ViewPager viewPager;
	private GridView gridView;
	private TextView buytext;
	private getData getdata;
	private Shop shop;
	private MyListView shoplist;
	private ImageView[] mimageview;
	private ImageView[] tipview;
	private int[] ImgIdArray;
	private int[] ShopList;
	private String[] Imgtxt;
	
	private List<String> Ramshopname = new ArrayList<String>();
	private List<Integer> RamshopImgid = new ArrayList<Integer>();
	private ArrayList<String> nameList = new ArrayList<String>();
	private ArrayList<Integer> imgList = new ArrayList<Integer>();
	
	private static LinkedList<String> txtlist = new LinkedList<String>();
	private static LinkedList<Integer> list = new LinkedList<Integer>();
	private LinearLayout dotlayout;
	private int column = 5;
	private int row = 2;
	private GridView FShopView;
	
	
	private ArrayList<View> views = new ArrayList<View>();

	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle savedInstanceState){
		view = inflater.inflate(R.layout.homefragment, container,false);
		edittext = (MyEditText)view.findViewById(R.id.findtext);
		citytext = (TextView)view.findViewById(R.id.cityname);
		buytext = (TextView)view.findViewById(R.id.buytext);
		down = (ImageView)view.findViewById(R.id.getcityname);
		xzing = (ImageView)view.findViewById(R.id.xzing);
		bell = (ImageView)view.findViewById(R.id.message);
		dotlayout = (LinearLayout)view.findViewById(R.id.dotlayout);
		FShopView = (GridView)view.findViewById(R.id.FShopView);
		shoplist = (MyListView)view.findViewById(R.id.shoplist);
		viewPager = (ViewPager)view.findViewById(R.id.viewpager);
		getShop();
		initGrid(getActivity());
		getImgData();	
		initListView(getActivity());
		initViewPager(getActivity());
		
		viewPager.setOnPageChangeListener(new PageChange());
		return view;
	}
	
	private void getImgData(){
		ImgIdArray = new int[]{R.drawable.fountion1,R.drawable.fountion2,R.drawable.fountion3,R.drawable.fountion4,
				R.drawable.fountion5,R.drawable.fountion6,R.drawable.fountion7,R.drawable.fountion8,R.drawable.fountion9,
				R.drawable.fountion10,R.drawable.fountion11};
		String imgname;
		for(int i = 0;i < ImgIdArray.length;i++){
			imgname = "fountion" + (i+1);
			list.add(ImgIdArray[i]);
			//Log.e("ImgId" + String.valueOf(i), String.valueOf(ImgIdArray[i]));
			txtlist.add(imgname);
		}
		
	}
	
	private void getShop(){
		getdata = new getData();
		getdata.getImg();
		shop = new Shop();
		for(int i = 0; i < 3;i++){
			int n = (int)(0 + Math.random()*9);
			shop = getdata.getShop(n);
			Ramshopname.add(shop.getName());
			RamshopImgid.add(shop.getImgId());
		}
		
	}
	
	private void initGrid(Context context){
		GridAdapter buyAdapter = new GridAdapter(Ramshopname, RamshopImgid, context,0);
		FShopView.setAdapter(buyAdapter);
		FShopView.setNumColumns(3);
	}
	
	private void initListView(Context context){
		for(int i = 0;i < getdata.shopCount();i++){
			shop = getdata.getShop(i);
			nameList.add(shop.getName());
			imgList.add(shop.getImgId());
		}
		ShopListAdapter listAdapter = new ShopListAdapter(nameList, imgList,context,0);
		shoplist.setAdapter(listAdapter);
	}
	
	
	private void initViewPager(Context context){
		int pagesize = (int) Math.ceil((float)ImgIdArray.length / (float)10);
		Log.e("pagesize", String.valueOf(pagesize));
		for(int i = 0;i < pagesize;i++){
			views.add(getViewPagerItem(context, i, txtlist, list, column, row));
			LayoutParams params = new LayoutParams(20,20);
			dotlayout.addView(dotitem(i,context),params);
		}
		MyPageAdapter pageAdapter = new MyPageAdapter(views);
		viewPager.setAdapter(pageAdapter);
		dotlayout.getChildAt(0).setSelected(true);
		
	}
	
	LayoutInflater inflater;
	private ImageView dotitem(int position,Context context){
		inflater = LayoutInflater.from(context);
		View dlayout = inflater.inflate(R.layout.dot_img, null);
		ImageView iv = (ImageView)dlayout.findViewById(R.id.dot);
		iv.setId(position);
		return iv;
	}
	
	private View getViewPagerItem(final Context context,int position,LinkedList<String> txtlist,LinkedList<Integer> list,
			int column,int row){
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.gridview,null);
		gridView = (GridView)layout.findViewById(R.id.fountion_grid);
		List<String> txtList = new LinkedList<String>();
		List<Integer> imgList = new LinkedList<Integer>();
		txtList = txtlist.subList(position * (row * column ), (position + 1)*(row * column) > txtlist.size()
				?txtlist.size()  : (position + 1)*(row * column));
		imgList = list.subList(position * (row * column ), (position + 1)*(row * column) > list.size()
				?list.size() : (position +1)*(row * column));
		for(String i : txtList){
			Log.e("String", String.valueOf(i));
		}
		GridAdapter gAdapter = new GridAdapter(txtList, imgList, context,0);
		gridView.setAdapter(gAdapter);
		gridView.setNumColumns(column);
//		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?>parent,View view,,int position,long id){
//				
//				
//			}
//		}); 这里创建按钮响应事件
		return gridView;	
	}
	
	
	
	public class PageChange implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			for(int i = 0;i < dotlayout.getChildCount();i++){
				dotlayout.getChildAt(i).setSelected(false);
			}
			dotlayout.getChildAt(arg0).setSelected(true);
		}
		
	}
	
}
