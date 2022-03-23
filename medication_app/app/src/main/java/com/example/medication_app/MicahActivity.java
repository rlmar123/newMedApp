package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class MicahActivity extends AppCompatActivity
{

   private TextView micah_title;
   private TextView micah_email;
   private TextView micah_header;
   private TextView micah_bio;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_micah);
      setTitle(R.string.micah_quote);

      micah_title = findViewById(R.id.micah_title);
      micah_email = findViewById(R.id.micah_email);
      micah_header = findViewById(R.id.micah_header);
      micah_bio = findViewById(R.id.micah_bio);

      micah_bio.setText(CONSTANTS.TEST_STRING);

      AppAnimation.theAnimation(this, micah_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, micah_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, micah_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, micah_bio, CONSTANTS.ANIMATION_IN_UP);
   } // end onCreate

} // end MicahActivity