package com.example.medication_app.Model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.medication_app.data.MedicationRepository;
import com.example.medication_app.util.CONSTANTS;

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

/*    public static List<Medication> changeArray(List<Medication> medications, int days)
    {
        List<Medication> temp = medications;


   //     medications.remove(0);
     *//*   for(int i = 0; i < medications.size(); i++)
        {
            int begin = medications.get(i).getBeginDate();
            int end = medications.get(i).getEndDate();

            ArrayList <Integer> dates = new ArrayList<>();

            Log.d("from CHANGE ", "SIZE " + end);

         *//**//*   Log.d("from CHANGE ", "dayES " + days);
            for(int n = begin; n <= end; i++)
            {
                dates.add(n);

                Log.d("from CHANGE ", "daTES" + n);
            }*//**//*
        }*//*



        Log.d("from CHANGE ", "dayES " + days);
        return temp;

    }*/

    public static int julianDate(String the_date)
    {
        HashMap <Integer, Integer> calendar_days = new HashMap<>();
        int count = 0;

        int [] final_date = new int[4];
        int julian_date;
        int original_date = Integer.parseInt(the_date);

        int the_day = original_date % CONSTANTS.DIVIDE_BY;
        original_date = original_date / CONSTANTS.DIVIDE_BY;

        int the_month = original_date % CONSTANTS.DIVIDE_BY;
        int the_year = original_date / CONSTANTS.DIVIDE_BY;

        // add days for each month

        // Jan
        calendar_days.put(1, CONSTANTS.THIRTY_ONE);
        // Feb
        calendar_days.put(2, CONSTANTS.LEAP);
        // Mar
        calendar_days.put(3, CONSTANTS.THIRTY_ONE);
        // Apr
        calendar_days.put(4, CONSTANTS.THIRTY);
        // May
        calendar_days.put(5, CONSTANTS.THIRTY_ONE);
        // Jun
        calendar_days.put(6, CONSTANTS.THIRTY);
        // Jul
        calendar_days.put(7, CONSTANTS.THIRTY_ONE);
        // Aug
        calendar_days.put(8, CONSTANTS.THIRTY_ONE);
        // Sep
        calendar_days.put(9, CONSTANTS.THIRTY);
        // Oct
        calendar_days.put(10, CONSTANTS.THIRTY_ONE);
        // Nov
        calendar_days.put(11, CONSTANTS.THIRTY);
        // Dec
        calendar_days.put(12, CONSTANTS.THIRTY_ONE);


        for(int i = 1; i < the_month; i++)
        {
           count += calendar_days.get(i);
        }

       julian_date = count + the_day;
       Log.d("calendar", " " + the_year);
       Log.d("calendar", " " + the_month);
       Log.d("calendar", " " + the_day);

        return julian_date;
    }

    public static int getCurrentJulianDate() {return current_julian_date;}
    public static int getSelectedJulianDate() {return selected_julian_date;}

    public static void setCurrentJulianDate(int currentJulianDate) {current_julian_date = currentJulianDate;}

    public static void setSelectedJulianDate(int selectedJulianDate) {selected_julian_date = selectedJulianDate;}

} // end MedicationViewModel class