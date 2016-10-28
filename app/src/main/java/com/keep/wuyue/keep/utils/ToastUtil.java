package com.keep.wuyue.keep.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {

	public static void ToastL(Context context, String content){
		Toast.makeText(context, content, Toast.LENGTH_LONG).show();
	}
	
	public static void ToastS(Context context,String content){
		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
	}
}