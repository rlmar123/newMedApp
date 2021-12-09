package com.example.medication_app.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.medication_app.Model.Doctor;

import java.util.List;

@Dao
public interface DoctorDao
{
    // CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Doctor contact);

    @Query("DELETE FROM doctor_table")
    void deleteAll();

    @Query("SELECT * FROM doctor_table ORDER BY l_name ASC")
    LiveData<List<Doctor>> getAllDoctors();

    @Query("SELECT * FROM doctor_table WHERE doctor_table.id == :id")
    LiveData<Doctor> get(int id);

    @Update
    void update(Doctor doctor);

    @Delete
    void delete(Doctor doctor);

} // end DoctorDao interface
