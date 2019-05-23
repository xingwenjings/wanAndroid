package com.example.wan_android.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.view.EmptyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {


    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.tv)
    TextView mTv;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect;
    }

    @OnClick(R.id.img)
    public void onClick() {
        finish();
    }
}
