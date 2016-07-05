package com.example.shopping;

import java.security.PublicKey;
import java.text.AttributedCharacterIterator.Attribute;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

public class MyEditText extends EditText implements OnFocusChangeListener{
	private boolean ishasFoucs;
	private Context context;
	
	public MyEditText(Context context){
		super(context);
		setContext(context);
		init();
	}
	public MyEditText(Context context,AttributeSet attrs){
		super(context,attrs);
		setContext(context);
		init();
	}
	
	public MyEditText(Context context,AttributeSet attrs,int defStyle){
		super(context,attrs,defStyle);
		setContext(context);
		init();
	}
	
	public void init(){
		setOnFocusChangeListener(this);
	}
	
	private void setContext(Context context){
		this.context = context;
	}
	
	
	@Override
	public void onFocusChange(View v, boolean hasFoucs) {
		// TODO Auto-generated method stub
		ishasFoucs = hasFoucs;
		if(ishasFoucs){
			Intent intent = new Intent(context,FindShopActivity.class);
			context.startActivity(intent);
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
//		Paint paint = new Paint();
//		paint.setAntiAlias(true);
//		paint.setColor(Color.BLACK);
//		RectF rectf = new RectF();
//		canvas.drawRoundRect(rectf, 30, 30, paint);
	}
	
}
