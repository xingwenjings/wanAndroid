package com.example.wan_android.ui.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wan_android.R;
import com.example.wan_android.adapter.NaviRlvAdapter;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.NavigationBean;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.presenter.NaviPresenter;
import com.example.wan_android.util.UIUtils;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.NaviView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends BaseFragment<NaviView, NaviPresenter> implements NaviView {


    @BindView(R.id.tablayout)
    VerticalTabLayout mTablayout;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    Unbinder unbinder;
    private NaviRlvAdapter mAdapter;
    private LinearLayoutManager mManager;

    @Override
    protected NaviPresenter initPresenter() {
        return new NaviPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initView() {
        mManager = new LinearLayoutManager(getContext());
        mRlv.setLayoutManager(mManager);
        ArrayList<NavigationBean.DataBean> list = new ArrayList<>();
        mAdapter = new NaviRlvAdapter(getContext(), list);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        mPresenter.initData();
    }

    @Override
    public void setData(NavigationBean bean) {
        if (bean.getErrorCode() == Constants.SUCCESS_CODE){
            final List<NavigationBean.DataBean> list = bean.getData();
            mTablayout.setTabAdapter(new TabAdapter() {
                @Override
                public int getCount() {
                    return list.size();
                }

                @Override
                public ITabView.TabBadge getBadge(int position) {
                    return null;
                }

                @Override
                public ITabView.TabIcon getIcon(int position) {
                    return null;
                }

                @Override
                public ITabView.TabTitle getTitle(int position) {
                    return new ITabView.TabTitle.Builder()
                            .setContent(list.get(position).getName()).build();
                }

                @Override
                public int getBackground(int position) {
                    return 0;
                }
            });
        }
        mAdapter.addData(bean.getData());
    }

    @Override
    public void onFail(String msg) {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initListener() {
        //RecyclerView与tab联动
        mRlv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                mTablayout.setTabSelected(mManager.findFirstVisibleItemPosition());
            }
        });
        //tab与RecyclerView联动
        mTablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                mManager.scrollToPositionWithOffset(position,0);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }
}
