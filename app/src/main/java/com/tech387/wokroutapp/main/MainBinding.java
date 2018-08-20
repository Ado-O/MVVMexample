package com.tech387.wokroutapp.main;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tech387.wokroutapp.main.exercises.RecycleViewAdapterOne;

import java.util.List;

public class MainBinding {

    //image
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:loadImage"})
    public static void setImage(ImageView view, String img){
        //img
        Glide.with(view.getContext())
                .load(img)
                .into(view);
    }


    @SuppressWarnings("unchecked")
    @BindingAdapter("app:exercise")
    public static void setExercise(RecyclerView recyclerView, List items) {
        RecycleViewAdapterOne adapter = (RecycleViewAdapterOne) recyclerView.getAdapter();
        if (adapter != null && items != null) {
            adapter.setExercise(items);
        }
    }

}
