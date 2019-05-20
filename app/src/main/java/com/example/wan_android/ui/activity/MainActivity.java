package com.example.wan_android.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.ui.adapters.MainAdapter;
import com.example.wan_android.ui.fragments.HomeFragment;
import com.example.wan_android.ui.fragments.KnowLedgeFragment;
import com.example.wan_android.ui.fragments.NavigationFragment;
import com.example.wan_android.ui.fragments.ProjectFragment;
import com.example.wan_android.ui.fragments.WeChatFragment;
import com.example.wan_android.view.EmptyView;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_fl)
    FrameLayout mainFl;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.dl)
    DrawerLayout dl;
        private ArrayList<BaseFragment> fragments;
    private FragmentManager mManager;
    private int mLastFragmentPosition = 0;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mManager=getSupportFragmentManager();
        initTitles();
        StatusBarUtil.setLightMode(this);
        initFragment();
        setSupportActionBar(toolbar);

        initFristFragment();

    }

    private void initFristFragment() {
        FragmentTransaction fragmentTransaction = mManager.beginTransaction();
        fragmentTransaction.add(R.id.main_fl,fragments.get(0));
        fragmentTransaction.commit();
    }

    private void initTitles() {
        tab.addTab(tab.newTab().setText(R.string.home).setIcon(R.drawable.select_home));
        tab.addTab(tab.newTab().setText(R.string.knowledge).setIcon(R.drawable.select_knowledge));
        tab.addTab(tab.newTab().setText(R.string.wechat).setIcon(R.drawable.select_wechat));
        tab.addTab(tab.newTab().setText(R.string.navigation).setIcon(R.drawable.select_navigation));
        tab.addTab(tab.newTab().setText(R.string.project).setIcon(R.drawable.select_project));
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new KnowLedgeFragment());
        fragments.add(new WeChatFragment());
        fragments.add(new NavigationFragment());
        fragments.add(new ProjectFragment());
    }

    @Override
    protected void initData() {


        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switchFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    private void switchFragment(int position) {
        FragmentTransaction transaction = mManager.beginTransaction();
        BaseFragment fragment = fragments.get(position);
        if (!fragment.isAdded()) {
            transaction.add(R.id.main_fl, fragment);
        }
        transaction.hide(fragments.get(mLastFragmentPosition));
        transaction.show(fragment);
        transaction.commit();
        mLastFragmentPosition = position;
    }

}
