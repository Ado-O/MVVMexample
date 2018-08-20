package com.tech387.wokroutapp.main.exercises;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech387.wokroutapp.Injection;
import com.tech387.wokroutapp.R;
import com.tech387.wokroutapp.data.Exercise;
import com.tech387.wokroutapp.data.storage.ContentRepository;
import com.tech387.wokroutapp.data.storage.ExerciseRepository;
import com.tech387.wokroutapp.databinding.MainOneFragBinding;
import com.tech387.wokroutapp.main.MainViewModel;
import com.tech387.wokroutapp.main.other.FourFragment;
import com.tech387.wokroutapp.main.wokrouts.Main2Activity;
import com.tech387.wokroutapp.util.RecyclerViewClickListener;

import java.util.List;

public class ExerciseFragment extends Fragment implements RecyclerViewClickListener {

    Context mContext;
    private MainOneFragBinding mBinding;
    private RecycleViewAdapterOne mRecycleViewAdapter;
    private MainViewModel mViewModel; //how to assigned


    public static ExerciseFragment newInstance() {
        return new ExerciseFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          mBinding = MainOneFragBinding.inflate(inflater, container, false);

        mContext = getActivity();

        mViewModel.start();

        mBinding.setViewModel(mViewModel);

        setupRv();

        return mBinding.getRoot();
    }

    public void setupRv() {


        mRecycleViewAdapter = new RecycleViewAdapterOne(
                mContext,
                mViewModel.mItems, //??
                ExerciseFragment.this);

        mBinding.rvOneFrag.setLayoutManager(new GridLayoutManager(mContext, 2));
        mBinding.rvOneFrag.setAdapter(mRecycleViewAdapter);

    }

    @Override
    public void recyclerViewListClicked(View v, Exercise exercise) {
        Intent intent = new Intent(mContext, Main2Activity.class);
        intent.putExtra("course", exercise.getId());
        mContext.startActivity(intent);
    }

}
