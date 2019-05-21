package com.example.wan_android.ui.fragments;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.wan_android.R;
import com.example.wan_android.ui.adapters.NaviRlvAdapter;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.NavigationBean;
import com.example.wan_android.presenter.NaviPresenter;
import com.example.wan_android.view.NaviView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends BaseFragment<NaviView, NaviPresenter> implements NaviView {


    private static final String TAG = "NavigationFragment";
    @BindView(R.id.tablayout)
    VerticalTabLayout mTablayout;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
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


    @Override
    protected void initListener() {
        //RecyclerView与tab联动
        mRlv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d(TAG, "onScrolled: "+mManager.findFirstVisibleItemPosition()+",dy:"+dy);
                mTablayout.setTabSelected(mManager.findFirstVisibleItemPosition());
            }
        });


        //tab与RecyclerView联动
        mTablayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                Log.d(TAG, "onTabSelected: "+tab.getTitle()+",position:"+position);
                mManager.scrollToPositionWithOffset(position,0);
            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });
    }
}
