package com.tech387.wokroutapp.main.wokrouts;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.tech387.wokroutapp.data.Workout;
import com.tech387.wokroutapp.databinding.ListItemTwoBinding;

public class WorkoutViewHolder extends RecyclerView.ViewHolder {

    private ListItemTwoBinding mBinding;

    public WorkoutViewHolder(@NonNull ListItemTwoBinding binding) {
        super(binding.getRoot());
        mBinding = binding;

    }

    public void setup(Workout workout) {

        mBinding.setWorkout(workout);

    }
}