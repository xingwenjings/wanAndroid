package com.example.wan_android.ui.fragments;


import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.wan_android.R;
import com.example.wan_android.ui.activity.NaviWebViewActivity;
import com.example.wan_android.ui.adapters.NaviRlvAdapter;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.NavigationBean;
import com.example.wan_android.presenter.NaviPresenter;
import com.example.wan_android.util.ToastUtil;
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


    @BindView(R.id.tablayout)
    VerticalTabLayout mTablayout;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    Unbinder unbinder;
    private NaviRlvAdapter mAdapter;
    private LinearLayoutManager mManager;
    private ArrayList<NavigationBean.DataBean> mList;

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
        mList = new ArrayList<>();
        mAdapter = new NaviRlvAdapter(getContext(), mList);
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
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
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

        mAdapter.setonClickListener(new NaviRlvAdapter.onClickListener() {
            @Override
            public void clickListener(int position, int childPosition) {
                List<NavigationBean.DataBean.ArticlesBean> list = mList.get(position).getArticles();
                NavigationBean.DataBean.ArticlesBean bean = list.get(childPosition);
                String title = bean.getTitle();
                String link = bean.getLink();
                Intent intent = new Intent(getContext(), NaviWebViewActivity.class);
                intent.putExtra(Constants.LINK,link);
                intent.putExtra(Constants.NAME,title);
                intent.putExtra(Constants.ID,bean.getId());
                startActivity(intent);
            }
        });

    }
}
