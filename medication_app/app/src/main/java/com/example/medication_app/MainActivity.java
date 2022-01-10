package com.example.medication_app;


import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import com.example.medication_app.Model.MedicationViewModel;
import com.example.medication_app.util.CONSTANTS;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{
   BottomNavigationView test_bar;
   FrameLayout frameLayout;

   private HorizontalCalendar horizontalCalendar;

   private String formatted;

   private Fragment opening_fragment = null;
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // store today's date in the viewModel
      MedicationViewModel.setCurrentJulianDate(getTodaysDate());

      Log.d("FROM Main", "getTodaysDate " + MedicationViewModel.getCurrentJulianDate());

      test_bar = findViewById(R.id.bottom_nav);

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
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
         public void onDateSelected(Calendar date, int position)
         {

            formatted = setStringDate(position);
            int selectedDate = MedicationViewModel.julianDate(formatted);

            // here!!! 22XXX
            MedicationViewModel.setSelectedJulianDate(MedicationViewModel.dateFormatter(selectedDate));
            changeFragment(new FragmentHome(), CONSTANTS.SELECTED);

            Toast.makeText(MainActivity.this, "REFILL!!!!" + MedicationViewModel.getSelectedJulianDate(), Toast.LENGTH_LONG).show();

         }
      });

      // set opening fragment to home and today's date
      opening_fragment = new FragmentHome();
      changeFragment(opening_fragment, CONSTANTS.CURRENT);
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
                       changeFragment(selectedFragment, CONSTANTS.CURRENT);
                       horizontalCalendar.show();

                       Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_LONG).show();
                       break;

                    case R.id.refill_icon:

                       /*selectedFragment = new NextFragment();*/
                       break;

                    case R.id.doctor_info:
                       test_bar.setBackgroundResource(R.color.black);

                       selectedFragment = new FragmentDocInfo();
                       changeFragment(selectedFragment, "hey");

                       horizontalCalendar.hide();

                       break;
                 }

                 return true;
              }
           };

   private void changeFragment(Fragment fragment, String day)
   {
      Bundle bundle = new Bundle();
      bundle.putString(CONSTANTS.COUNT, day);

      fragment.setArguments(bundle);
      getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.main_frame, fragment).commit();
      //getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
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

      cal.add(Calendar.DATE, CONSTANTS.DAY_OFFSET);
      SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");

      String formatted = format1.format(cal.getTime());

      return formatted;
   }

   private Integer getTodaysDate()
   {
      Date now = new Date();

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(now);

      Integer today = calendar.get(Calendar.DAY_OF_YEAR);

      return MedicationViewModel.dateFormatter(today);
   }
} // end MainActivity