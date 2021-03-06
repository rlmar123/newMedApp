package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.medication_app.Model.SendEmail;
import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class KhouriActivity extends AppCompatActivity
{
   private TextView khouri_title;
   private TextView khouri_email;
   private TextView khouri_header;
   private TextView khouri_intro;
   private TextView khouri_body;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_khouri);

      setTitle(R.string.khouri_quote);

      khouri_title = findViewById(R.id.khouri_title);
      khouri_email = findViewById(R.id.khouri_email);
      khouri_header = findViewById(R.id.khouri_header);
      khouri_intro = findViewById(R.id.khouri_intro);
      khouri_body = findViewById(R.id.khouri_body);

      khouri_intro.setText(CONSTANTS.KHOURI_INTRO);
      khouri_body.setText(CONSTANTS.KHOURI_BODY);
      khouri_email.setText(CONSTANTS.KHOURI_EMAIL);

      khouri_email.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View v)
         {
            SendEmail.EmailIntent(CONSTANTS.KHOURI_EMAIL, KhouriActivity.this);
         }
      });


      AppAnimation.theAnimation(this, khouri_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, khouri_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, khouri_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, khouri_intro, CONSTANTS.ANIMATION_IN_UP);
      AppAnimation.theAnimation(this, khouri_body, CONSTANTS.ANIMATION_IN_UP);
   }
}