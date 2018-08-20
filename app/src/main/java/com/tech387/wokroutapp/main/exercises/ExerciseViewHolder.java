package com.tech387.wokroutapp.main.exercises;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.tech387.wokroutapp.databinding.ListItemBinding;
import android.view.View;

import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.util.RecyclerViewClickListener;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {

    private RecyclerViewClickListener mListener;
    private ListItemBinding mBinding;

    public ExerciseViewHolder(@NonNull ListItemBinding binding, final RecyclerViewClickListener listener) {
        super(binding.getRoot());

        mBinding = binding;
        mBinding.setListener(listener);
    }

    public void setup(Exercise exercise) {

        mBinding.setExercise(exercise);

    }

}