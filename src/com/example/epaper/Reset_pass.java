package com.example.epaper;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Reset_pass extends Activity {
	
	EditText pass,cpass;
	String spassword,scpassword;
	Button sub;
	public LoginData data;
	public SQLiteDatabase db;
	

	  /** Your ad unit id. Replace with your actual ad unit id. */
	  private static final String AD_UNIT_ID = "ca-app-pub-4459827006092767/1070283739";
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.reset);
	        
	       

		    // Start loading the ad in the background.
		   
	        ActionBar actionbar = getActionBar();
		    actionbar.setDisplayHomeAsUpEnabled(true);
	        TextView txa = (TextView)findViewById(R.id.textView1);
			Typeface custom_fonta = Typeface.createFromAsset(getAssets(), "fonts/Track.ttf");
			txa.setTypeface(custom_fonta);
	        pass=(EditText)findViewById(R.id.editText1);
	        cpass=(EditText)findViewById(R.id.editText2);
	        sub=(Button)findViewById(R.id.b1);
	        Button rot=(Button)findViewById(R.id.button1);
	        Animation ra = new RotateAnimation(0.0f, 360.0f,
		            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
		            0.5f);
		    	//RotateAnimation ra =new RotateAnimation(0,15);
		        ra.setFillAfter(true);
		    	ra.setDuration(1500);
		    	ra.setRepeatCount(10000);
		    	rot.startAnimation(ra);
	 }
	 public  void  enter( View v) {
			
		 	spassword=pass.getText().toString();
			scpassword=cpass.getText().toString();
			if(spassword.length()>0 )
			{
			if(spassword.equals(scpassword))
			{
			data = new LoginData(getBaseContext());
			//saveData();
			data.open();
			
			data.updateData(spassword);
				Toast.makeText(this,scpassword, Toast.LENGTH_LONG).show();
				data.close();
				Intent inserts=new Intent(getApplicationContext(),Login.class);
				startActivity(inserts);
				finish();
			}
			else 
			{
				Toast.makeText(this, "Both Password not match", Toast.LENGTH_LONG).show();
			}
			}
			else
			{
			AlertDialog.Builder alertBuilder=new AlertDialog.Builder(Reset_pass.this);
			alertBuilder.setTitle("Invalid Data");
			alertBuilder.setMessage("Please, Enter valid data");
			alertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which)
			{
			dialog.cancel();
			}
			});
			alertBuilder.create().show();
			}
			}
	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			
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

