package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.medication_app.Model.SendEmail;
import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class PaulActivity extends AppCompatActivity
{
   private TextView paul_title;
   private TextView paul_email;
   private TextView paul_header;
   private TextView paul_intro;
   private TextView paul_body;


/*   private TextView taylor_intro;
   private TextView taylor_body;*/

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_paul);

      setTitle(R.string.paul_quote);

      paul_title = findViewById(R.id.paul_title);
      paul_email = findViewById(R.id.paul_email);
      paul_header = findViewById(R.id.paul_header);
      paul_intro = findViewById(R.id.paul_intro);
      paul_body = findViewById(R.id.paul_body);

      paul_intro.setText(CONSTANTS.PAUL_INTRO);
      paul_body.setText(CONSTANTS.PAUL_BODY);
      paul_email.setText(CONSTANTS.PAUL_EMAIL);

      paul_email.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View v)
         {
            SendEmail.EmailIntent(CONSTANTS.PAUL_EMAIL, PaulActivity.this);
         }
      });

      AppAnimation.theAnimation(this, paul_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, paul_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, paul_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, paul_intro, CONSTANTS.ANIMATION_IN_UP);
      AppAnimation.theAnimation(this, paul_body, CONSTANTS.ANIMATION_IN_UP);
   }
}