package com.example.new_med_app.util;


import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.new_med_app.Model.Doctor;
import com.example.new_med_app.Model.Medication;
import com.example.new_med_app.data.DoctorDao;


// add Medication.class
@Database(entities = {Doctor.class}, version = 1, exportSchema = false)
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
                        doctorDao.deleteAll();

                       Doctor doctor = new Doctor();
                       doctorDao.insert(doctor);

                     /*   contact = new Contact("Bond", "Spy");
                        contactDao.insert(contact);

                        contact = new Contact("Bruce", "Fighter");
                        contactDao.insert(contact);
*/

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

} //end class TheRoomDb
