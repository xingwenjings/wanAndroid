package com.example.wan_android.ui.fragments;


import android.support.v4.app.Fragment;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.presenter.TodoBacklogPresenter;
import com.example.wan_android.view.TodoBacklogView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoBacklogFragment extends BaseFragment<TodoBacklogView, TodoBacklogPresenter>implements TodoBacklogView {

    @Override
    protected TodoBacklogPresenter initPresenter() {
        return new TodoBacklogPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_todo_backlog;
    }

}
