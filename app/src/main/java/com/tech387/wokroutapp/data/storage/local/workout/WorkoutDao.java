package com.tech387.wokroutapp.data.storage.local.workout;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tech387.wokroutapp.data.Workout;

import java.util.List;

@Dao
public interface WorkoutDao {
    //onCOnfilctStrategy we we identify the duplicate data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Workout> workouts);

    //in this line we teak everting from workout table
    @Query("SELECT * FROM workout_table")
    List<Workout> getWorkouts();
}
