package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class AishaActivity extends AppCompatActivity
{
   private TextView aisha_title;
   private TextView aisha_email;
   private TextView aisha_header;
   private TextView aisha_bio;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_aisha);

      setTitle(R.string.aisha_quote);

      aisha_title = findViewById(R.id.aisha_title);
      aisha_email = findViewById(R.id.aisha_email);
      aisha_header = findViewById(R.id.aisha_header);
      aisha_bio = findViewById(R.id.aisha_bio);

      aisha_bio.setText(CONSTANTS.TEST_STRING);

      AppAnimation.inAnim(this, aisha_title, CONSTANTS.ANIMATION_RIGHT);
      AppAnimation.inAnim(this, aisha_email, CONSTANTS.ANIMATION_RIGHT);
      AppAnimation.inAnim(this, aisha_header, CONSTANTS.ANIMATION_LEFT);
      AppAnimation.inAnim(this, aisha_bio, CONSTANTS.ANIMATION_UP);
   }
}