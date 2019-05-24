package com.example.wan_android.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.presenter.TodoOffPresenter;
import com.example.wan_android.view.TodoOffView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoOffFragment extends BaseFragment<TodoOffView, TodoOffPresenter>implements TodoOffView {

    @Override
    protected TodoOffPresenter initPresenter() {
        return new TodoOffPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_todo_off;
    }

}
