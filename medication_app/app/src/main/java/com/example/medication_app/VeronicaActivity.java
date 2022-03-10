package com.example.medication_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medication_app.UI.AppAnimation;

public class VeronicaActivity extends AppCompatActivity
{

   private TextView veronica_title;
   private TextView veronica_email;
   private TextView veronica_header;
   private TextView veronica_bio;

   private final int RIGHT = R.anim.slide_in_right;
   private final int LEFT = R.anim.slide_in_left;
   private final int UP = R.anim.slide_in_up;

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

      veronica_bio.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

      AppAnimation.inAnim(this, veronica_title, RIGHT);
      AppAnimation.inAnim(this, veronica_email, RIGHT);
      AppAnimation.inAnim(this, veronica_header, LEFT);
      AppAnimation.inAnim(this, veronica_bio, UP);
   } // end onCreate

} // end MicahActivity