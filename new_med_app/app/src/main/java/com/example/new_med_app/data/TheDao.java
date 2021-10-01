package com.example.new_med_app.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.new_med_app.Model.Medication;

import java.util.List;

public interface TheDao
{
    //CRUD ops

    @Insert
    void insert(Medication theMed);

    @Query("DELETE FROM the_medicine_table")
    void deleteEverything();

    @Query("DELETE FROM the_medicine_table WHERE id = :delete_id")
    int deleteNoDoItem(int delete_id);

    @Query("UPDATE the_medicine_table SET the_med_name_col = :some_text WHERE id = :update_id")
    int updateMedicineName(int update_id, String some_text);

    //live data here
    @Query("SELECT * FROM the_medicine_table ORDER BY the_no_do_col DESC")
    LiveData<List<Medication>> getAllItems();

}
