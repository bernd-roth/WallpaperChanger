package at.wallpaperchanger;

import android.support.v7.app.ActionBarActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends ActionBarActivity {
	private NumberPicker np;
	private PendingIntent alarmIntent;
	private AlarmManager alarmMgr;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		np = (NumberPicker) findViewById(R.id.numberPicker1);
		np.setMinValue(1);
		np.setMaxValue(1440);
		np.setWrapSelectorWheel(true);
		np.setValue(1);
	}
	
	public void startButton(View view){
		Button startstop = (Button)view;
		if(startstop.getText().toString().equals("Start")){
			alarmMgr = (AlarmManager) getBaseContext().getSystemService(Context.ALARM_SERVICE);
			Intent intent = new Intent(getBaseContext(), Receiver.class);
			alarmIntent = PendingIntent.getBroadcast(getBaseContext(), 0, intent, 0);
			alarmMgr.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, 0, np.getValue()*1000, alarmIntent);
		}
	}
	
	public void endButton(View view){
		Button startstop = (Button)view;
		if(startstop.getText().toString().equals("Stop")){
			alarmMgr = (AlarmManager) getBaseContext().getSystemService(Context.ALARM_SERVICE);
			Intent intent = new Intent(getBaseContext(), Receiver.class);
			alarmIntent = PendingIntent.getBroadcast(getBaseContext(), 0, intent, 0);
			alarmMgr.cancel(alarmIntent);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}