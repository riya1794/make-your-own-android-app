package com.example.epaper;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class forgot extends Activity{
	EditText mail,name;
	Button submit;
	LoginData data1;
	

	  /** Your ad unit id. Replace with your actual ad unit id. */
	  private static final String AD_UNIT_ID = "ca-app-pub-4459827006092767/1070283739";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgot_pass);
		

	    // Add the AdView to the view hierarchy. The view will have no size until the ad is loaded.
	    // This code assumes you have a LinearLayout with attribute android:id="@+id/linear_layout"
	    // in your activity_main.xml.
	  
		TextView txa = (TextView)findViewById(R.id.textView1);
		Typeface custom_fonta = Typeface.createFromAsset(getAssets(), "fonts/Track.ttf");
		txa.setTypeface(custom_fonta);
		
		mail = (EditText)findViewById(R.id.editText1);
		name = (EditText)findViewById(R.id.editText2);
		
		submit = (Button)findViewById(R.id.button1);
		Button rot=(Button)findViewById(R.id.button2);
        Animation ra = new RotateAnimation(0.0f, 360.0f,
	            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
	            0.5f);
	    	//RotateAnimation ra =new RotateAnimation(0,15);
	        ra.setFillAfter(true);
	    	ra.setDuration(1000);
	    	ra.setRepeatCount(10000);
	    	rot.startAnimation(ra);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String getMail = mail.getText().toString();
				String getName = name.getText().toString();
				
				String GetName="";
				String GetMail="";
				data1 = new LoginData(getBaseContext());
				
				data1.open();
				Cursor c=data1.returnData();
				if(c.moveToFirst())
				{
					do{
						GetMail=c.getString(0);
						GetName=c.getString(1);
					}
					while(c.moveToNext());
					
					if((GetName.toString().equals(getName))&&(GetMail.toString().equals(getMail)))
					{
						Toast.makeText(getApplicationContext(), "Entered data is correct",Toast.LENGTH_SHORT).show();
						Intent i =new Intent(getApplicationContext(), Reset_pass.class);
						startActivity(i);
					
					}
					else
					{
						Toast.makeText(getApplicationContext(), "Invalid email/username",Toast.LENGTH_SHORT).show();
					}
					
				}
			}

			
			
		});
	}
	
	
}
