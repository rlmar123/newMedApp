package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class StacyActivity extends AppCompatActivity {

   private TextView stacy_title;
   private TextView stacy_email;
   private TextView stacy_header;
   private TextView stacy_intro;
   private TextView stacy_body;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_stacy);

      setTitle(R.string.stacy_quote);

      stacy_title = findViewById(R.id.stacy_title);
      stacy_email = findViewById(R.id.paul_email);
      stacy_header = findViewById(R.id.paul_header);
      stacy_intro = findViewById(R.id.stacy_intro);
      stacy_body = findViewById(R.id.stacy_body);


      stacy_intro.setText(CONSTANTS.STACY_INTRO);
      stacy_body.setText(CONSTANTS.STACY_BODY);


      AppAnimation.theAnimation(this, stacy_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, stacy_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, stacy_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, stacy_intro, CONSTANTS.ANIMATION_IN_UP);
      AppAnimation.theAnimation(this, stacy_body, CONSTANTS.ANIMATION_IN_LEFT);
   }
}