package com.example.mywidget;

import android.R.integer;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;

public class MyViewPager extends ViewPager{
	private Scroller scroller;
	private VelocityTracker vTracker;
	private final static int MOVEDISTANCE = 50;
	private int mLastX = 0;
	private int mLastY;
	private int mLastXIntercept = 0;
	private int mLastYIntercept = 0;
	
	public MyViewPager(Context context){
		super(context);
		init(context);
	}
	
	public MyViewPager(Context context,AttributeSet attrs){
		super(context, attrs);
		init(context);
	}
	
	private void init(Context context){
		scroller = new Scroller(context);
		vTracker = VelocityTracker.obtain();
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent event){
		boolean intercept = false;
		int x = (int) event.getX();
		int y = (int) event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			intercept = false;
			if(!scroller.isFinished()){
				scroller.abortAnimation();
				intercept = true;
			}
			break;
			
		case MotionEvent.ACTION_MOVE:
			int deltaX = x - mLastXIntercept;
			int deltaY = y - mLastXIntercept;
			if(Math.abs(deltaX) > Math.abs(deltaY)){
				intercept = true;
			}else{
				intercept = false;
			}
			break;
			
		case MotionEvent.ACTION_UP:
				intercept = true;
				break;
		default:
			break;
		}
		mLastX = x;
		mLastXIntercept = y;
		mLastY = y;
		mLastYIntercept = y;
		
		return intercept;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		vTracker.addMovement(event);
		int x = (int) event.getX();
		int y = (int) event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if(!scroller.isFinished()){
				scroller.abortAnimation();
			}
			break;
			
		case MotionEvent.ACTION_MOVE:
			int deltaX = x - mLastX;
			int deltaY = y - mLastY;
			scrollBy(-deltaX, 0);
			break;
			
		case MotionEvent.ACTION_UP:
				int scrollx = getScrollX();
				vTracker.computeCurrentVelocity(1000);
				final View view = getChildAt(1);
				int childwidth = view.getMeasuredWidth();
				int dx = childwidth - scrollx;
				pagerScroll(dx, 0);
				vTracker.clear();
			    break;
		default:
			break;
		}
		mLastX = x;
		mLastY = y;
		return true;
	}
	
	private void pagerScroll(int dx,int dy){
		final int screenwidth = getWidth();
		scroller.startScroll(getScrollX(), 0, dx, 0,500);
		invalidate();
	}
	
	@Override
	public void computeScroll(){
		if(scroller.computeScrollOffset()){
			scrollTo(scroller.getCurrX(), scroller.getCurrY());
			postInvalidate();
		}
	}
	
	@Override
	protected void onDetachedFromWindow() {//view资源回收
        vTracker.recycle();
        super.onDetachedFromWindow();
    }
	
	
}
