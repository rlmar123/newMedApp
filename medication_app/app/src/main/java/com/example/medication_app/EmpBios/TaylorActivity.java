package com.example.medication_app.EmpBios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.medication_app.Model.SendEmail;
import com.example.medication_app.R;
import com.example.medication_app.UI.AppAnimation;
import com.example.medication_app.util.CONSTANTS;

public class TaylorActivity extends AppCompatActivity {

   private TextView taylor_title;
   private TextView taylor_email;
   private TextView taylor_header;
   private TextView taylor_intro;
   private TextView taylor_body;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_taylor);

      setTitle(R.string.taylor_quote);

      taylor_title = findViewById(R.id.taylor_title);
      taylor_email = findViewById(R.id.taylor_email);
      taylor_header = findViewById(R.id.taylor_header);
      taylor_intro = findViewById(R.id.taylor_intro);
      taylor_body = findViewById(R.id.taylor_body);


      taylor_intro.setText(CONSTANTS.TAYLOR_INTRO);
      taylor_body.setText(CONSTANTS.TAYLOR_BODY);
      taylor_email.setText(CONSTANTS.TAYLOR_EMAIL);


      taylor_email.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View v)
         {
            SendEmail.EmailIntent(CONSTANTS.TAYLOR_EMAIL, TaylorActivity.this);
         }
      });



      AppAnimation.theAnimation(this, taylor_title, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, taylor_email, CONSTANTS.ANIMATION_IN_RIGHT);
      AppAnimation.theAnimation(this, taylor_header, CONSTANTS.ANIMATION_IN_LEFT);
      AppAnimation.theAnimation(this, taylor_intro, CONSTANTS.ANIMATION_IN_UP);
      AppAnimation.theAnimation(this, taylor_body, CONSTANTS.ANIMATION_IN_UP);

   }
}