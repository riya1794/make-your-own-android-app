package com.example.epaper;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ImageView.ScaleType;
import android.widget.SeekBar;
import android.widget.TextView;

public class StartActivity extends Activity{
	Button toi,nav,ht,db,eco;
	ActionBar actionBar ;
	TextView sprate,pith;
	SeekBar speed,sdpitch;
	String rate,pit,x,y;
	final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries);
        
        ImageButton img1 =(ImageButton)findViewById(R.id.imageBtn1);
        ImageButton img2 =(ImageButton)findViewById(R.id.imageBtn2);
        ImageButton img3 =(ImageButton)findViewById(R.id.imageBtn3);
        ImageButton img4 =(ImageButton)findViewById(R.id.imageBtn4);
        	
        
        //RotateAnimation ra =new RotateAnimation(0, 15);
        //ra.setFillAfter(true);
        //ra.setDuration(1000);
        //for(int i=0;i<100000;i++){
        Animation ra = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        	//RotateAnimation ra =new RotateAnimation(0,15);
            ra.setFillAfter(true);
        	ra.setDuration(1500);
        	ra.setRepeatCount(10000);
        	img1.startAnimation(ra);
        	ra.setDuration(1500);
        	img2.startAnimation(ra);
        	ra.setDuration(1500);
        	img3.startAnimation(ra);
        	ra.setDuration(1500);
        	img4.startAnimation(ra);
        //}
        	  final String PREFS_NAME = "MyPrefsFile";

              SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

          	
              if (settings.getBoolean("my_first_time", true)) {
                  //the app is being launched for first time, do something        
                  //Log.d("Comments", "First time");
              	Intent i = new Intent(getApplicationContext(), tut1.class);
                  startActivity(i);
              	// first time task

                  // record the fact that the app has been started at least once
                  settings.edit().putBoolean("my_first_time", false).commit(); 
              }

              else{
        img1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
		});
        img2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), australians.class);
				startActivity(i);
			}
		});
        img3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), US.class);
				startActivity(i);
			}
		});
        img4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), englands.class);
				startActivity(i);
			}
		});
              }
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_home:
                Intent i = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(i);
                return true;
            case R.id.action_sound:
                return true;
            case R.id.action_help:
            	Intent t = new Intent(getApplicationContext(), help.class);
                startActivity(t);
            	return true;
            case R.id.action_settings:
            	Intent itent = new Intent();
            	itent.setAction("com.android.settings.TTS_SETTINGS");
            	itent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            	startActivity(itent);
            	return true;
            case R.id.action_set:
            	Intent intent = new Intent();
            	intent.setAction("com.android.settings.TTS_SETTINGS");
            	intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            	startActivity(intent);
            	return true;   
            default:
                return super.onOptionsItemSelected(item);
        }
    }
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
   
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch(keyCode)
            {
            case KeyEvent.KEYCODE_BACK:
            	finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
