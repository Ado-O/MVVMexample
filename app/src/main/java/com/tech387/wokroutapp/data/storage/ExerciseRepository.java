package com.tech387.wokroutapp.data.storage;

import android.util.Log;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.storage.local.exercise.ExerciseLocalDataSource;

import java.util.List;

public class ExerciseRepository {

    public static final String TAG = ExerciseRepository.class.getSimpleName();

    private static ExerciseRepository sInstance = null;

    private final ExerciseLocalDataSource mExerciseLocalDataSource;

    public ExerciseRepository(ExerciseLocalDataSource exerciseLocalDataSource) {
        mExerciseLocalDataSource = exerciseLocalDataSource;
    }

    public static ExerciseRepository getInstance(ExerciseLocalDataSource exerciseLocalDataSource) {
        if (sInstance == null) {
            sInstance = new ExerciseRepository(exerciseLocalDataSource);
        }
        return sInstance;
    }


    public void getExercises(final GetExerciseCallback callback) {
        mExerciseLocalDataSource.getExercises(new ExerciseLocalDataSource.GetExerciseCallback() {
            @Override
            public void onSuccess(List<Exercise> exercises) {

                Log.e(TAG, String.valueOf(exercises.size()));
                callback.onSuccess(exercises);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });
    }

    public interface GetExerciseCallback {
        void onSuccess(List<Exercise> exercises);

        void onError();
    }
}
