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
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.Credosyssolutions.postmyletters.R;
import com.parse.Parse;
import com.parse.ParseUser;

public class SplashViewController extends Activity {

	// Splash screen timer
	private static int SPLASH_TIME_OUT = 3000;
	final int totalProgressTime = 100;
	TextView appNameTextView ;
	ProgressBar splashProgressBar;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_view_controller);

		appNameTextView = (TextView) findViewById(R.id.appNameTextView);
		splashProgressBar =  (ProgressBar) findViewById(R.id.splash_progressBar);;

		final float[] roundedCorners = new float[] { 2, 2, 2, 2, 2, 2, 2, 2 };
		ShapeDrawable	pgDrawable = new ShapeDrawable(new RoundRectShape(roundedCorners, null,null));

		pgDrawable.getPaint().setColor(Color.rgb(145,59	,144));
		ClipDrawable progress = new ClipDrawable(pgDrawable, Gravity.LEFT, ClipDrawable.HORIZONTAL);
		splashProgressBar.setProgressDrawable(progress);   
		splashProgressBar.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.progress_horizontal));
		splashProgressBar.setProgress(45);



		Typeface appNameTypeFace = Typeface.createFromAsset(getAssets(),"fonts/journal.ttf");
		appNameTextView.setTypeface(appNameTypeFace);
		appNameTextView.setTextColor(Color.rgb(145	,59	,144));

		//		Parse.initialize(this, "ikCHpUnuiBkVeAxkYI0IRWGsoesrs3SsO5Ah1ezV", "ohM5yMC8aHQwlAJSshOjD3TA0Qebgk8PjvqA4B8f");

		Parse.initialize(SplashViewController.this, "ikCHpUnuiBkVeAxkYI0IRWGsoesrs3SsO5Ah1ezV", "ohM5yMC8aHQwlAJSshOjD3TA0Qebgk8PjvqA4B8f");

		final Thread progressThread = new Thread(){

			@Override
			public void run(){
				System.out.println("%%%%%%%%%%%");

				int jumpTime = 0;
				while(jumpTime < SPLASH_TIME_OUT){
					try {
						sleep(200);
						jumpTime += 5;
						splashProgressBar.setProgress(jumpTime);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				
			}
		};
		progressThread.start();


		new Handler().postDelayed(new Runnable() {
			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */
			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity
				Intent i = new Intent(SplashViewController.this, LoginViewController.class);
				startActivity(i);

				// close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);



		//		if (ParseUser.getCurrentUser() == null) {
		//			//show Loginscreen
		//			Intent i = new Intent(SplashViewController.this, LoginViewController.class);
		//			startActivity(i);
		//
		//			// close this activity
		//			//finish();
		//		}else{
		//
		//			new Handler().postDelayed(new Runnable() {
		//				/*
		//				 * Showing splash screen with a timer. This will be useful when you
		//				 * want to show case your app logo / company
		//				 */
		//				@Override
		//				public void run() {
		//					// This method will be executed once the timer is over
		//					// Start your app main activity
		//					//					Intent i = new Intent(SplashViewController.this, RootViewController.class);
		//					//					startActivity(i);
		//
		//					// close this activity
		//					//finish();
		//				}
		//			}, SPLASH_TIME_OUT);
		//
		//
		//		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_view_controller, menu);
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
