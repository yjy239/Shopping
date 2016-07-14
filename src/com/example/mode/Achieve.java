package com.example.mode;

import java.util.Collection;

import android.graphics.Path.FillType;

public class Achieve {
	public static <T> Collection<T> 
	fill(Collection<T> coll,achievement<T> achieve,int n){
		for(int i = 0;i < n;i++){
			coll.add(achieve.next());
		}
		return coll;
	}
}
