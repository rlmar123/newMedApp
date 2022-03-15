package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutUsActivity extends AppCompatActivity {

   private ImageView micah_image = null;
   private ImageView veronica_image = null;
   private ImageView stacy_image = null;
   private ImageView taylor_image = null;
   private ImageView paul_image = null;
   private ImageView jeff_image = null;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_about_us);
      setTitle(R.string.about_us);

      micah_image = findViewById(R.id.micah);
      veronica_image = findViewById(R.id.veronica);
      stacy_image = findViewById(R.id.stacy);
      taylor_image = findViewById(R.id.taylor);
      paul_image = findViewById(R.id.paul);
      jeff_image = findViewById(R.id.jeff);

      micah_image.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(AboutUsActivity.this, MicahActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AboutUsActivity.this, micah_image, "micah_transition");

            // starting our activity with below method.
            startActivity(intent,options.toBundle());
         }
      });

      veronica_image.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(AboutUsActivity.this, VeronicaActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AboutUsActivity.this, veronica_image, "veronica_transition");

            // starting our activity with below method.
            startActivity(intent,options.toBundle());
         }
      });

      stacy_image.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(AboutUsActivity.this, StacyActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AboutUsActivity.this, stacy_image, "veronica_transition");

            // starting our activity with below method.
            startActivity(intent,options.toBundle());
         }
      });

      taylor_image.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(AboutUsActivity.this, TaylorActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AboutUsActivity.this, taylor_image, "veronica_transition");

            // starting our activity with below method.
            startActivity(intent,options.toBundle());
         }
      });

      paul_image.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(AboutUsActivity.this, PaulActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AboutUsActivity.this, paul_image, "veronica_transition");

            // starting our activity with below method.
            startActivity(intent,options.toBundle());
         }
      });

      jeff_image.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(AboutUsActivity.this, JeffActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AboutUsActivity.this, jeff_image, "veronica_transition");

            // starting our activity with below method.
            startActivity(intent,options.toBundle());
         }
      });
   }






}