package com.example.medication_app.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.medication_app.data.DoctorRepository;

import java.util.List;

public class DoctorViewModel extends AndroidViewModel
{
    public static DoctorRepository repository;
    public final LiveData<List<Doctor>> allDocs;

    public DoctorViewModel(@NonNull Application application) {
        super(application);
        repository = new DoctorRepository(application);
        allDocs = repository.getAllData();
    }

    public LiveData<List<Doctor>> getDoctors() { return allDocs; }
    public static void insert(Doctor doctor) {repository.insert(doctor);}

    public LiveData<Doctor> get(int id)
    { return repository.get(id);}

    public static void update(Doctor doctor) {repository.update(doctor);}
    public static void delete(Doctor doctor) {repository.delete(doctor);}



} // end DoctorViewModel class
