package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutUsActivity extends AppCompatActivity {

   private ImageView micah_image = null;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_about_us);

      micah_image = findViewById(R.id.micah);

      micah_image.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(AboutUsActivity.this, MicahActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(AboutUsActivity.this, micah_image, "sample_transition");

            // starting our activity with below method.
            startActivity(intent,options.toBundle());
         }
      });
   }
}