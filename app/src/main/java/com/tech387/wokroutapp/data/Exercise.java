package com.tech387.wokroutapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "exercise_table")
public class Exercise {

    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    private long mId;

    @ColumnInfo(name = "raw_name")
    private String mRawName;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "image")
    private String mImg;

    public Exercise(long id, String rawName, String title, String img) {
        mId = id;
        mRawName = rawName;
        mTitle = title;
        mImg = img;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getImg() {
        return mImg;
    }

    public void setImg(String img) {
        mImg = img;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getRawName() {
        return mRawName;
    }

    public void setRawName(String rawName) {
        mRawName = rawName;
    }
}
