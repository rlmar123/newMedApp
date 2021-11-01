package com.example.new_med_app.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.new_med_app.Model.Doctor;
import com.example.new_med_app.Model.Medication;
import com.example.new_med_app.util.TheRoomDb;

import java.util.List;

public class MedicationRepository
{
    private MedicationDao medicationDao;
    private LiveData<List<Medication>> allMedicines;

    public MedicationRepository(Application application)
    {
        TheRoomDb db = TheRoomDb.getDatabase(application);
        medicationDao = db.medicationDao();

        allMedicines = medicationDao.getAllMedications();
    }

    public LiveData<Medication> get(int id) {
        return medicationDao.get(id);
    }
    public LiveData<List<Medication>> getAllData() { return allMedicines; }

    public void insert(Medication medication)
    {TheRoomDb.databaseWriteExecutor.execute(() -> medicationDao.insert(medication));}

    public void update(Medication medication) {
        TheRoomDb.databaseWriteExecutor.execute(() -> medicationDao.update(medication));
    }
    public void delete(Medication medication) {
        TheRoomDb.databaseWriteExecutor.execute(() -> medicationDao.delete(medication));
    }




} // end DoctorRepository class
