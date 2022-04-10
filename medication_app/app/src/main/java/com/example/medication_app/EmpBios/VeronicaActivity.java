package com.example.medication_app.EmpBios;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class VeronicaActivity extends AppCompatActivity
{

   private TextView veronica_title;
   private TextView veronica_email;
   private TextView veronica_header;
   private TextView veronica_bio;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_veronica);
      setTitle(R.string.veronica_quote);

      veronica_title = findViewById(R.id.veronica_title);
      veronica_email = findViewById(R.id.veronica_email);
      veronica_header = findViewById(R.id.veronica_header);
      veronica_bio = findViewById(R.id.veronica_bio);

      veronica_bio.setText(CONSTANTS.TEST_STRING);

      AppAnimation.theAnimation(this, veronica_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, veronica_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, veronica_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, veronica_bio, CONSTANTS.ANIMATION_IN_UP);
   } // end onCreate

} // end MicahActivity