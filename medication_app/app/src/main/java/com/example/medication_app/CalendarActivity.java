package com.example.medication_app;


import android.app.AlertDialog;


import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


public class CalendarActivity extends AppCompatActivity
{

   private Button add_end_button = null;
   private Button add_begin_button = null;
   private Button confirm_button = null;

   private TextInputEditText appointment_title;
   private TextInputEditText appointment_location;
   private TextInputEditText appointment_description;
   private TextInputEditText appointment_date;

   private CardView cardView;

   private int begin_hour, begin_minute;
   private int end_hour, end_minute;

   private Intent calIntent;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_calendar);

      setTitle(R.string.appt_activity);

      appointment_title = findViewById(R.id.appointment_title);
      appointment_location = findViewById(R.id.appointment_location);
      appointment_description = findViewById(R.id.appointment_description);
      appointment_date = findViewById(R.id.appointment_date);

      confirm_button = findViewById(R.id.confirm_button);

      add_begin_button = findViewById(R.id.add_begin_date);
      add_end_button = findViewById(R.id.add_end_date);
      cardView = findViewById(R.id.card_view);

      add_begin_button.setVisibility(View.INVISIBLE);
      add_end_button.setVisibility(View.INVISIBLE);

      calIntent = new Intent(Intent.ACTION_INSERT);

      confirm_button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            setEventInfo();

         }
      });

      add_begin_button.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View view)
         {
            startTime();
            add_begin_button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_green)));
         } // end onClick

      }); // end onClicklister

      add_end_button.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View view)
         {
            add_end_button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.my_green)));
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

            begin_hour = selectedHour;
            begin_minute = selectedMinute;

            // get start time
            startTime.set(2012, 0, 29, begin_hour, begin_minute);
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime.getTimeInMillis());

            rightInAnim();
            leftOutAnim();

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
      if((!appointment_title.getText().toString().isEmpty()) &&
      (!appointment_location.getText().toString().isEmpty()) &&
      (!appointment_description.getText().toString().isEmpty()) &&
      (!appointment_date.getText().toString().isEmpty()))
      {

         add_begin_button.setVisibility(View.VISIBLE);
         //cardView.setVisibility(View.INVISIBLE);
         cardViewAnim();
         leftInAnim();



         calIntent.setData(CalendarContract.Events.CONTENT_URI);
         calIntent.putExtra(CalendarContract.Events.TITLE, appointment_title.getText().toString());
         calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, appointment_location.getText().toString());
         calIntent.putExtra(CalendarContract.Events.DESCRIPTION, appointment_description.getText().toString());
         calIntent.putExtra(Intent.EXTRA_EMAIL, appointment_date.getText().toString());
      }

      // Missing a field in the card view
      else
         Toast.makeText(CalendarActivity.this, "Missing a field!!!!", Toast.LENGTH_SHORT).show();
   }

   private void leftInAnim()
   {
      Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
      add_begin_button.startAnimation(animation);
   }

   private void rightInAnim()
   {
      add_end_button.setVisibility(View.VISIBLE);

      Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
      add_end_button.startAnimation(animation);
   }

   private void leftOutAnim()
   {
      Animation the_animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
      add_begin_button.startAnimation(the_animation);
      add_begin_button.setVisibility(View.INVISIBLE);
   }

   private void cardViewAnim()
   {
      Animation the_animation = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
      cardView.setAnimation(the_animation);
      cardView.setVisibility(View.INVISIBLE);
      ((ViewGroup) cardView.getParent()).removeView(cardView);
   }



} // end class