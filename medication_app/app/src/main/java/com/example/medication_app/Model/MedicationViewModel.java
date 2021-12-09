package com.example.medication_app.Model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.medication_app.data.MedicationRepository;

import java.util.HashMap;
import java.util.List;

public class MedicationViewModel extends AndroidViewModel
{
    public static MedicationRepository repository;
    public final LiveData<List<Medication>> allMeds;
    public LiveData<List<Medication>> todays_list;

    private static final int DIVIDE_BY = 100;

    private static final int LEAP = 28;
    private static final int THIRTY = 30;
    private static final int THIRTY_ONE = 31;

    // private int num = 0;



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

        int the_day = original_date % DIVIDE_BY;
        original_date = original_date / DIVIDE_BY;

        int the_month = original_date % DIVIDE_BY;
        int the_year = original_date / DIVIDE_BY;

        // add days for each month

        // Jan
        calendar_days.put(1, THIRTY_ONE);
        // Feb
        calendar_days.put(2, LEAP);
        // Mar
        calendar_days.put(3, THIRTY_ONE);
        // Apr
        calendar_days.put(4, THIRTY);
        // May
        calendar_days.put(5, THIRTY_ONE);
        // Jun
        calendar_days.put(6, THIRTY);
        // Jul
        calendar_days.put(7, THIRTY_ONE);
        // Aug
        calendar_days.put(8, THIRTY_ONE);
        // Sep
        calendar_days.put(9, THIRTY);
        // Oct
        calendar_days.put(10, THIRTY_ONE);
        // Nov
        calendar_days.put(11, THIRTY);
        // Dec
        calendar_days.put(12, THIRTY_ONE);


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



} // end MedicationViewModel class
