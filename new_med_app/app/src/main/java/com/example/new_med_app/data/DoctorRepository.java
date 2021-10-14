package com.example.new_med_app.data;

import android.app.Application;


import java.util.List;

import androidx.lifecycle.LiveData;

import com.example.new_med_app.Model.Doctor;
import com.example.new_med_app.util.TheRoomDb;

public class DoctorRepository
{
    private DoctorDao doctorDao;
    private LiveData<List<Doctor>> allDoctors;

    public DoctorRepository(Application application)
    {
        TheRoomDb db = TheRoomDb.getDatabase(application);
        doctorDao = db.doctorDao();

        allDoctors = doctorDao.getAllDoctors();
    }

    public LiveData<Doctor> get(int id) {
        return doctorDao.get(id);
    }
    public LiveData<List<Doctor>> getAllData() { return allDoctors; }

    public void insert(Doctor doctor)
    {TheRoomDb.databaseWriteExecutor.execute(() -> doctorDao.insert(doctor));}

    public void update(Doctor doctor) {
        TheRoomDb.databaseWriteExecutor.execute(() -> doctorDao.update(doctor));
    }
    public void delete(Doctor doctor) {
        TheRoomDb.databaseWriteExecutor.execute(() -> doctorDao.delete(doctor));
    }




} // end DoctorRepository class
