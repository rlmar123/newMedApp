package com.example.medication_app.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.medication_app.Model.Medication;

import java.util.List;

@Dao
public interface MedicationDao
{
    // CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Medication medication);


    @Query("DELETE FROM medication_table")
    void deleteAll();

    @Query("SELECT * FROM medication_table ORDER BY med_name ASC")
    LiveData<List<Medication>> getAllMedications();

    @Query("SELECT * FROM medication_table WHERE medication_table.id == :id")
    LiveData<Medication> get(int id);

    @Query("SELECT * FROM medication_table WHERE :target BETWEEN begin_date AND end_date")
    LiveData<List<Medication>> getTodaysMeds(int target);

    @Update
    void update(Medication medication);

    @Delete
    void delete(Medication medication);

} //end MedicationDao