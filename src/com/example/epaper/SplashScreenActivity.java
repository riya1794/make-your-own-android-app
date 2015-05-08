package com.example.epaper;

import com.example.epaper.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
 
public class SplashScreenActivity extends Activity {
 
    // Splash screen timer
    private int SPLASH_TIME_OUT = 1000;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
            	
                            
                	Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
               
 
                
            }
        }, SPLASH_TIME_OUT);
    }
    
    
}