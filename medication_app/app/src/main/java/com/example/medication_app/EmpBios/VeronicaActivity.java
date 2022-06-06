package com.example.medication_app.EmpBios;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medication_app.Model.SendEmail;
import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class VeronicaActivity extends AppCompatActivity
{

   private TextView veronica_title;
   private TextView veronica_email;
   private TextView veronica_header;
   private TextView veronica_intro;
   private TextView veronica_body;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_veronica);
      setTitle(R.string.veronica_quote);

      veronica_title = findViewById(R.id.veronica_title);
      veronica_email = findViewById(R.id.veronica_email);
      veronica_header = findViewById(R.id.veronica_header);
      veronica_intro = findViewById(R.id.veronica_intro);
      veronica_body = findViewById(R.id.veronica_body);

      veronica_intro.setText(CONSTANTS.VERONICA_INTRO);
      veronica_body.setText(CONSTANTS.VERONICA_BODY);

      veronica_email.setText(CONSTANTS.VERONICA_EMAIL);

      veronica_email.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View v)
         {
            SendEmail.EmailIntent(CONSTANTS.VERONICA_EMAIL, VeronicaActivity.this);
         }
      });

      AppAnimation.theAnimation(this, veronica_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, veronica_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, veronica_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, veronica_intro, CONSTANTS.ANIMATION_IN_UP);
      AppAnimation.theAnimation(this, veronica_body, CONSTANTS.ANIMATION_IN_UP);
   } // end onCreate

} // end MicahActivity