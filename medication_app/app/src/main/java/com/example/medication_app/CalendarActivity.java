package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medication_app.util.CONSTANTS;

public class CalendarActivity extends AppCompatActivity {

   private TextView textView;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_calendar);

     // Intent intent = getIntent();

      // initializing our imageview.
      textView = findViewById(R.id.second);
   }



   private void setOpeningFragment()
   {
      /*Intent intent = getIntent();
      String message = intent.getStringExtra(CONSTANTS.ANSWER);

      if(message != null)
      {
         if (message.equals(CONSTANTS.HOME))
            opening_fragment = new FragmentHome();

         else if (message.equals(CONSTANTS.DOCTOR))
            opening_fragment = new FragmentDocInfo();

            // we need to changw later
         else if (message.equals(CONSTANTS.APPOINTMENT))
            opening_fragment = new FragmentDocInfo();

         else if (message.equals(CONSTANTS.ABOUT_US))
            opening_fragment = new FragmentHome();
      } */

   } // end setOpeningFragment


}