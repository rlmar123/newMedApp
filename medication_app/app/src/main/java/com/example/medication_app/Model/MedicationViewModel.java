package com.example.medication_app.Model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.medication_app.data.MedicationRepository;
import com.example.medication_app.util.CONSTANTS;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MedicationViewModel extends AndroidViewModel
{
   public static MedicationRepository repository;

   public final LiveData<List<Medication>> allMeds;
   public LiveData<List<Medication>> todays_list;

   private static int current_julian_date;
   private static int selected_julian_date;

   public MedicationViewModel(@NonNull Application application)
   {
      super(application);

      repository = new MedicationRepository(application);
      allMeds = repository.getAllData();
   }

   public LiveData<List<Medication>> getMedicines(int num) {return allMeds;}

   public LiveData<List<Medication>> getToday(int num)
   {
      todays_list = repository.getToday(num);
      return todays_list;
   }

   public static void insert(Medication medication) {repository.insert(medication);}
   public LiveData<Medication> get(int id) {return repository.get(id);}
   public static void update(Medication medication) {repository.update(medication);}
   public static void delete(Medication medication) {repository.delete(medication);}

   // converts YYYYMMDD to julian date
   public static int julianDate(String the_date)
   {
      HashMap <Integer, Integer> calendar_days = new HashMap<>();
      int count = 0;

      int julian_date;
      int original_date = Integer.parseInt(the_date);

      int the_day = original_date % CONSTANTS.DIVIDE_BY;
      original_date = original_date / CONSTANTS.DIVIDE_BY;

      int the_month = original_date % CONSTANTS.DIVIDE_BY;
      int the_year = original_date / CONSTANTS.DIVIDE_BY;

      calendar_days = CONSTANTS.loadDays();

      for(int i = 1; i < the_month; i++)
      {
         count += calendar_days.get(i);
      }

      julian_date = count + the_day;

      return julian_date;
   }

   public static int dateFormatter(Integer n)
   {
      String test;

      if((n >= 1) && (n <= 9))
      {
         test = getPrefix() + "00" + n;
         n = Integer.parseInt(test);
      }

      else if((n >= 10) && (n <= 99))
      {
         test = getPrefix() + "0" + n;
         n = Integer.parseInt(test);
      }

      else if(n >= 100)
      {
         test = getPrefix() + n;
         n = Integer.parseInt(test);
      }

      return n;
   }
   public static int getCurrentJulianDate() {return current_julian_date;}
   public static int getSelectedJulianDate() {return selected_julian_date;}
   public static void setCurrentJulianDate(int currentJulianDate) {current_julian_date = currentJulianDate;}
   public static void setSelectedJulianDate(int selectedJulianDate) {selected_julian_date = selectedJulianDate;}


   public static String getPrefix()
   {
      String prefix;
      Date now = new Date();

      Calendar calendar = Calendar.getInstance();
      calendar.setTime(now);

      Integer year = calendar.get(Calendar.YEAR);
      year = year % CONSTANTS.DIVIDE_BY;
      prefix = Integer.toString(year);

      return prefix;
   }

} // end MedicationViewModel class
