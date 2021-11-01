package com.example.new_med_app.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.new_med_app.Model.Medication;

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

    @Update
    void update(Medication medication);

    @Delete
    void delete(Medication medication);

} // end MedicationDao interface