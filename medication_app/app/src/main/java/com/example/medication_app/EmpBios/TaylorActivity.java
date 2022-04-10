package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class TaylorActivity extends AppCompatActivity {

   private TextView taylor_title;
   private TextView taylor_email;
   private TextView taylor_header;
   private TextView taylor_bio;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_taylor);

      setTitle(R.string.taylor_quote);

      taylor_title = findViewById(R.id.taylor_title);
      taylor_email = findViewById(R.id.taylor_email);
      taylor_header = findViewById(R.id.taylor_header);
      taylor_bio = findViewById(R.id.taylor_bio);


      taylor_bio.setText(CONSTANTS.TEST_STRING);

      AppAnimation.theAnimation(this, taylor_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, taylor_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, taylor_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, taylor_bio, CONSTANTS.ANIMATION_IN_UP);
   }
}