package com.tech387.wokroutapp.data.storage.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.Workout;
import com.tech387.wokroutapp.data.storage.local.exercise.ExerciseDao;
import com.tech387.wokroutapp.data.storage.local.workout.WorkoutDao;

@Database(entities = {
        Exercise.class, Workout.class
}, version = 4, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ExerciseDao getExerciseDao();
    public abstract WorkoutDao getWorkoutDao();

    public static final Object sLock = new Object();

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app.db").build();
            }
            return INSTANCE;
        }
    }
}