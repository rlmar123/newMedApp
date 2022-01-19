package com.example.medication_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medication_app.util.CONSTANTS;

public class DashboardActivity extends AppCompatActivity
{

   private TextView homeText = null;
   private TextView docText = null;
   private TextView apptText = null;
   private TextView aboutText = null;
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_dashboard);

      homeText = findViewById(R.id.home_text);
      docText = findViewById(R.id.doct_text);
      apptText = findViewById(R.id.appt_text);
      aboutText = findViewById(R.id.about_text);

      homeText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.HOME);
            Toast.makeText(DashboardActivity.this, "GOING TO MAIN", Toast.LENGTH_LONG).show();
            startActivity(intent);
         }
      });

      docText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.DOCTOR);
            Toast.makeText(DashboardActivity.this, "GOING TO MAIN", Toast.LENGTH_LONG).show();
            startActivity(intent);
         }
      });

      apptText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.APPOINTMENT);
            Toast.makeText(DashboardActivity.this, "APPT_REXR", Toast.LENGTH_LONG).show();
         }
      });

      aboutText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.ABOUT_US);
            Toast.makeText(DashboardActivity.this, "ABOUT_REXR", Toast.LENGTH_LONG).show();
         }
      });


   } // end onCreate

} // end DashboardActivity