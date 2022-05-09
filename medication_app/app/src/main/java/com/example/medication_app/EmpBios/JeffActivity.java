package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class JeffActivity extends AppCompatActivity {

   private TextView jeff_title;
   private TextView jeff_email;
   private TextView jeff_header;
   private TextView jeff_intro;
   private TextView jeff_body;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_jeff);

      setTitle(R.string.jeff_quote);

      jeff_title = findViewById(R.id.jeff_title);
      jeff_email = findViewById(R.id.jeff_email);
      jeff_header = findViewById(R.id.jeff_header);
      jeff_intro = findViewById(R.id.jeff_intro);
      jeff_body = findViewById(R.id.jeff_body);

      jeff_intro.setText(CONSTANTS.JEFF_INTRO);
      jeff_body.setText(CONSTANTS.JEFF_BODY);

      AppAnimation.theAnimation(this, jeff_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, jeff_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, jeff_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, jeff_intro, CONSTANTS.ANIMATION_IN_UP);
      AppAnimation.theAnimation(this, jeff_body, CONSTANTS.ANIMATION_IN_UP);
   }
}