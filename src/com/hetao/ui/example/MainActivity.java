package com.hetao.ui.example;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;

import hetao.ui.controls.ChatView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    final ChatView chatView=new ChatView(this);
		
		LinearLayout layout = (LinearLayout) this.findViewById(R.id.chatcontaintor);
		layout.addView(chatView);
		LayoutParams l = chatView.getLayoutParams();
		l.height=LayoutParams.MATCH_PARENT;
		l.width =LayoutParams.MATCH_PARENT;
		chatView.setLayoutParams(l);
		
		final Activity activity=this;
		EMChatManager.getInstance().login("wxllzf","123456",new EMCallBack() {//回调
			@Override
			public void onSuccess() {
				
				activity.runOnUiThread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						EMGroupManager.getInstance().loadAllGroups();
				        EMChatManager.getInstance().loadAllConversations();
			
				        chatView.InitChat("dreamzoom",0);
				        
				        chatView.SendTextMessage("哈哈");
					}
					
				});
				
				
				
			}
		 
			@Override
			public void onProgress(int progress, String status) {
		 
			}
		 
			@Override
			public void onError(int code, String message) {
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_settings:
				SelectImage();
				break;
			default:
					break;
		}
		return false;	
	}
	
	public void SelectImage(){
		
	}

}
