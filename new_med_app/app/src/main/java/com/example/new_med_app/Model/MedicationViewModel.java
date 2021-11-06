package com.example.new_med_app.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.new_med_app.data.MedicationRepository;

import java.util.List;

public class MedicationViewModel extends AndroidViewModel
{
    public static MedicationRepository repository;
    public final LiveData<List<Medication>> allMeds;

    public MedicationViewModel(@NonNull Application application)
    {
        super(application);
        repository = new MedicationRepository(application);
        allMeds = repository.getAllData();
    }

    public LiveData<List<Medication>> getMedicines() {return allMeds; }
    public static void insert(Medication medication) {repository.insert(medication);}

    public LiveData<Medication> get(int id)
    { return repository.get(id);}

    public static void update(Medication medication) {repository.update(medication);}
    public static void delete(Medication medication) {repository.delete(medication);}



} // end MedicationViewModel class
