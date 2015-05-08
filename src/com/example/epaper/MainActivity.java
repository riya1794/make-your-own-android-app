package com.example.epaper;



import com.example.epaper.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button toi,nav,ht,db,eco;
	ActionBar actionBar ;
	TextView sprate,pith;
	SeekBar speed,sdpitch;
	String rate,pit,x,y;
	final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ht = (Button)findViewById(R.id.btn_ht);
        db = (Button)findViewById(R.id.btn_db);
        
        eco = (Button)findViewById(R.id.btn_eco);
        SpannableString s = new SpannableString("News Reader");
        s.setSpan(new TypefaceSpan("Rosemary.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Update the action bar title with the TypefaceSpan instance
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(s);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/Rosemary.ttf");
        
        ht.setTypeface(typeface);
        db.setTypeface(typeface);
        
        eco.setTypeface(typeface);
            
       
        
        ht.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Readht.class);
				startActivity(i);
			}
		});
        	
        db.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), Readdb.class);
				startActivity(i);
			}
		});
        
        

        eco.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),Readeco.class);
				startActivity(i);
			}
		});
        


        
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
                Intent intent = new Intent(getApplicationContext(),StartActivity.class);
                startActivity(intent);
                return true;
            
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    
}
