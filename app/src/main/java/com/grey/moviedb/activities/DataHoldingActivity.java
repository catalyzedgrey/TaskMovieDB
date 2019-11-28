package com.grey.moviedb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.grey.moviedb.R;
import com.grey.moviedb.interfaces.IService;

public abstract class DataHoldingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract void initViews();

    protected abstract void prepareData();
}
