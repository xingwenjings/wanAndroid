package com.example.wan_android.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.view.EmptyView;

public class SearchChildActivity extends BaseActivity<EmptyView,EmptyPresenter> implements EmptyView{


    private static final String TAG = "SearchChildActivity";
    private String mQuery;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_child;
    }

    @Override
    protected void initView() {
        mQuery = getIntent().getStringExtra("query");
    }
}
