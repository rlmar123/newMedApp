package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class StacyActivity extends AppCompatActivity {

   private TextView stacy_title;
   private TextView stacy_email;
   private TextView stacy_header;
   private TextView stacy_bio;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_stacy);

      setTitle(R.string.stacy_quote);

      stacy_title = findViewById(R.id.stacy_title);
      stacy_email = findViewById(R.id.paul_email);
      stacy_header = findViewById(R.id.paul_header);
      stacy_bio = findViewById(R.id.stacy_bio);


      stacy_bio.setText(CONSTANTS.TEST_STRING);

      AppAnimation.inAnim(this, stacy_title, CONSTANTS.ANIMATION_RIGHT);
      AppAnimation.inAnim(this, stacy_email, CONSTANTS.ANIMATION_RIGHT);
      AppAnimation.inAnim(this, stacy_header, CONSTANTS.ANIMATION_LEFT);
      AppAnimation.inAnim(this, stacy_bio, CONSTANTS.ANIMATION_UP);
   }
}