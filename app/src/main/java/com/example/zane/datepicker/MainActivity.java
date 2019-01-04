package com.example.zane.datepicker;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttons();
	}

	private void buttons() {
		Button btn = findViewById(R.id.btn_date);

		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DialogFragment dialogFragment = new DatePickerFragment();
				dialogFragment.show(getSupportFragmentManager(), "datePicker");
			}
		});

		Button time = findViewById(R.id.btn_time);
		time.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DialogFragment dialogFragment = new TimePickerFragment();
				dialogFragment.show(getSupportFragmentManager(), "timePicker");
			}
		});
	}

	public void processDatePickerResult(int year, int month, int day) {
		String month_string = Integer.toString(month+1);
		String day_string = Integer.toString(day);
		String year_string = Integer.toString(year);
		String dateMessage = (month_string +
						"/" + day_string + "/" + year_string);

		Toast.makeText(this, "Date: " + dateMessage,
						Toast.LENGTH_SHORT).show();
	}

	public void processTimePickerResult(int hour, int minute){
		String hourString = String.valueOf(hour);
		String minuteString = String.valueOf(minute);

		String result = "Time: " + hourString + ":" + minuteString;

		Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	}

}
