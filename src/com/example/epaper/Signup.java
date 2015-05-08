package com.example.epaper;



import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Signup extends Activity {
	
	
	Button submit;
	EditText email_id,username,password;
	LoginData data;
	final Context ctx=this;
	

	 /** Your ad unit id. Replace with your actual ad unit id. */
	 private static final String AD_UNIT_ID = "ca-app-pub-4459827006092767/1070283739";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		
		AlertDialog.Builder builder1 = new AlertDialog.Builder(ctx);
        builder1.setMessage("Please visit HELP option to get more information about the features of this application");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Ok I got it!",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	//Toast.makeText(getBaseContext(),"Ok I got it!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        
        AlertDialog alert11 = builder1.create();
        alert11.setCanceledOnTouchOutside(false);
        alert11.show();
		ActionBar actionbar = getActionBar();
	    actionbar.setDisplayHomeAsUpEnabled(true);
		TextView txa = (TextView)findViewById(R.id.textView1);
		Typeface custom_fonta = Typeface.createFromAsset(getAssets(), "fonts/Track.ttf");
		txa.setTypeface(custom_fonta);
		
		submit = (Button)findViewById(R.id.button1);
		email_id = (EditText)findViewById(R.id.editText1);
		username = (EditText)findViewById(R.id.editText2);
		password = (EditText)findViewById(R.id.editText3);
		password.setTypeface(Typeface.DEFAULT);
		password.setTransformationMethod(new PasswordTransformationMethod());
		
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String getEmailID  = email_id.getText().toString();
				String getName = username.getText().toString();
				String getPassword = password.getText().toString();
				if (getEmailID.matches("")) {
				    Toast.makeText(getApplicationContext(), "Email cannot be empty", Toast.LENGTH_SHORT).show();
				    return;
				}
				if (getName.matches("")) {
				    Toast.makeText(getApplicationContext(), "Name cannot be empty", Toast.LENGTH_SHORT).show();
				    return;
				}
				if (getPassword.matches("")) {
				    Toast.makeText(getApplicationContext(), "password cannot be empty", Toast.LENGTH_SHORT).show();
				    return;
				}
				
				data = new LoginData(getBaseContext());
				
				data.open();
				data.insertData(getEmailID,getName,getPassword);
				data.close();
				
				Toast.makeText(getBaseContext(),"Data Submitted Sucessfully", Toast.LENGTH_SHORT).show();
				
				
	            
	            
				
				Intent i =new Intent(getApplicationContext(), Login.class);
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

