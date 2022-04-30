package com.example.medication_app;


import android.app.AlertDialog;


import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;



import com.example.medication_app.Fragments.DatePickerFragment;
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
   private Button begin_day = null;
   private Button end_day = null;

   private DatePickerDialog datePickerDialog;

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
    //  appointment_begin_date = findViewById(R.id.appointment_begin_date);


      confirm_button = findViewById(R.id.confirm_button);
      begin_day = findViewById(R.id.appointment_begin_date);
      end_day = findViewById(R.id.appointment_end_date);

      add_begin_button = findViewById(R.id.add_begin_date);
      add_end_button = findViewById(R.id.add_end_date);
      cardView = findViewById(R.id.card_view);

      add_begin_button.setVisibility(View.INVISIBLE);
      add_end_button.setVisibility(View.INVISIBLE);

      calIntent = new Intent(Intent.ACTION_INSERT);

      // register listeners for onClick
      confirm_button.setOnClickListener(this);
      add_begin_button.setOnClickListener(this);
      add_end_button.setOnClickListener(this);
      begin_day.setOnClickListener(this);
      end_day.setOnClickListener(this);

      initDatePicker();

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
            startTime.set(begin_date.getYear(), begin_date.getMonth(), begin_date.getDate(), begin_hour, begin_minute);
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
            Log.d("END_year", "" + (1900 + end_date.getYear()));
            Log.d("END_month", "" + end_date.getMonth());
            Log.d("END_date", "" + end_date.getDate());
            endTime.set(end_date.getYear(), (end_date.getMonth() + 1), end_date.getDate(), end_hour, end_minute);
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
          //  setEventInfo();
           // datePickerDialog.show();
        //    DialogFragment datePicker = new DatePickerFragment();
       //     datePicker.show(getSupportFragmentManager(), "date picker");
            break;

         case R.id.add_begin_date:
            startTime();

            add_begin_button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_green)));
            break;

         case R.id.add_end_date:
            add_end_button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_green)));
            endTime();
            break;

         case R.id.appointment_begin_date:
            openDatePicker();
            break;

         case R.id.appointment_end_date:
            openDatePicker();
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

   private void moveToTimePicker()
   {
      add_begin_button.setVisibility(View.VISIBLE);

      cardViewAnim();

      // fix appointment_begin_date!!!!!
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
              (!appointment_description.getText().toString().isEmpty());
   }

   private void initDatePicker()
   {
      DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
      {
         @Override
         public void onDateSet(DatePicker datePicker, int year, int month, int day)
         {
            month = month + 1;
            String date = makeDateString(day, month, year);
            Toast.makeText(CalendarActivity.this, date, Toast.LENGTH_LONG).show();

            //   dateButton.setText(date);
         }
      };

      Calendar cal = Calendar.getInstance();
      int year = cal.get(Calendar.YEAR);
      int month = cal.get(Calendar.MONTH);
      int day = cal.get(Calendar.DAY_OF_MONTH);

      int style = AlertDialog.THEME_HOLO_LIGHT;

      datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
      //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

   }

   private String makeDateString(int day, int month, int year)
   {
      return getMonthFormat(month) + " " + day + " " + year;
   }

   private String getMonthFormat(int month)
   {
      if(month == 1)
         return "JAN";
      if(month == 2)
         return "FEB";
      if(month == 3)
         return "MAR";
      if(month == 4)
         return "APR";
      if(month == 5)
         return "MAY";
      if(month == 6)
         return "JUN";
      if(month == 7)
         return "JUL";
      if(month == 8)
         return "AUG";
      if(month == 9)
         return "SEP";
      if(month == 10)
         return "OCT";
      if(month == 11)
         return "NOV";
      if(month == 12)
         return "DEC";

      //default should never happen
      return "JAN";
   }

   public void openDatePicker()
   {
      datePickerDialog.show();
   }

} // end class