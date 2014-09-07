package com.Credosyssolutions.postmyletters.controllers;

import com.Credosyssolutions.postmyletters.R;
import com.Credosyssolutions.postmyletters.R.id;
import com.Credosyssolutions.postmyletters.R.layout;
import com.Credosyssolutions.postmyletters.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginViewController extends Activity {
	
	Button loginButton;
	TextView  signuptextview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_view_controller);
		loginButton= (Button) findViewById(R.id.signin_button);
		signuptextview = (TextView) findViewById(R.id.signup_textview);
		
		loginButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		       // show rootviewcontroller
		    	
		    	   Intent i = new Intent(LoginViewController.this, RootViewController.class);
	                startActivity(i);
	 
	                // close this activity
	                finish();
		    }
		});
		
		
		signuptextview.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  // show signUpScreen
			 	   Intent i = new Intent(LoginViewController.this, SignupViewController.class);
	                startActivity(i);
	 
	                // close this activity
	                finish();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_view_controller, menu);
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
