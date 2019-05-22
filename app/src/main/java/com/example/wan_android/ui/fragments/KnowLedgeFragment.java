package com.example.wan_android.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.bean.KnowledgeBean;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.presenter.KnowledgePresenter;
import com.example.wan_android.ui.activity.KnowledgeTabActivity;
import com.example.wan_android.ui.adapters.RecKnowledgeAdapter;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.KnowledgeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class KnowLedgeFragment extends BaseFragment<KnowledgeView, KnowledgePresenter> implements KnowledgeView {
    @BindView(R.id.recView)
    RecyclerView recView;
    @BindView(R.id.smart)
    SmartRefreshLayout smart;
    private ArrayList<KnowledgeBean.DataBean> list;
    private RecKnowledgeAdapter adapter;
    @Override
    protected KnowledgePresenter initPresenter() {
        return new KnowledgePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_know_ledge;
    }

    @Override
    protected void initData() {
        mPresenter.getKnowledgeData();
    }

    @Override
    protected void initView() {
        list=new ArrayList<>();
        adapter=new RecKnowledgeAdapter(list,getContext());
        recView.setAdapter(adapter);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        recView.setLayoutManager(manager);
        smart.finishLoadmore();
        smart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                initData();
            }
        });
    }

    @Override
    protected void initListener() {
        adapter.setOnItemClickListener(new RecKnowledgeAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, KnowledgeBean.DataBean bean) {
                Intent intent=new Intent(getContext(), KnowledgeTabActivity.class);
                intent.putExtra("name",bean.getName());
                intent.putExtra("pos",position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSuccess(List<KnowledgeBean.DataBean> data) {
        list.addAll(data);
        adapter.setList(list);
        adapter.notifyDataSetChanged();
        smart.finishRefresh();
    }

    @Override
    public void onFail(String msg) {

    }
}
