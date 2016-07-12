package com.example.mywidget;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

public class MyListView extends ListView{

	public MyListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MyListView(Context context,AttributeSet attrs){
		super(context, attrs);
	}
	
	public MyListView(Context context,AttributeSet attrs,int defStyle){
		super(context, attrs, defStyle);
	}

	
	@Override
	protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//		Log.e("widthMeasure", String.valueOf(widthMeasureSpec));
//		Log.e("heightM", String.valueOf(heightMeasureSpec));
//		Log.e("expandMeasure", String.valueOf(expandSpec));
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
