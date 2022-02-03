package com.example.medication_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.transition.Fade;

import com.airbnb.lottie.LottieAnimationView;
import com.example.medication_app.util.CONSTANTS;

import java.util.Calendar;
import java.util.Objects;

public class DashboardActivity extends AppCompatActivity
{

   private TextView homeText = null;
   private TextView docText = null;
   private TextView apptText = null;
   private TextView aboutText = null;

   //to build alert dialog
   private AlertDialog.Builder our_builder = null;
   private AlertDialog our_dialog = null;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_dashboard);

      homeText = findViewById(R.id.home_text);
      docText = findViewById(R.id.doct_text);
      apptText = findViewById(R.id.appt_text);
      aboutText = findViewById(R.id.about_text);

      LottieAnimationView lottieAnimationView = findViewById(R.id.AppointView);


      Fade fade = new Fade();
      View decor = getWindow().getDecorView();
      fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
      fade.excludeTarget(android.R.id.statusBarBackground, true);
      fade.excludeTarget(android.R.id.navigationBarBackground, true);

      getWindow().setEnterTransition(fade);
      getWindow().setExitTransition(fade);

      homeText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.HOME);
            Toast.makeText(DashboardActivity.this, "GOING TO MAIN", Toast.LENGTH_LONG).show();
            startActivity(intent);
         }
      });

      docText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.DOCTOR);
            Toast.makeText(DashboardActivity.this, "GOING TO MAIN", Toast.LENGTH_LONG).show();
            startActivity(intent);
         }
      });

      apptText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            createAppointment();
         }
      });

      aboutText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.ABOUT_US);


            Toast.makeText(DashboardActivity.this, "ABOUT_REXR", Toast.LENGTH_LONG).show();
            startActivity(intent);
         }
      });


   } // end onCreate

   private void createAppointment()
   {
     //enterAppointmentTitle();
     /* enterAppointmentLoc();
      enterAppointmentDesc();*/

    /*  Intent calIntent = new Intent(Intent.ACTION_INSERT);

      calIntent.setData(CalendarContract.Events.CONTENT_URI);
      calIntent.putExtra(CalendarContract.Events.TITLE, "PARTY");
      calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "MY CRIB");
      calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "BYOB");
      calIntent.putExtra(Intent.EXTRA_EMAIL, "test@yahoo.com, test2@yahoo.com, test3@yahoo.com");

      Calendar startTime = Calendar.getInstance();
      // get start time
      startTime.set(2012, 0, 29, 18, 0);

      // get end time
      Calendar endTime = Calendar.getInstance();
      endTime.set(2012, 6, 29, 22, 30);

      calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime.getTimeInMillis());
      calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());

      if(calIntent.resolveActivity(getPackageManager()) != null)
         startActivity(calIntent);
      else
         Toast.makeText(DashboardActivity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show(); */

      Intent intent = new Intent(DashboardActivity.this, CalendarActivity.class);

      ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(DashboardActivity.this, apptText, "example_transition");
      // starting our activity with below method.
      startActivity(intent,options.toBundle());
      Log.d("main", "here!!!!!!");

   }


   private void enterAppointmentTitle()
   {
      our_builder = new AlertDialog.Builder(DashboardActivity.this);

      //make connection to popup.xml
      View update_pop_up = getLayoutInflater().inflate(R.layout.enter_appointment_title, null);

      our_builder.setView(update_pop_up);

      //this displays the dialog
      our_dialog = our_builder.create();
      our_dialog.show();
   }

   private void enterAppointmentLoc()
   {
      our_builder = new AlertDialog.Builder(DashboardActivity.this);

      //make connection to popup.xml
      View update_pop_up = getLayoutInflater().inflate(R.layout.enter_appointment_loc, null);

      our_builder.setView(update_pop_up);

      //this displays the dialog
      our_dialog = our_builder.create();
      our_dialog.show();
   }

   private void enterAppointmentDesc()
   {
      our_builder = new AlertDialog.Builder(DashboardActivity.this);

      //make connection to popup.xml
      View update_pop_up = getLayoutInflater().inflate(R.layout.enter_appointment_desc, null);

      our_builder.setView(update_pop_up);

      //this displays the dialog
      our_dialog = our_builder.create();
      our_dialog.show();
   }
} // end DashboardActivity