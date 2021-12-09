package com.example.medication_app.util;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.medication_app.Model.Doctor;
import com.example.medication_app.Model.Medication;
import com.example.medication_app.data.DoctorDao;
import com.example.medication_app.data.MedicationDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// add Medication.class
@Database(entities = {Doctor.class, Medication.class}, version = 1, exportSchema = false)
public abstract class TheRoomDb extends RoomDatabase
{
    public static final int NUMBER_OF_THREADS = 4;

    // helps run things in the back thread
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile TheRoomDb INSTANCE;

    private static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    // clears db
                    databaseWriteExecutor.execute(() -> {
                        DoctorDao doctorDao = INSTANCE.doctorDao();
                        MedicationDao medicationDao = INSTANCE.medicationDao();
                        doctorDao.deleteAll();
                        medicationDao.deleteAll();


                    });
                }
            };

    // db is built here
    public static TheRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TheRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TheRoomDb.class, "med_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract DoctorDao doctorDao();
    public abstract MedicationDao medicationDao();

} //end class TheRoomDb
