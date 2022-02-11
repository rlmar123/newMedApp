package com.example.medication_app;


import android.app.AlertDialog;
import android.app.DialogFragment;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Locale;


public class CalendarActivity extends AppCompatActivity
{

   private FloatingActionButton add_calendar_fab = null;

   private int hour, minute;

   private Intent calIntent;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_calendar);
      
     // Intent intent = getIntent();


      //setOpeningFragment();
      add_calendar_fab = findViewById(R.id.add_calendar_fab);

      calIntent = new Intent(Intent.ACTION_INSERT);

      add_calendar_fab.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View view)
         {

            add_calendar_fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_green)));

            startTime();
            endTime();


         } // end onClick

      }); // end onClicklister

   } // end OnCreate


   private void startTime()
   {
      TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
      {
         @Override
         public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
         {

            Calendar startTime = Calendar.getInstance();

            hour = selectedHour;
            minute = selectedMinute;

            calIntent.setData(CalendarContract.Events.CONTENT_URI);
            calIntent.putExtra(CalendarContract.Events.TITLE, "PARTY");
            calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "MY CRIB");
            calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "BYOB");
            calIntent.putExtra(Intent.EXTRA_EMAIL, "test@yahoo.com, test2@yahoo.com, test3@yahoo.com");

            // get start time
            startTime.set(2012, 0, 29, hour, minute);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime.getTimeInMillis());

         }
      };

      // int style = AlertDialog.THEME_HOLO_DARK;

      TimePickerDialog timePickerDialog = new TimePickerDialog(CalendarActivity.this,AlertDialog.THEME_DEVICE_DEFAULT_DARK , onTimeSetListener, hour, minute, false);

      timePickerDialog.setTitle("Begin Time");

      timePickerDialog.show();

   }

   private void endTime()
   {
      TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
      {
         @Override
         public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
         {

            Calendar endTime = Calendar.getInstance();


            hour = selectedHour;
            minute = selectedMinute;

            calIntent.setData(CalendarContract.Events.CONTENT_URI);
            calIntent.putExtra(CalendarContract.Events.TITLE, "PARTY");
            calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "MY CRIB");
            calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "BYOB");
            calIntent.putExtra(Intent.EXTRA_EMAIL, "test@yahoo.com, test2@yahoo.com, test3@yahoo.com");


            // get start time
            endTime.set(2012, 0, 29, hour, minute);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());

            if(calIntent.resolveActivity(getPackageManager()) != null)
               startActivity(calIntent);

            else
               Toast.makeText(CalendarActivity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show();
            //   timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));

         }
      };

      // int style = AlertDialog.THEME_HOLO_DARK;

      TimePickerDialog timePickerDialog = new TimePickerDialog(CalendarActivity.this,AlertDialog.THEME_DEVICE_DEFAULT_DARK , onTimeSetListener, hour, minute, false);

      timePickerDialog.setTitle("End Time");

      timePickerDialog.show();

   }

} // end class