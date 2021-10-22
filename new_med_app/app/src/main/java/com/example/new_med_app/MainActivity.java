package com.example.new_med_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.new_med_app.Model.Medication;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{

    BottomNavigationView test_bar;
    FrameLayout frameLayout;

    private ImageView lines;
    private ImageView settinds;

    private Fragment opening_fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // open with home fragment
        opening_fragment = new FragmentHome();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                opening_fragment).commit();

        test_bar = findViewById(R.id.bottom_nav);

   //     add_icon = findViewById(R.id.add_icon);
        test_bar.setOnNavigationItemSelectedListener(navListener);

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

                Toast.makeText(MainActivity.this, "TITLE" , Toast.LENGTH_LONG).show();

            }
        });







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
                                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                                        selectedFragment).commit();

                            Toast.makeText(MainActivity.this, "HOME!!!!" , Toast.LENGTH_LONG).show();
                            break;

                        case R.id.refill_icon:

                               /* selectedFragment = new NextFragment();
                                getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                                        selectedFragment).commit();*/
                            Toast.makeText(MainActivity.this, "REFILL!!!!" , Toast.LENGTH_LONG).show();


                            break;

                        case R.id.doctor_info:
                            test_bar.setBackgroundResource(R.color.black);
                            selectedFragment = new FragmentDocInfo();

                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,
                                    selectedFragment).commit();

                        //    Toast.makeText(MainActivity.this, "DOCTOR INFO!!!!" , Toast.LENGTH_LONG).show();
                            break;
                    }

                    return true;
                }
            };

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
} // end MainActivity