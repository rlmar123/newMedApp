package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.medication_app.UI.AppAnimation;

public class MicahActivity extends AppCompatActivity
{

   private TextView micah_title;
   private TextView micah_email;
   private TextView micah_header;
   private TextView micah_bio;

   private final int RIGHT = R.anim.slide_in_right;
   private final int LEFT = R.anim.slide_in_left;
   private final int UP = R.anim.slide_in_up;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_micah);
      setTitle(R.string.micah_quote);

      micah_title = findViewById(R.id.micah_title);
      micah_email = findViewById(R.id.micah_email);
      micah_header = findViewById(R.id.micah_header);
      micah_bio = findViewById(R.id.micah_bio);

      micah_bio.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

      AppAnimation.inAnim(this, micah_title, RIGHT);
      AppAnimation.inAnim(this, micah_email, RIGHT);
      AppAnimation.inAnim(this, micah_header, LEFT);
      AppAnimation.inAnim(this, micah_bio, UP);
   } // end onCreate

} // end MicahActivity