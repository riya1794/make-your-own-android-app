package com.example.epaper;



import java.io.IOException;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.example.epaper.R;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

public class help extends Activity{
	private WebView browser; 
	ImageButton bttn ;
	SharedPreferences prf1;
	int rec = 0;
	TextToSpeech ttobj;
	int x=12,y;
	float z= (float)12.0;
	ProgressDialog mProgressDialog;
	final Context myApp = this;  

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gs2);
        ImageButton btn1 = (ImageButton)findViewById(R.id.imageLink);
        ImageButton btn2 = (ImageButton)findViewById(R.id.imageInstall);
        ImageButton btn3 = (ImageButton)findViewById(R.id.imageNext);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.google.android.tts"));
				startActivity(intent);
			}
		});
        
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent install = new Intent();
                install.setAction(
                        TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(install);
			}
		});
        btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), tut3.class);
		        startActivity(i);
			}
		});
    }
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
}
