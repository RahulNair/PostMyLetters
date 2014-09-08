package com.Credosyssolutions.postmyletters.controllers;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.Credosyssolutions.postmyletters.R;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingListActivity;


public class RootViewController extends SlidingListActivity {
	private static final String tag = "ActionSheetDemoActivity";
	private int width;

	private WindowManager.LayoutParams params;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_view_controller);
        ActionBar actionBar = getActionBar();  //for higher version
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        
        actionBar.setDisplayShowCustomEnabled(true);
        View customView= getLayoutInflater().inflate(R.layout.action_bar_custom, null);
        actionBar.setCustomView(customView);
        
        
        setBehindContentView(R.layout.activity_slide_profile);
        getSlidingMenu().setBehindOffset(100);
        
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        Log.i(tag, "Height : "+metrics.heightPixels+" Width : "+width);
        
        params = getWindow().getAttributes();
		params.width = width;

       
        String[] values = new String[] { "Post My Letter","PostBox",
                "My Pen Pal's", "Find a Friend" };
      
              // Define a new Adapter
              // First parameter - Context
              // Second parameter - Layout for the row
              // Third - the Array of data
      
              ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                      android.R.layout.simple_list_item_1, values);
      
      
              // Assign adapter to List
              setListAdapter(adapter); 
     
        
    
    }
       
   
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.root_view_controller, menu);
        return true;
    }

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
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
          
          super.onListItemClick(l, v, position, id);
  
             // ListView Clicked item index
             int itemPosition     = position;
             
             // ListView Clicked item value
             String  itemValue    = (String) l.getItemAtPosition(position);
           
             Intent intent = null;
             switch (itemPosition) {
			case 0:
				showActionSheet(this.getListView());
				//intent = new Intent(RootViewController.this, PostBoxViewController.class);
				break;

		
			case 1:
				intent = new Intent(RootViewController.this, PostBoxViewController.class);
				break;
				
			case 2:
				intent = new Intent(RootViewController.this, PenPalsViewController.class);
				break;
				
			case 3:
				intent = new Intent(RootViewController.this, FetchFriendsViewController.class);
				break;	
				

			default:
				break;
				
				
				
			}
             if (intent != null) {
            	 startActivity(intent);
			}
            
				

                
             
    }
    public void showActionSheet(View v) {
    	final Dialog myDialog = new Dialog(RootViewController.this, R.style.CustomTheme);
		myDialog.setContentView(R.layout.actionsheet);

		TextView sendPostCard_textView = (TextView) myDialog.findViewById(R.id.sendPostCard_textView);
		sendPostCard_textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				myDialog.dismiss();
			Intent	intent = new Intent(RootViewController.this, WriteRawLetterViewController.class);
			 startActivity(intent);
			}
		});

		TextView sendLetter = (TextView) myDialog.findViewById(R.id.sendLetter_textView);
		sendLetter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				myDialog.dismiss();
				Intent	intent = new Intent(RootViewController.this, WriteRawLetterViewController.class);
				 startActivity(intent);
			}
		});

		myDialog.getWindow().getAttributes().width = width;
		Log.i(tag, "Action Sheet created");
		
		myDialog.show();
		myDialog.getWindow().setGravity(Gravity.BOTTOM);
    }

}
