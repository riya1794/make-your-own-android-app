package com.example.epaper;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class US extends Activity {
	Button toi,nav,ht,db,eco;
	ActionBar actionBar ;
	TextView sprate,pith;
	SeekBar speed,sdpitch;
	String rate,pit,x,y;
	final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.us);
        
        Button btn1 =(Button)findViewById(R.id.btnus1);
        Button btn2 =(Button)findViewById(R.id.btnus2);
        
        
        //RotateAnimation ra =new RotateAnimation(0, 15);
        //ra.setFillAfter(true);
        //ra.setDuration(1000);
        //for(int i=0;i<100000;i++){
        
        
        
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), readGuaradian.class);
				startActivity(i);
			}
		});
       
    
    
    btn2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(), readGerman1.class);
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
             //   Toast.makeText(getApplicationContext(), "home pressed" , Toast.LENGTH_LONG).show();
                return true;
            
            
            }

        }
        return super.onKeyDown(keyCode, event);
    }

}
