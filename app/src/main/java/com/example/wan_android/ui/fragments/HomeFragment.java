package com.example.wan_android.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.wan_android.Adapet.HollAdapet;
import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.HollBannerbean;
import com.example.wan_android.bean.HollListbean;
import com.example.wan_android.bean.HollZhidingbean;
import com.example.wan_android.presenter.HollPresenter;
import com.example.wan_android.ui.activity.HollListdetailsActivity;
import com.example.wan_android.ui.activity.HollZhidingdetailsActivity;
import com.example.wan_android.util.Logger;
import com.example.wan_android.view.HollView;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.http.POST;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HollView, HollPresenter> implements HollView {


    @BindView(R.id.re_cyclerView)
    RecyclerView mReCyclerView;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    private List<HollListbean.DataBean.DatasBean> mholllist;
    private List<HollBannerbean.DataBean> mhollbanner;
    private HollAdapet mhollAdapet;
    private List<HollZhidingbean.DataBean> mhollZhiding;
    private int page;

    @Override
    protected HollPresenter initPresenter() {
        return new HollPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
    @Override
    protected void initData() {
        page = 0;
        //https://www.wanandroid.com/banner/json
        mPresenter.getBannerData("banner/json");
        mPresenter.getListData("article/list/" + page + "/json");
        mPresenter.getZhiDingData("article/top/json");
    }

    @Override
    protected void initView() {
        mhollbanner = new ArrayList<>();
        mholllist = new ArrayList<>();
        mhollZhiding = new ArrayList<>();
        mReCyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mhollAdapet = new HollAdapet(getContext(), mhollbanner, mholllist, mhollZhiding);
        mReCyclerView.setAdapter(mhollAdapet);
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.getListData("article/list/" + page + "/json");
                mPresenter.getZhiDingData("article/top/json");
                mhollAdapet.notifyDataSetChanged();
                mSmart.finishRefresh();
            }
        });
        mSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.getListData("article/list/" + page + "/json");
                mPresenter.getZhiDingData("article/top/json");
                mhollAdapet.notifyDataSetChanged();
                mSmart.finishLoadMore();
            }
        });
    }

    @Override
    protected void initListener() {
        mhollAdapet.setOnItemClickListener(new HollAdapet.OnItemClickListener() {
            @Override
            public void OnItemClick(View v, int position) {
                Intent intent = new Intent(getContext(), HollListdetailsActivity.class);
                intent.putExtra(Constants.TITLE,mholllist.get(position).getTitle());
                intent.putExtra(Constants.URL,mholllist.get(position).getLink());
                getContext().startActivity(intent);
            }
        });
    }

    @Override
    public void setListData(String bean) {
        Logger.logD("holllist", "" + bean);
        Gson gson = new Gson();
        HollListbean emptyHollbean = gson.fromJson(bean, HollListbean.class);
        if (emptyHollbean.getData() != null
                && emptyHollbean.getData().getDatas() != null
                && emptyHollbean.getData().getDatas().size() > 0) {
            mholllist = emptyHollbean.getData().getDatas();
            mhollAdapet.setListData(mholllist);
        }
    }

    @Override
    public void setZhidingData(String bean) {
        Logger.logD("hollBanner", "" + bean);
        Gson gson = new Gson();
        HollZhidingbean bannerbean = gson.fromJson(bean, HollZhidingbean.class);
        if (bannerbean.getData() != null
                && bannerbean.getData().size() > 0) {
            mhollZhiding = bannerbean.getData();
            mhollAdapet.setZhiding(mhollZhiding);
        }
    }

    @Override
    public void setBannerData(String bean) {
        Logger.logD("hollBanner", "" + bean);
        Gson gson = new Gson();
        HollBannerbean bannerbean = gson.fromJson(bean, HollBannerbean.class);
        if (bannerbean.getData() != null
                && bannerbean.getData().size() > 0) {
            mhollbanner = bannerbean.getData();
            mhollAdapet.setBanner(mhollbanner);
        }
    }

}
