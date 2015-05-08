package com.example.epaper;

import com.example.epaper.R;
import com.example.epaper.SimpleGestureFilter.SimpleGestureListener;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class tut2 extends Activity implements SimpleGestureListener{
	private SimpleGestureFilter detector;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gs2);
        detector = new SimpleGestureFilter(this,this);
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
    public boolean dispatchTouchEvent(MotionEvent me){
        // Call onTouchEvent of SimpleGestureFilter class
         this.detector.onTouchEvent(me);
       return super.dispatchTouchEvent(me);
    }
	@Override
	public void onSwipe(int direction) {
		// TODO Auto-generated method stub
		switch (direction) {  
	      case SimpleGestureFilter.SWIPE_LEFT :  Intent i = new Intent(getApplicationContext(),tut3.class);
	        										startActivity(i);
	                                                     break;
	      case SimpleGestureFilter.SWIPE_RIGHT :  Intent p = new Intent(getApplicationContext(),tut1.class);
			startActivity(p);
             break;
	      }
	}
	@Override
	public void onDoubleTap() {
		// TODO Auto-generated method stub
		
	}
}
