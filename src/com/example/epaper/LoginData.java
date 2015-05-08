package com.example.epaper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class LoginData {

	public static final String NAME="name";
	public static final String EMAIL="email";
	public static final String PASSWORD="password";
	public static final String LOCATION="loc";
	public static final String LONGITUDE="loq";
	public static final String NUMBER1="num1";
	public static final String NUMBER2="num2";
	public static final String NUMBER3="num3";
	public static final String NUMBER4="num4";
	public static final String LATITUTE="lat";
	public static final String TABLE_NAME="login";

	public static final String DATABASE="project";
	public static final int DATABASE_VERSION=1;
	public static final String CREATE_TABLE=
			"create table login(email text not null,name text not null,password text not null,loc text,loq text,lat text,num1 text,num2 text,num3 text,num4 text);";
	
			DataBaseHelper dbhelper;
	        Context ctx;
	        SQLiteDatabase db;
	        
	        public LoginData(Context ctx)
	        {
	        	this.ctx=ctx;
	        	dbhelper = new DataBaseHelper(ctx);
	        }
	        public LoginData open()
	        {
	        	db=dbhelper.getWritableDatabase();
	        	return this;
	        }
	        public void close()
	        {
	        	dbhelper.close();
	        }
	        public long insertData(String email,String name,String password){
	        	ContentValues content=new ContentValues();
	        	content.put(EMAIL,email);
	        	content.put(NAME,name);
	        	content.put(PASSWORD,password);
	       
	        	
	        	return db.insertOrThrow(TABLE_NAME,null,content);
	        	
	        }
	        public long updateData(String password){
	        	ContentValues content=new ContentValues();
	        	content.put(PASSWORD,password);
	        	
	        	return db.update(TABLE_NAME, content,null, null);
	        	
	        }
	        public long updateLoc(String Loc,String Lon,String Lat){
	        	ContentValues content=new ContentValues();
	        	content.put(LOCATION,Loc);
	        	content.put(LONGITUDE,Lon);
	        	content.put(LATITUTE,Lat);
	        	
	        	return db.update(TABLE_NAME, content, null, null);
	        	
	        }
	        public long updateNumber(String n1,String n2,String n3,String n4){
	        	ContentValues content=new ContentValues();
	        	content.put(NUMBER1,n1);
	        	content.put(NUMBER2,n2);
	        	content.put(NUMBER3,n3);
	        	content.put(NUMBER4,n4);
	        	return db.update(TABLE_NAME, content, null, null);
	        	
	        }
	        public Cursor returnData()
	        {
	        	return db.query(TABLE_NAME,new String[]{EMAIL,NAME,PASSWORD,LOCATION,LONGITUDE,LATITUTE,NUMBER1,NUMBER2,NUMBER3,NUMBER4},null,null,null,null,null);
	        }
	       
	        
	        private static class DataBaseHelper extends SQLiteOpenHelper
			{
				public DataBaseHelper(Context ctx){
					super(ctx,DATABASE,null,DATABASE_VERSION);
					// TODO Auto-generated constructor stub
					
				}

				@Override
				public void onCreate(SQLiteDatabase db) {
					// TODO Auto-generated method stub
					try{
						db.execSQL(CREATE_TABLE);
						
					}
					catch(SQLException e)
					{
						e.printStackTrace();
					}
				}

				@Override
				public void onUpgrade(SQLiteDatabase db, int oldVersion,
						int newVersion) {
					// TODO Auto-generated method stub
					db.execSQL("drop table if exists login");
					onCreate(db);
					
				}
			}
	        
}

