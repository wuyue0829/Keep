package com.keep.wuyue.keep.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollecor {
	public static List<Activity> acticities = new ArrayList<Activity>();
	
	public static void addActivity(Activity activity){
		acticities.add(activity);
	}
	
	public static void removeActivity(Activity activity){
		acticities.remove(activity);
	}
	
	public static void finishAll(){
		for(Activity activity2:acticities){
			if(! activity2.isFinishing()){
				activity2.finish();
			}
		}
	}
}