package com.hetao.ui.example;

import com.easemob.chat.EMChat;

import android.app.Application;

public class MyApp extends Application{
	@Override
	public void onCreate() {
		super.onCreate();
		
		//环信初始化
		EMChat.getInstance().init(this);
	}
}
