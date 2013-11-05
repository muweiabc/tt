package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	private AlertDialog dialog;
	
	
	private TimePickerDialog.OnTimeSetListener cb=new  TimePickerDialog.OnTimeSetListener(){

		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void ff(View view){
		Intent intent = new Intent(DashboardScreen.this, ServiceClass.class);
		PendingIntent pintent = PendingIntent.getService(DashboardScreen.this, 0, intent, 0);
		AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 30*1000, pintent);
		
		TimePickerDialog pick=new TimePickerDialog(this,cb,1,2,true);
		pick.show();
		AlarmManager manager=(AlarmManager) getSystemService(ALARM_SERVICE);
		manager.set(AlarmManager.RTC, 10000, null);
	}

}
