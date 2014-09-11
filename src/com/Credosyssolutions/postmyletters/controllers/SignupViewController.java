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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Credosyssolutions.postmyletters.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupViewController extends Activity {
	TextView appNameTextView;
	
	Button signUpButton;
	EditText  email_editext;
	EditText  username_editext;
	EditText  password_editext;
	EditText  confirmpassword_editext;
	
public void registerNewUser() {
	ParseUser newuser =  new ParseUser();
	newuser.setUsername(email_editext.getText().toString());
	newuser.setEmail(email_editext.getText().toString());
	newuser.setPassword(password_editext.getText().toString());
	newuser.put("soft_username", username_editext.getText().toString());
	newuser.signUpInBackground(new SignUpCallback() {
		
		@Override
		public void done(ParseException exception) {
			// TODO Auto-generated method stub
			if (exception == null) {
				 Toast.makeText(
                         getApplicationContext(),
                         "Confirmation mail sent please confirm it to sign in ",
                         Toast.LENGTH_LONG).show();
				 
				 finish();
				
			}else {
				System.out.println("----%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% user"+exception.getCode());	

				 Toast.makeText(
                         getApplicationContext(),
                         "Error occurred while registering",
                         Toast.LENGTH_LONG).show();
				 
				 
			}
			
		}
	});
}

public Boolean checkPasswordsMatch() {
	if (password_editext.getText().toString().equals(confirmpassword_editext.getText().toString())) {
		return true;
	}else {
		Toast.makeText(
                getApplicationContext(),
                "Passwords don't match",
                Toast.LENGTH_LONG).show();	

		return false;
	}
}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup_view_controller);
		ActionBar actionBar = getActionBar();  //for higher version
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);

		actionBar.setDisplayShowCustomEnabled(true);
		View customView= getLayoutInflater().inflate(R.layout.action_bar_custom, null);
		actionBar.setCustomView(customView);
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(145	,59	,144)));
		
		appNameTextView = (TextView) findViewById(R.id.appName_actionbar_textview);
		
		signUpButton= (Button) findViewById(R.id.signup_button);
		email_editext = (EditText) findViewById(R.id.email_signup_editText);
		username_editext = (EditText) findViewById(R.id.username_signup_editText);
		password_editext = (EditText) findViewById(R.id.password_signup_editText);
		confirmpassword_editext = (EditText) findViewById(R.id.confirmpassword_signup_editText1);

		
		Typeface appNameTypeFace = Typeface.createFromAsset(getAssets(),"fonts/journal.ttf");
		appNameTextView.setTypeface(appNameTypeFace);
		appNameTextView.setTextColor(Color.WHITE);
		
		
		
		
		
		signUpButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		       // show rootviewcontroller
		    	String usernametxt = username_editext.getText().toString();
		    	String   passwordtxt = password_editext.getText().toString();
		    	String confirmpasswordtext = confirmpassword_editext.getText().toString();
		    	String   emailtext = email_editext.getText().toString();
		    	
		    	if (usernametxt.length() > 0 && passwordtxt.length() > 0 && confirmpasswordtext.length() > 0 &&  emailtext.length() > 0 ) {
		    		   		if (checkPasswordsMatch()) {
		    		   			registerNewUser();
							}	
		    		
		    		
				}
		    }
		});
		
		
		

	}



	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent i = new Intent(SignupViewController.this, LoginViewController.class);
		startActivity(i);

		// close this activity
		finish();
	}

	
}
