package com.example.wan_android.ui.activity;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.view.EmptyView;

public class SettingsActivity extends BaseActivity<EmptyView,EmptyPresenter> implements EmptyView {
    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }
}
