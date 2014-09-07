package com.Credosyssolutions.postmyletters.controllers;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;

import com.Credosyssolutions.postmyletters.R;

public class WriteRawLetterViewController extends Activity {
EditText content_edittext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_raw_letter_view_controller);
		 ActionBar actionBar = getActionBar();  //for higher version
	        actionBar.setDisplayShowHomeEnabled(false);
	        actionBar.setDisplayShowTitleEnabled(false);
	        
	        actionBar.setDisplayShowCustomEnabled(true);
	        View customView= getLayoutInflater().inflate(R.layout.action_bar_custom, null);
	        actionBar.setCustomView(customView);
		
		
		content_edittext = (EditText) findViewById(R.id.content_editText);
		content_edittext.setId(1);
		
		OnTouchListener touchListener = new View.OnTouchListener(){
		    public boolean onTouch(final View v, final MotionEvent motionEvent){
		        if(v.getId() == 1){
		            v.getParent().requestDisallowInterceptTouchEvent(true);
		            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
		                case MotionEvent.ACTION_UP:
		                    v.getParent().requestDisallowInterceptTouchEvent(false);
		                break;
		            }
		        }
		        return false;
		    }
		};
		
		content_edittext.setOnTouchListener(touchListener);


	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater()
//				.inflate(R.menu.write_raw_letter_view_controller, menu);
//		return true;
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
