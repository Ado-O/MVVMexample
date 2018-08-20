package com.tech387.wokroutapp.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.tech387.wokroutapp.Injection;
import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.storage.ContentRepository;
import com.tech387.wokroutapp.data.storage.ExerciseRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private ContentRepository mContentRepository;
    private ExerciseRepository mExerciseRepository;
    private Context mContext;

    public final ObservableList<Exercise> mItems = new ObservableArrayList<>();
    public final ObservableBoolean mError = new ObservableBoolean(false);

    public MainViewModel(@NonNull Application application,
                         Context context,
                         ContentRepository contentRepository,
                         ExerciseRepository exerciseRepository) {
        super(application);
        mContext = context;
        mContentRepository = contentRepository;
        mExerciseRepository = exerciseRepository;
    }

    public void start() {
        if (mItems.isEmpty()) {
            getExercise();
        }
    }

    public void getExercise() {
        mContentRepository = Injection.provideContentRepository(mContext);
        mContentRepository.getContent();

        mExerciseRepository = Injection.provideExerciseRepository(mContext);
        mExerciseRepository.getExercises(new ExerciseRepository.GetExerciseCallback() {
            @Override
            public void onSuccess(List<Exercise> exercises) {
                mItems.clear();
                mItems.addAll(exercises);
                mError.set(mItems.isEmpty());
            }

            @Override
            public void onError() {
                mError.set(true);
            }
        });

    }
}
