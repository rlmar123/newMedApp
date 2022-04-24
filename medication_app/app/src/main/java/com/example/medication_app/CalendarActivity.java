package com.example.medication_app;


import android.app.AlertDialog;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class CalendarActivity extends AppCompatActivity implements View.OnClickListener
{
   private Button add_end_button = null;
   private Button add_begin_button = null;
   private Button confirm_button = null;

   private TextInputEditText appointment_title;
   private TextInputEditText appointment_location;
   private TextInputEditText appointment_description;
   private TextInputEditText appointment_begin_date;
   private TextInputEditText appointment_end_date;

   private CardView cardView;

   private int begin_hour, begin_minute;
   private int end_hour, end_minute;

   private Intent calIntent;

   private Date begin_date;
   private Date end_date;

   private boolean flag = false;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_calendar);
      setTitle(R.string.appt_activity);

      appointment_title = findViewById(R.id.appointment_title);
      appointment_location = findViewById(R.id.appointment_location);
      appointment_description = findViewById(R.id.appointment_description);
      appointment_begin_date = findViewById(R.id.appointment_begin_date);
      appointment_end_date = findViewById(R.id.appointment_end_date);

      confirm_button = findViewById(R.id.confirm_button);

      add_begin_button = findViewById(R.id.add_begin_date);
      add_end_button = findViewById(R.id.add_end_date);
      cardView = findViewById(R.id.card_view);

      add_begin_button.setVisibility(View.INVISIBLE);
      add_end_button.setVisibility(View.INVISIBLE);

      calIntent = new Intent(Intent.ACTION_INSERT);

      confirm_button.setOnClickListener(this);
      add_begin_button.setOnClickListener(this);
      add_end_button.setOnClickListener(this);

   } // end OnCreate


   private void startTime()
   {
      TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
      {
         @Override
         public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
         {
            Calendar startTime = Calendar.getInstance();

            begin_hour = selectedHour;
            begin_minute = selectedMinute;

            // get start time
            startTime.set(2012, 0, 29, begin_hour, begin_minute);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime.getTimeInMillis());

            // add end button slides in right
            AppAnimation.theAnimation(CalendarActivity.this, add_end_button, CONSTANTS.ANIMATION_IN_RIGHT);
            add_end_button.setVisibility(View.VISIBLE);

            // add begin button slides out left
            AppAnimation.theAnimation(CalendarActivity.this, add_begin_button, CONSTANTS.ANIMATION_OUT_LEFT);
            add_begin_button.setVisibility(View.INVISIBLE);


         }
      };

      // int style = AlertDialog.THEME_HOLO_DARK;
      TimePickerDialog timePickerDialog = new TimePickerDialog(CalendarActivity.this,AlertDialog.THEME_DEVICE_DEFAULT_DARK , onTimeSetListener, begin_hour, begin_minute, false);
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

            end_hour = selectedHour;
            end_minute = selectedMinute;

            // get end time
            endTime.set(2012, 0, 29, end_hour, end_minute);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());

            if(calIntent.resolveActivity(getPackageManager()) != null)
            {
               startActivity(calIntent);
               finish();
            }

            else
            {
               Toast.makeText(CalendarActivity.this, "Please select a begin date", Toast.LENGTH_SHORT).show();
               add_begin_button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_red)));
               add_end_button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_blue)));
            }

         }
      };

      // int style = AlertDialog.THEME_HOLO_DARK;

      TimePickerDialog timePickerDialog = new TimePickerDialog(CalendarActivity.this,AlertDialog.THEME_DEVICE_DEFAULT_DARK , onTimeSetListener, begin_hour, begin_minute, false);
      timePickerDialog.setTitle("End Time");
      timePickerDialog.show();

   }

   private void setEventInfo()
   {
      // check all fields are filled
      if(fieldChecker())
      {
         // DATE IS MM-DD-YYYY format
          if (checkDateFormat())
          {
             if(datesAreChronological())
             {
                moveToTimePicker();
             }

             else
                Toast.makeText(CalendarActivity.this, "DATES ARE OUT OF ORDER", Toast.LENGTH_LONG).show();
          }

          // DATE IS NOT MM-DD-YYYY format
          else
             Toast.makeText(CalendarActivity.this, "DATE IS NOT MM-DD-YYYY format!!!!", Toast.LENGTH_LONG).show();

      }

      // Missing a field in the card view
      else
         Toast.makeText(CalendarActivity.this, "Missing a field!!!!", Toast.LENGTH_SHORT).show();
   }

   private void cardViewAnim()
   {
      AppAnimation.theAnimation(CalendarActivity.this, cardView, CONSTANTS.ANIMATION_OUT_LEFT);
      cardView.setVisibility(View.INVISIBLE);
      ((ViewGroup) cardView.getParent()).removeView(cardView);
   }

   @Override
   public void onClick(View v)
   {
      switch (v.getId())
      {
         case R.id.confirm_button:
            setEventInfo();
            break;

         case R.id.add_begin_date:
            startTime();
            add_begin_button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_green)));
            break;

         case R.id.add_end_date:
            add_end_button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_green)));
            endTime();
            break;
      } // end switch

   } // end onClick



   private boolean datesAreChronological()
   {
      boolean answer = false;

      if(begin_date.compareTo(end_date) > 0)
      {
         Toast.makeText(CalendarActivity.this, "begin_date occurs after end_date", Toast.LENGTH_LONG).show();
      }

      else if(begin_date.compareTo(end_date) < 0)
      {
         Toast.makeText(CalendarActivity.this, "begin_date occurs before end_date", Toast.LENGTH_LONG).show();
         answer = true;
      }
      else if(begin_date.compareTo(end_date) == 0)
      {
         Toast.makeText(CalendarActivity.this, "Both dates are equal", Toast.LENGTH_LONG).show();
         answer = true;
      }

      return answer;
   }

   private boolean checkDateFormat()
   {
      SimpleDateFormat format = new SimpleDateFormat(CONSTANTS.DATE_PATTERN);
      // With lenient parsing, the parser may use heuristics to interpret
      // inputs that do not precisely match this object's format.
      format.setLenient(false);

      try {
         // date objects stored here
         begin_date = format.parse(appointment_begin_date.getText().toString());
         end_date = format.parse(appointment_end_date.getText().toString());
      } catch (ParseException e) {
         begin_date = null;
         end_date = null;
         return false;
      }
      return true;
   } // end checkDateFormat

   // we might not need this
   private boolean checkMonthAndDay()
   {
      int begin_month = (begin_date.getMonth() + 1);
      int end_month = (end_date.getMonth() + 1);

      Log.d("FROM_CALENDAR ", " " + begin_month);
      Log.d("FROM_CALENDAR ", " " + end_month);

      boolean isGood = false;

      // month is good
      if( ((begin_month >= CONSTANTS.JAN) && (begin_month <= CONSTANTS.DEC)) && ((end_month >= CONSTANTS.JAN) && (end_month <= CONSTANTS.DEC)) )

      {
         // load calendar days
         HashMap <Integer, Integer> month_days = CONSTANTS.loadDays();
         int begin_max = month_days.get(begin_month);
         int end_max = month_days.get(end_month);

         int begin_day = begin_date.getDate();
         int end_day = end_date.getDate();

         // date is good
         if((begin_day <= begin_max) && (end_day <= end_max))
         {
           // Toast.makeText(CalendarActivity.this, "DATES ARE GOOD!!!!", Toast.LENGTH_LONG).show();
            isGood = datesAreChronological();
         }


         // day is bad
         else
         {
            Toast.makeText(CalendarActivity.this, "DATES ARE OUT OF ORDER...", Toast.LENGTH_LONG).show();
         }
      }

      // month is bad
      else
      {
         Toast.makeText(CalendarActivity.this, "MONTH IS OUT OF RANGE...", Toast.LENGTH_LONG).show();
      }

      return isGood;

   } // end checkMonthAndDay

   private void moveToTimePicker()
   {
      add_begin_button.setVisibility(View.VISIBLE);

      cardViewAnim();

      AppAnimation.theAnimation(this, add_begin_button, CONSTANTS.ANIMATION_IN_LEFT);
      calIntent.setData(CalendarContract.Events.CONTENT_URI);
      calIntent.putExtra(CalendarContract.Events.TITLE, appointment_title.getText().toString());
      calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, appointment_location.getText().toString());
      calIntent.putExtra(CalendarContract.Events.DESCRIPTION, appointment_description.getText().toString());
      calIntent.putExtra(Intent.EXTRA_EMAIL, appointment_begin_date.getText().toString());

   }

   private boolean fieldChecker()
   {
      return (!appointment_title.getText().toString().isEmpty()) &&
              (!appointment_location.getText().toString().isEmpty()) &&
              (!appointment_description.getText().toString().isEmpty()) &&
              (!appointment_begin_date.getText().toString().isEmpty()) &&
              (!appointment_end_date.getText().toString().isEmpty());
   }
} // end class