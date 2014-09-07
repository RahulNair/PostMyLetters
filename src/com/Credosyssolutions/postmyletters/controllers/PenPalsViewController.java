package com.Credosyssolutions.postmyletters.controllers;

import com.Credosyssolutions.postmyletters.R;
import com.Credosyssolutions.postmyletters.R.id;
import com.Credosyssolutions.postmyletters.R.layout;
import com.Credosyssolutions.postmyletters.R.menu;
import com.Credosyssolutions.postmyletters.DataModel.PostBoxAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class PenPalsViewController extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_box_view_controller);
		  String[] values = new String[] { "rhlnair", "TimSteve_98", "summer69",
	                "lizRay", "kiveRoss", "lionelLimes","AlexStan" };
	      
	              // Define a new Adapter
	              // First parameter - Context
	              // Second parameter - Layout for the row
	              // Third - the Array of data
	      
	             // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	             //         android.R.layout.simple_list_item_1, values);
	      
	              PostBoxAdapter adapter = new PostBoxAdapter(this, values,true);
	              // Assign adapter to List
	              setListAdapter(adapter); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post_box_view_controller, menu);
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
}
