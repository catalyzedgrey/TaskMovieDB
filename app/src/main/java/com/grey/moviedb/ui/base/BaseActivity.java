package com.grey.moviedb.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.grey.moviedb.MvpApp;
import com.grey.moviedb.R;
import com.grey.moviedb.di.component.ActivityComponent;
import com.grey.moviedb.di.component.DaggerActivityComponent;
import com.grey.moviedb.di.module.ActivityModule;
import com.grey.moviedb.util.CommonUtils;

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView,BaseFragment.Callback {
    private ProgressDialog mProgressDialog;
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MvpApp) getApplication()).getComponent())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        }
    }

    private void showSnackBar(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show();
        }
    }
}
