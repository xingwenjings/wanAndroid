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
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.KnowArticleBean;
import com.example.wan_android.presenter.KnowArticlePresenter;
import com.example.wan_android.ui.activity.KnowWebViewActivity;
import com.example.wan_android.ui.activity.LoginActivity;
import com.example.wan_android.ui.adapters.RecKnowArticleAdapter;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.KnowArticleView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class KnowChildFragment extends BaseFragment<KnowArticleView, KnowArticlePresenter> implements KnowArticleView {
    @BindView(R.id.recView)
    RecyclerView recView;
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    private final int id;
    private int page = 0;
    private ArrayList<KnowArticleBean.DataBean.DatasBean> list;
    private RecKnowArticleAdapter adapter;

    @Override
    protected KnowArticlePresenter initPresenter() {
        return new KnowArticlePresenter();
    }

    @SuppressLint("ValidFragment")
    public KnowChildFragment(int cid) {
        this.id = cid;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_know_child;
    }

    @Override
    protected void initData() {
        mPresenter.getKnowledgeData(page,id);
    }

    @Override
    protected void initView() {
        list=new ArrayList<>();
        adapter=new RecKnowArticleAdapter(list,getContext());
        recView.setAdapter(adapter);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        recView.setLayoutManager(manager);

    }

    @Override
    protected void initListener() {
        srl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                ++page;
                initData();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initData();
            }
        });
        adapter.setOnItemClickListener(new RecKnowArticleAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(KnowArticleBean.DataBean.DatasBean bean, int position) {
                Intent intent=new Intent(getContext(),KnowWebViewActivity.class);
                intent.putExtra(Constants.LINK,bean.getLink());
                intent.putExtra("name",bean.getTitle());
                startActivity(intent);
            }
        });
        adapter.setOnItemUrl(new RecKnowArticleAdapter.OnItemUrl() {
            @Override
            public void setLike(int position) {

                if ((boolean) SpUtil.getParam(Constants.LOGIN, false)) {
                   mPresenter.add(list.get(position).getId()+"");
                } else {
                    ToastUtil.showShort("ÇëÏÈµÇÂ¼");
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
            }

            @Override
            public void setDislike(int id) {

            }
        });
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onSuccess(KnowArticleBean bean) {
        list.addAll(bean.getData().getDatas());
        adapter.setList(list);
        adapter.notifyDataSetChanged();
        srl.finishRefresh();
        srl.finishLoadMore();
    }

    @Override
    public void success(String bean) {

    }

    @Override
    public void fail(String msg) {

    }
}
