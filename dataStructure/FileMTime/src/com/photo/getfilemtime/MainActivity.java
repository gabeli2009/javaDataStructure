package com.photo.getfilemtime;

import android.app.Activity;
import android.os.Bundle;
 

public class MainActivity extends  Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final String _rPath = FExternalStorage.getSdCardPath();
		new Thread(){
			public void run(){
//				ListSdFiles _lt = new ListSdFiles();
//				_lt.listByQueue(_rPath);
				
				PhotoProviderList _ppl = new PhotoProviderList();
				_ppl.query(MainActivity.this);
			}
		}.start();
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}