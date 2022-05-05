package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class MicahActivity extends AppCompatActivity
{

   private TextView micah_title;
   private TextView micah_email;
   private TextView micah_header;
   private TextView micah_intro;
   private TextView micah_body;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_micah);
      setTitle(R.string.micah_quote);

      micah_title = findViewById(R.id.micah_title);
      micah_email = findViewById(R.id.micah_email);
      micah_header = findViewById(R.id.micah_header);
      micah_intro = findViewById(R.id.micah_intro);
      micah_body = findViewById(R.id.micah_body);

      micah_intro.setText(CONSTANTS.MICAH_INTRO);
      micah_body.setText(CONSTANTS.MICAH_BODY);


      AppAnimation.theAnimation(this, micah_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, micah_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, micah_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, micah_intro, CONSTANTS.ANIMATION_IN_UP);
      AppAnimation.theAnimation(this, micah_body, CONSTANTS.ANIMATION_IN_UP);
   } // end onCreate

} // end MicahActivity