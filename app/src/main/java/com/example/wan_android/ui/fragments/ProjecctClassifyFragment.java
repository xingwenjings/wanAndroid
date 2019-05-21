package com.example.wan_android.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.bean.ListBean;
import com.example.wan_android.presenter.ProjectClassPresenter;
import com.example.wan_android.ui.activity.ParticularActivity;
import com.example.wan_android.ui.adapters.RlvProjectClassifyAdapter;
import com.example.wan_android.view.ProjectClassifyView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/21
 * 项目工作空间：wanAndroid
 */
@SuppressLint("ValidFragment")
public class ProjecctClassifyFragment extends BaseFragment<ProjectClassifyView, ProjectClassPresenter> implements ProjectClassifyView {
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    Unbinder unbinder;
    private int cid;
    private int page = 1;
    private ArrayList<ListBean.DataBean.DatasBean> mList;
    private RlvProjectClassifyAdapter mAdapter;

    public ProjecctClassifyFragment(int id) {
        this.cid = id;
    }

    @Override
    protected ProjectClassPresenter initPresenter() {
        return new ProjectClassPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_classify_project;
    }

    @Override
    public void setData(ListBean bean) {
        mList.addAll(bean.getData().getDatas());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        mPresenter.getData(page,cid);
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRlv.setLayoutManager(manager);
        mList = new ArrayList<>();
        mAdapter = new RlvProjectClassifyAdapter(getActivity(),mList);
        mRlv.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mList.clear();
                initData();
                mAdapter.notifyDataSetChanged();
                refreshlayout.finishRefresh();
            }
        });
        //加载更多
        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
                mAdapter.notifyDataSetChanged();
                refreshLayout.finishLoadMore();
            }
        });
    }

    @Override
    protected void initListener() {
        mAdapter.setOnItemClickListener(new RlvProjectClassifyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(),ParticularActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("link",mList.get(position).getLink());
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
    }
}
