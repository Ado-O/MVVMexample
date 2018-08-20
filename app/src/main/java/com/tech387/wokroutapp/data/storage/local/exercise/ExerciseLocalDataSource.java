package com.tech387.wokroutapp.data.storage.local.exercise;

import android.util.Log;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.storage.convertor.RemoteToLocal;
import com.tech387.wokroutapp.data.storage.remote.response.ExerciseResponse;
import com.tech387.wokroutapp.util.AppExecutors;

import java.util.List;

public class ExerciseLocalDataSource {

    private static final String TAG = ExerciseLocalDataSource.class.getSimpleName();

    private static ExerciseLocalDataSource sInstance = null;

    private final ExerciseDao mExerciseDao;
    private final AppExecutors mAppExecutors;

    private ExerciseLocalDataSource(ExerciseDao exerciseDao, AppExecutors appExecutors) {
        mExerciseDao = exerciseDao;
        mAppExecutors = appExecutors;
    }

    public static ExerciseLocalDataSource getInstance(ExerciseDao exerciseDao, AppExecutors appExecutors) {
        if (sInstance == null) {
            sInstance = new ExerciseLocalDataSource(exerciseDao, appExecutors);
        }
        return sInstance;
    }

    /**
     * insert and get data from db
     */
    public void insertExercise(List<ExerciseResponse> exerciseResponses) {
        mExerciseDao.insert(RemoteToLocal.exerciseConverter(exerciseResponses));
        Log.e(TAG, String.valueOf(exerciseResponses.get(0).getName()));

    }

    public void getExercises(final GetExerciseCallback callback) {
        mAppExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Exercise> exercises = mExerciseDao.getExercise();

                Log.e(TAG, String.valueOf(exercises.size()));

                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(exercises);
                    }
                });
            }
        });


    }


    public interface GetExerciseCallback {
        void onSuccess(List<Exercise> exercises);

        void onError();
    }


}



