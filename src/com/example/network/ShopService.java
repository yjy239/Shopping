package com.example.network;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class ShopService extends Service{
	private NetworkBroadcast receiver;
	
	@Override
	public void onCreate(){
		Log.e("service","start");
		super.onCreate();
		register();
		
		Intent i = new Intent();
		i.setAction("com.example.network.START");
		sendBroadcast(i);
		
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void register(){
		receiver = new NetworkBroadcast();
		IntentFilter filter = new IntentFilter();
		filter.addAction("com.example.network.START");
		registerReceiver(receiver, filter);
		
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();
		unregister();
	}
	
	private void unregister(){
		unregisterReceiver(receiver);
	}
	
	
}
