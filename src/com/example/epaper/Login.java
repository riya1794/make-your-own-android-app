package com.example.epaper;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Login extends Activity {

	Button log,rot;
	EditText username,password;
	LoginData data;
	

	  /** Your ad unit id. Replace with your actual ad unit id. */
	  private static final String AD_UNIT_ID = "ca-app-pub-4459827006092767/1070283739";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		
		
		Intent i1 = new Intent(getBaseContext(),StartActivity.class); 
		  startService(i1);
		ActionBar actionbar = getActionBar();
	    actionbar.setDisplayHomeAsUpEnabled(true);
		TextView txa = (TextView)findViewById(R.id.textView1);
		Typeface custom_fonta = Typeface.createFromAsset(getAssets(), "fonts/Track.ttf");
		txa.setTypeface(custom_fonta);
		
		TextView t1 = (TextView)findViewById(R.id.TextView01);
		t1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(),forgot.class);
			startActivity(i);
			}
		});
		rot = (Button)findViewById(R.id.button4);
		log = (Button)findViewById(R.id.button1);
		username = (EditText)findViewById(R.id.editText1);
		password = (EditText)findViewById(R.id.editText2);
		password.setTypeface(Typeface.DEFAULT);
		password.setTransformationMethod(new PasswordTransformationMethod());
		Animation ra = new RotateAnimation(0.0f, 360.0f,
	            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
	            0.5f);
	    	//RotateAnimation ra =new RotateAnimation(0,15);
	        ra.setFillAfter(true);
	    	ra.setDuration(1000);
	    	ra.setRepeatCount(10000);
	    	rot.startAnimation(ra);
		log.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String getName = username.getText().toString();
				String getPassword = password.getText().toString();
				if (getName.matches("")) {
				    Toast.makeText(getApplicationContext(), "Name cannot be empty", Toast.LENGTH_SHORT).show();
				    return;
				}
				if (getPassword.matches("")) {
				    Toast.makeText(getApplicationContext(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
				    return;
				}
				String GetName="";
				String GetPassword="";
				data = new LoginData(getBaseContext());
				
				data.open();
				Cursor c=data.returnData();
				if(c.moveToFirst())
				{
					do{
						GetName=c.getString(1);
						GetPassword=c.getString(2);
					}
					while(c.moveToNext());
					
					if((GetName.toString().equals(getName))&&(GetPassword.toString().equals(getPassword)))
					{
						Toast.makeText(getApplicationContext(), "login sucessfully",Toast.LENGTH_SHORT).show();
						Intent i =new Intent(getApplicationContext(), StartActivity.class);
						startActivity(i);
					
					}
					else
					{
						Toast.makeText(getApplicationContext(), "invalid username/password",Toast.LENGTH_SHORT).show();
					}
					
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		//CreateMenu(menu);
		return true;
	}
	 public boolean onOptionsItemSelected(MenuItem item){
			
			return MenuChoice(item);
		}
    
	

	private boolean MenuChoice(MenuItem item)
	{
	switch (item.getItemId()){
	case 0:
		Toast.makeText(this,"You clicked on Home icon", Toast.LENGTH_SHORT).show();
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
		startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(startMain);
		return true;
	case 1:
		Toast.makeText(this,"You clikced on item2",Toast.LENGTH_SHORT).show();
	    return true;
	case 2:
		Toast.makeText(this, "You clicked on item 3", Toast.LENGTH_SHORT).show();
		return true;
	case 3:
		Toast.makeText(this,"You clicked on item 4", Toast.LENGTH_SHORT).show();
		return true;
	case 4:
		Toast.makeText(this, "You clicked on item 5", Toast.LENGTH_SHORT).show();
		return true;

	//The application icon is often used by applications to enable them to return to the main activity of the application
	//application may have several activities and you can use ht e application icon as a short cut for users to return directly to the main activity of your applciation
		
		
	case android.R.id.home:
		Toast.makeText(this,"You clicked on the Application icon",Toast.LENGTH_LONG).show();
		Intent i = new Intent(this,MainActivity.class);
	//The Intent.FLAG_ACTIVITY_CLEAR_TOP flag ensures that the series of activities in the back stack is cleared when the user clicks the application icon in the action bar.
		
	    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    startActivity(i);
	    return true;

	}
	return false;
	}
  



}
