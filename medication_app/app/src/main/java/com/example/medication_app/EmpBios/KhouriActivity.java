package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class KhouriActivity extends AppCompatActivity
{
   private TextView khouri_title;
   private TextView khouri_email;
   private TextView khouri_header;
   private TextView khouri_bio;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_khouri);

      setTitle(R.string.khouri_quote);

      khouri_title = findViewById(R.id.khouri_title);
      khouri_email = findViewById(R.id.khouri_email);
      khouri_header = findViewById(R.id.khouri_header);
      khouri_bio = findViewById(R.id.khouri_bio);

      khouri_bio.setText(CONSTANTS.TEST_STRING);

      AppAnimation.theAnimation(this, khouri_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, khouri_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, khouri_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, khouri_bio, CONSTANTS.ANIMATION_IN_UP);
   }
}