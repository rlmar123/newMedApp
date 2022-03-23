package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class PaulActivity extends AppCompatActivity
{
   private TextView paul_title;
   private TextView paul_email;
   private TextView paul_header;
   private TextView paul_bio;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_paul);

      setTitle(R.string.paul_quote);

      paul_title = findViewById(R.id.paul_title);
      paul_email = findViewById(R.id.paul_email);
      paul_header = findViewById(R.id.paul_header);
      paul_bio = findViewById(R.id.paul_bio);

      paul_bio.setText(CONSTANTS.TEST_STRING);

      AppAnimation.theAnimation(this, paul_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, paul_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, paul_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, paul_bio, CONSTANTS.ANIMATION_IN_UP);
   }
}