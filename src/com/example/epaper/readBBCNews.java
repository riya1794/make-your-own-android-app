package com.example.epaper;

import java.io.IOException;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;

public class readBBCNews extends Activity{
	
	private WebView browser;
	ImageButton bttn ;
	SharedPreferences prf1;
	int x=12,y;
	int rec=0;
	float z=(float) 12.0;
	TextToSpeech ttobj;
	ProgressDialog mProgressDialog;
	final Context myApp = this; 
	   String url = "http://www.bbc.com/news";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_db);
        
        browser = (WebView)findViewById(R.id.webdb);
        browser.setWebViewClient(new MyBrowser());
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.loadUrl(url);
        new Sound().onStart();
        
        /*bttn = (ImageButton) findViewById(R.id.playeco);
        bttn.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				// Execute Title AsyncTask
				new Click().execute();
			} 
		});*/
        prf1 = getSharedPreferences("My_Details",Context.MODE_PRIVATE);
        final String getspeech = prf1.getString("1","");
        //final String getpitch = prf1.getString("2","");
        
        //x = Integer.parseInt(getspeech);
        z=(float)x/(float)10.0;
        //y = Integer.parseInt(getpitch); 
    }
    
    
     private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
           view.loadUrl(url);
           return true;
        }
     }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private class Click extends AsyncTask<Void, Void, Void> {
		String desc;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = new ProgressDialog(readBBCNews.this);
			mProgressDialog.setTitle("Speak");
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			mProgressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {

				// Connect to the web site
				try {
					// Connect to the web site
					Document document = Jsoup.connect(browser.getUrl()).get();
					// Using Elements to get the Meta data
					Elements description = document
							.select("div[class=story-body__inner]");
					// Locate the content attribute
					String middesc = description.toString();
					 desc = Jsoup.parse(middesc).text();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			//ttobj.setPitch((float)x);
			
			if(desc.isEmpty()) {
				 new AlertDialog.Builder(myApp)  
	             .setTitle("Error")  
	             .setMessage("No article selected. Select an article to listen news")  
	             .setPositiveButton(android.R.string.ok, null)  
	         .setCancelable(false)  
	         .create()  
	         .show();
			 }
			ttobj.speak(desc, TextToSpeech.QUEUE_FLUSH, null);  
			mProgressDialog.dismiss();
		}
	}
    private class Sound  {
    	public void onStart(){
    		ttobj=new TextToSpeech(getApplicationContext(),
                    new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR){
                                ttobj.setLanguage(Locale.ENGLISH);
                            }
                        }
                    }); 
        }
        
        public void onPause(){
            if(ttobj !=null){
                ttobj.stop();
                ttobj.shutdown();
            }
           
        }

		
	}
    
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN){
            switch(keyCode)
            {
            case KeyEvent.KEYCODE_BACK:
                if(browser.canGoBack()){
                	ttobj.stop();
                	new Sound().onStart();
                    browser.goBack();
                    
                }else{
                    finish();
                }
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_home:
            	ttobj.stop();
            	new Sound().onStart();
                Intent i = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(i);
                return true;
            case R.id.action_sound:
            	rec++;
            	if(rec%2==0){
            		ttobj.stop();
                	new Sound().onStart();
            	}
            	else{
            		new Click().execute();
            	}
            	
                return true;
            case R.id.action_settings:
            	Intent itent = new Intent();
            	itent.setAction("com.android.settings.TTS_SETTINGS");
            	itent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            	startActivity(itent);
            case R.id.action_help:
            	Intent t = new Intent(getApplicationContext(), help.class);
                startActivity(t);
            	return true;
            case R.id.action_set:
            	ttobj.stop();
            	new Sound().onStart();
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
