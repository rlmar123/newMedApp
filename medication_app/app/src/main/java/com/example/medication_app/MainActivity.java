package com.example.medication_app;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import com.example.medication_app.Model.MedicationViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

//import com.example.ne575757473w_med_app.Model.MedicationViewModel;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{

   BottomNavigationView test_bar;
   FrameLayout frameLayout;

   private ImageView lines;
   private ImageView settinds;

   private HorizontalCalendar horizontalCalendar;

   private String formatted;

   private final int day_offset = 0;

   private Fragment opening_fragment = null;
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);


      test_bar = findViewById(R.id.bottom_nav);

  ///    add_icon = findViewById(R.id.add_icon);
      test_bar.setOnNavigationItemSelectedListener(navListener);


      // starts before 1 month from now
      Calendar startDate = Calendar.getInstance();
      startDate.add(Calendar.MONTH, -1);

      // ends after 1 month from now
      Calendar endDate = Calendar.getInstance();
      endDate.add(Calendar.MONTH, 1);

      horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
              .range(startDate, endDate)
              .datesNumberOnScreen(5)
              .build();



      // date is passed as string to MedicationViewModel
      horizontalCalendar.setCalendarListener(new HorizontalCalendarListener()
      {
        @Override
         public void onDateSelected(Calendar date, int position)
         {

            formatted = setStringDate(position);
            changeFragment(new FragmentHome(), MedicationViewModel.julianDate(formatted));

            Toast.makeText(MainActivity.this, "REFILL!!!!" + formatted, Toast.LENGTH_LONG).show();

         }
      });


      Date now = new Date();

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(now);


      ///// YEAAAAAHHHHHH!!!!!
      Integer begin = calendar.get(Calendar.DAY_OF_YEAR);

  /*    opening_fragment = new FragmentHome();
      Log.d("FROM MAIN!!!", "YAY!! " + begin);
      changeFragment(opening_fragment, begin);*/

   } // end onCreate

   // fragments change here
   private BottomNavigationView.OnNavigationItemSelectedListener navListener =
           new BottomNavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item)
              {
                 Fragment selectedFragment = null;

                 switch (item.getItemId())
                 {
                    case R.id.home_icon:
                       selectedFragment = new FragmentHome();
                       Date now = new Date();

                       Calendar calendar = Calendar.getInstance();
                       calendar.setTime(now);


                       ///// YEAAAAAHHHHHH!!!!!
                       Integer tye = calendar.get(Calendar.DAY_OF_YEAR);
                       // here we may need to add date
                      changeFragment(selectedFragment, tye);

                       horizontalCalendar.show();
                       break;

                    case R.id.refill_icon:

                       /*selectedFragment = new NextFragment();*/
                       Toast.makeText(MainActivity.this, "REFILL!!!!" , Toast.LENGTH_LONG).show();
                       break;

                    case R.id.doctor_info:
                       test_bar.setBackgroundResource(R.color.black);

                       selectedFragment = new FragmentDocInfo();
                        changeFragment(selectedFragment);

                       horizontalCalendar.hide();
                       //    Toast.makeText(MainActivity.this, "DOCTOR INFO!!!!" , Toast.LENGTH_LONG).show();
                       break;
                 }

                 return true;
              }
           };

   private void changeFragment(Fragment fragment)
   {
      Bundle bundle = new Bundle();
      bundle.putInt("count", 23);

      fragment.setArguments(bundle);
      getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
   }

   private void changeFragment(Fragment fragment, int day)
   {
      Bundle bundle = new Bundle();
      bundle.putInt("count", day);

      fragment.setArguments(bundle);
      getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
   }

   @Override
   public boolean onMenuItemClick(MenuItem item) {
      return false;
   }

   // this method displays the pop up menu from the top
   public void showPopup(View v)
   {
      PopupMenu the_pop = new PopupMenu(this, v);
      the_pop.setOnMenuItemClickListener(this);
      the_pop.inflate(R.menu.home_nav_menu);
      the_pop.show();
   }

   private String setStringDate(int pos)
   {
      Calendar cal = horizontalCalendar.getDateAt(pos);

      cal.add(Calendar.DATE,day_offset);
      SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");

      String formatted = format1.format(cal.getTime());

      return formatted;
   }
} // end MainActivity