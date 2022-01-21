package com.example.medication_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

public class TitleActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{
   private TextView title_text;
   private TextView logo_text;

   private ImageView lines;
   private ImageView settinds;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_title);

      AlphaAnimation text_animation = new AlphaAnimation(0.0f, 1.0f);

      // loading Animation from
      Animation logo_animation = AnimationUtils.loadAnimation(this, R.anim.spin_anim);

      text_animation.setDuration(1000);
      text_animation.setRepeatCount(Animation.INFINITE);
      text_animation.setRepeatMode(Animation.REVERSE);

      title_text = findViewById(R.id.title_text);
      logo_text = findViewById(R.id.logo_text);
   //   lines = findViewById(R.id.three_bars);
      settinds = findViewById(R.id.the_setting);

      title_text.startAnimation(text_animation);
      logo_text.startAnimation(logo_animation);

/*      lines.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View v)
         {
            showPopup(v);
         }
      });*/

      Handler handler = new Handler();

      handler.postDelayed(new Runnable() {
         @Override
         public void run()
         {
            Intent camera_intent = new Intent(TitleActivity.this, DashboardActivity.class);
            startActivity(camera_intent);

            //kills previous activity
            finish();
         }
      }, 5000);

   } // end onCreate

   public void showPopup(View v)
   {
      PopupMenu the_pop = new PopupMenu(this, v);
      the_pop.setOnMenuItemClickListener(this);
      the_pop.inflate(R.menu.nav_menu);
      the_pop.show();
   }

   @Override
   public boolean onMenuItemClick(MenuItem item)
   {
      switch (item.getItemId())
      {
         case R.id.Home:
            Toast.makeText(this, "Doctor Info selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(TitleActivity.this, MainActivity.class);
            startActivity(intent);

            return true;

         case R.id.Add_Remove:
            Toast.makeText(this, "Refill", Toast.LENGTH_SHORT).show();
            return true;

         default:
            return super.onOptionsItemSelected(item);
      } // end switch
   } // end onMenuItemClick

} // end TitleActivity