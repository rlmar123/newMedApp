package com.example.medication_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.transition.Fade;

import com.airbnb.lottie.LottieAnimationView;
import com.example.medication_app.EmpBios.AboutUsActivity;
import com.example.medication_app.util.CONSTANTS;

public class DashboardActivity extends AppCompatActivity
{

   private TextView homeText = null;
   private TextView docText = null;
   private TextView apptText = null;
   private TextView aboutText = null;

   private LottieAnimationView lottieAnimationView;

   //to build alert dialog
   private AlertDialog.Builder our_builder = null;
   private AlertDialog our_dialog = null;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_dashboard);

      setTitle(R.string.dashboard_activity);

      homeText = findViewById(R.id.home_text);
      docText = findViewById(R.id.doct_text);
      apptText = findViewById(R.id.appt_text);
      aboutText = findViewById(R.id.about_text);

      lottieAnimationView = findViewById(R.id.AppointView);


      Fade fade = new Fade();
      View decor = getWindow().getDecorView();
      fade.excludeTarget(decor.findViewById(R.id.action_bar_container), true);
      fade.excludeTarget(android.R.id.statusBarBackground, true);
      fade.excludeTarget(android.R.id.navigationBarBackground, true);

      getWindow().setEnterTransition(fade);
      getWindow().setExitTransition(fade);

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
            createAppointment();
         }
      });

      aboutText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view)
         {
            Intent intent = new Intent(DashboardActivity.this, AboutUsActivity.class);
          //  intent.putExtra(CONSTANTS.ANSWER, CONSTANTS.ABOUT_US);


            Toast.makeText(DashboardActivity.this, "ABOUT_US", Toast.LENGTH_LONG).show();
            startActivity(intent);
         }
      });


   } // end onCreate

   private void createAppointment()
   {
      Intent intent = new Intent(DashboardActivity.this, CalendarActivity.class);

      ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(DashboardActivity.this, apptText, "example_transition");
      // starting our activity with below method.
      startActivity(intent,options.toBundle());
   }


} // end DashboardActivity