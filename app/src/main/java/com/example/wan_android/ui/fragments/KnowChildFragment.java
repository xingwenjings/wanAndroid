package com.example.wan_android.ui.fragments;

import android.annotation.SuppressLint;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.view.EmptyView;

@SuppressLint("ValidFragment")
public class KnowChildFragment extends BaseFragment<EmptyView,EmptyPresenter> implements EmptyView {
    private int id;
    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }
    @SuppressLint("ValidFragment")
    public KnowChildFragment(int id){
        this.id=id;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_know_child;
    }
}
