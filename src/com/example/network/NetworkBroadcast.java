package com.example.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class NetworkBroadcast extends BroadcastReceiver{
	private boolean isnetworkok;
	private boolean iswifiok;
	private boolean ismobileok;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.e("receive","here");
		if(intent.getAction().equals("com.example.network.START")){
				iswifiok = isWIFIConnected(context);
				if(iswifiok){
					Log.e("wifi", "ok");
					Toast.makeText(context, "wifi已连接", Toast.LENGTH_SHORT).show();
				}else{
					Log.e("wifi", "uc");
					ismobileok = isMobileConnected(context);
					if(ismobileok){
						Log.e("mobile", "c");
						Toast.makeText(context, "wifi不可用，以切换为3G或4G网络", Toast.LENGTH_SHORT).show();
					}else{
						Log.e("net", "uc");
						Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
					}
					
				}
		}
	}
	
	private boolean isNetWorkAvilable(Context context){
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo nt = cm.getActiveNetworkInfo();
		if(nt != null){
			return true;
		}
		return false;
	}
	
	private boolean isWIFIConnected(Context context){
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo WIFI = cm.getNetworkInfo(cm.TYPE_WIFI);
		if(WIFI != null){
			return WIFI.isAvailable();
		}
		return false;
	}
	
	private boolean isMobileConnected(Context context){
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mobile = cm.getNetworkInfo(cm.TYPE_MOBILE);
		if(mobile != null){
			return mobile.isAvailable();
		}
		return false;
	}

}
