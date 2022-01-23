package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medication_app.util.CONSTANTS;

import java.util.Calendar;

public class DashboardActivity extends AppCompatActivity
{

   private TextView homeText = null;
   private TextView docText = null;
   private TextView apptText = null;
   private TextView aboutText = null;
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_dashboard);

      homeText = findViewById(R.id.home_text);
      docText = findViewById(R.id.doct_text);
      apptText = findViewById(R.id.appt_text);
      aboutText = findViewById(R.id.about_text);

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
           /* Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.APPOINTMENT);
            Toast.makeText(DashboardActivity.this, "APPT_REXR", Toast.LENGTH_LONG).show();
            startActivity(intent);*/


            /*Intent intent = new Intent(Intent.ACTION_INSERT);



            intent.setData(CalendarContract.Events.CONTENT_URI);

            intent.putExtra(CalendarContract.Events.TITLE, "PARTY");
            intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "MY CRIB");
            intent.putExtra(CalendarContract.Events.DESCRIPTION, "BYOB");
            intent.putExtra(CalendarContract.Events.ALL_DAY, true);

            intent.putExtra(Intent.EXTRA_EMAIL, "test@yahoo.com, test2@yahoo.com, test3@yahoo.com");*/

            Intent calIntent = new Intent(Intent.ACTION_INSERT);
            calIntent.setData(CalendarContract.Events.CONTENT_URI);
            calIntent.putExtra(CalendarContract.Events.TITLE, "PARTY");
            calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "MY CRIB");
            calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "BYOB");
            calIntent.putExtra(Intent.EXTRA_EMAIL, "test@yahoo.com, test2@yahoo.com, test3@yahoo.com");

            Calendar startTime = Calendar.getInstance();
            startTime.set(2012, 0, 29, 18, 0);

            Calendar endTime = Calendar.getInstance();
            endTime.set(2012, 6, 29, 22, 30);

            calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime.getTimeInMillis());
            calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());

            if(calIntent.resolveActivity(getPackageManager()) != null)
               startActivity(calIntent);
            else
               Toast.makeText(DashboardActivity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show();
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

} // end DashboardActivity