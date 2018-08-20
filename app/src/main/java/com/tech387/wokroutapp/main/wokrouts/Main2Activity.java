package com.tech387.wokroutapp.main.wokrouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.tech387.wokroutapp.R;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = Main2Activity.class.getSimpleName();

    private Toolbar mToolbar;
    private int course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv2);

        //find view
        mToolbar = findViewById(R.id.second_tb);


        course = getIntent().getExtras().getInt("course");
        Log.e(TAG, String.valueOf(course));

        setupToolbar();
        setupImgData();
    }
    /**
     * toolbar
     */
    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("something");

        //setting up the back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }

    /**
     * get img from reposotory.class
     */
    public void setupImgData(){


               // Glide.with(Main2Activity.this)
              //          .load(videos.get(0).getImg())
               //         .into(mImageView);


    }
}
