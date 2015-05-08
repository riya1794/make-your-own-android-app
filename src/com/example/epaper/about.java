package com.example.epaper;

import com.example.epaper.R;
import com.example.epaper.SimpleGestureFilter.SimpleGestureListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;

public class about extends Activity implements SimpleGestureListener{
	private SimpleGestureFilter detector;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        detector = new SimpleGestureFilter(this,this);
        
       
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
	      case SimpleGestureFilter.SWIPE_LEFT :  Intent i = new Intent(getApplicationContext(),StartActivity.class);
	        										startActivity(i);
	                                                     break;
	      case SimpleGestureFilter.SWIPE_RIGHT :  Intent p = new Intent(getApplicationContext(),tut3.class);
			startActivity(p);
               break;
	      }
	}
	@Override
	public void onDoubleTap() {
		// TODO Auto-generated method stub
		
	}
	

}
