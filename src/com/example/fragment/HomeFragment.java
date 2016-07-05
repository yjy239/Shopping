package com.example.fragment;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.example.shopping.MyEditText;
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
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
	
	private ImageView[] mimageview;
	private ImageView[] tipview;
	private int[] ImgIdArray;
	private String[] Imgtxt;
	
	private LinkedList<String> txtList;
	private LinkedList<Integer> list;
	private LinearLayout dotlayout;
	
	private ArrayList<View> views = new ArrayList<View>();

	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,
			Bundle savedInstanceState){
		view = inflater.inflate(R.layout.homefragment, container);
		edittext = (MyEditText)view.findViewById(R.id.findtext);
		citytext = (TextView)view.findViewById(R.id.cityname);
		down = (ImageView)view.findViewById(R.id.getcityname);
		xzing = (ImageView)view.findViewById(R.id.xzing);
		bell = (ImageView)view.findViewById(R.id.message);
		dotlayout = (LinearLayout)view.findViewById(R.id.dotlayout);
		
		viewPager = (ViewPager)view.findViewById(R.id.viewpager);

		getImgData();
		
		
		initViewPager(getActivity());
		
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
			txtList.add(imgname);
		}
		
	}
	
	private void initViewPager(Context context){
		int pagesize = (int)Math.ceil(ImgIdArray.length / 10);
		for(int i = 0;i < pagesize;i++){
			views.add();
		}
	}
	
	private View getViewPagerItem(final Context context,int position,LinkedList<String> txtlist,LinkedList<Integer> list,
			int column,int row){
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.gridview,null);
		GridView gridView = (GridView)view.findViewById(R.id.fountion_grid);
		List<String> subList = new ArrayList<String>();
		
		
	}
	
}
