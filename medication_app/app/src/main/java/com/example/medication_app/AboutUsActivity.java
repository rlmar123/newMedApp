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

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_about_us);
      setTitle(R.string.about_us);

      micah_image = findViewById(R.id.micah);
      veronica_image = findViewById(R.id.veronica);

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
   }






}