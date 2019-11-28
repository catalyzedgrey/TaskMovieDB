package com.grey.moviedb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.grey.moviedb.interfaces.IService;

import java.util.List;

public abstract class OnlineDataHoldingActivity extends DataHoldingActivity implements IService {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public abstract void onTaskCompleted(List objects);
}
