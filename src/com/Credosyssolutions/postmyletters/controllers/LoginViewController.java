/* Copyright (C) CredosysSolutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Rahul Nair <rhlnair@gmail.com>, September 2014.
 */


package com.Credosyssolutions.postmyletters.controllers;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Credosyssolutions.postmyletters.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginViewController extends Activity {
	
	Button loginButton;
	TextView  signuptextview;
	EditText  username_editext;
	EditText  password_editext;
	TextView appNameTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		setContentView(R.layout.activity_login_view_controller);
		
        ActionBar actionBar = getActionBar();  //for higher version
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        
        actionBar.setDisplayShowCustomEnabled(true);
        View customView= getLayoutInflater().inflate(R.layout.action_bar_custom, null);
        actionBar.setCustomView(customView);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(145	,59	,144)));
		
		loginButton= (Button) findViewById(R.id.signin_button);
		signuptextview = (TextView) findViewById(R.id.signup_textview);
		appNameTextView = (TextView) findViewById(R.id.appName_actionbar_textview);
		username_editext = (EditText) findViewById(R.id.username_editText);
		password_editext = (EditText) findViewById(R.id.password_editText);
		

		
		
		username_editext.requestFocus();
		
		signuptextview.setTextColor(Color.rgb(145	,59	,144));

		Typeface appNameTypeFace = Typeface.createFromAsset(getAssets(),"fonts/journal.ttf");
		appNameTextView.setTypeface(appNameTypeFace);
		appNameTextView.setTextColor(Color.WHITE);
		
		loginButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		       // show rootviewcontroller
		    	String usernametxt = username_editext.getText().toString();
		    	String   passwordtxt = password_editext.getText().toString();
		    	
		    	
		    	if (usernametxt.length() > 0 && passwordtxt.length() > 0) {
		    		   ParseUser.logInInBackground(usernametxt, passwordtxt,
		                        new LogInCallback() {
		                      

									@Override
									public void done(ParseUser user,
											ParseException arg1) {
										// TODO Auto-generated method stub
										 if (user != null) {
			                                    // If user exist and authenticated, send user to Welcome.class
											 
											 
			                                    Intent intent = new Intent(
			                                            LoginViewController.this,
			                                            RootViewController.class);
			                                    startActivity(intent);
			                                    Toast.makeText(getApplicationContext(),
			                                            "Successfully Logged in",
			                                            Toast.LENGTH_LONG).show();
			                                    finish();
			                                } else {
			                                    Toast.makeText(
			                                            getApplicationContext(),
			                                            "Login Failed"+arg1.getCode(),
			                                            Toast.LENGTH_LONG).show();
			                                }
									}
		                        });					
		    		
		    		
				}
		    	
		    	
		    	
		    	
		    	
//		    	   Intent i = new Intent(LoginViewController.this, RootViewController.class);
//	                startActivity(i);
// 
//	                // close this activity
//	                finish();
		    }
		});
		
		
		signuptextview.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  // show signUpScreen
			 	   Intent i = new Intent(LoginViewController.this, SignupViewController.class);
	                startActivity(i);
	 
	             
				
			}
		});
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.login_view_controller, menu);
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
