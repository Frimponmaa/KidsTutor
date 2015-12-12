package com.example.babylearn;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		 new Thread(new Runnable(){
				public void run(){
					try {
					//---simulate doing something lengthy---
					Thread.sleep(2000);
					
					//launch the actual activities
						startActivity(new Intent("com.example.babylearn.MainActivity"));
						
						
						} catch (InterruptedException e) {
							e.printStackTrace();
							}
								}
					}).start();
	      
	    }
	
	
}
