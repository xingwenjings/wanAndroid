package com.example.wan_android.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.bean.ClassifyBean;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.presenter.ProjectPresenter;
import com.example.wan_android.ui.adapters.VpProjectAdapter;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.ProjectView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectFragment extends BaseFragment<ProjectView, ProjectPresenter> implements ProjectView {


    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    private ArrayList<Fragment> mFragments;
    private VpProjectAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }



    @Override
    protected ProjectPresenter initPresenter() {
        return new ProjectPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void setData(ClassifyBean bean) {
        mFragments = new ArrayList<>();
        List<ClassifyBean.DataBean> list = bean.getData();
        for (int i = 0; i < list.size(); i++) {
            mFragments.add(new ProjecctClassifyFragment(list.get(i).getId()));
            mTab.addTab(mTab.newTab().setText(list.get(i).getName()));
        }
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));

        mAdapter = new VpProjectAdapter(getChildFragmentManager(), mFragments);
        mVp.setAdapter(mAdapter);
    }
}
