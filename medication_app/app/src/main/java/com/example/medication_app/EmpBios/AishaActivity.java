package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class AishaActivity extends AppCompatActivity
{
   private TextView aisha_title;
   private TextView aisha_email;
   private TextView aisha_header;
   private TextView aisha_intro;
   private TextView aisha_body;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_aisha);

      setTitle(R.string.aisha_quote);

      aisha_title = findViewById(R.id.aisha_title);
      aisha_email = findViewById(R.id.aisha_email);
      aisha_header = findViewById(R.id.aisha_header);
      aisha_intro = findViewById(R.id.aisha_intro);
      aisha_body = findViewById(R.id.aisha_body);

      aisha_intro.setText(CONSTANTS.AISHA_INTRO);
      aisha_body.setText(CONSTANTS.AISHA_BODY);

      AppAnimation.theAnimation(this, aisha_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, aisha_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, aisha_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, aisha_intro, CONSTANTS.ANIMATION_IN_UP);
      AppAnimation.theAnimation(this, aisha_body, CONSTANTS.ANIMATION_IN_UP);
   }
}