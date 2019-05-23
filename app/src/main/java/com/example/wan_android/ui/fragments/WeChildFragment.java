package com.example.wan_android.ui.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.WeChildBean;
import com.example.wan_android.presenter.WeChildPresenter;
import com.example.wan_android.ui.activity.WeChatChildActivity;
import com.example.wan_android.ui.adapters.WeChildAdapter;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.WeChildView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class WeChildFragment extends BaseFragment<WeChildView, WeChildPresenter> implements WeChildView {
    @BindView(R.id.srl)
    SmartRefreshLayout srl;
    @BindView(R.id.rl)
    RecyclerView rl;
    private int id;
    private int page = 1;
    private ArrayList<WeChildBean.DataBean.DatasBean> datasBeans;
    private WeChildAdapter adapter;

    @SuppressLint("ValidFragment")
    public WeChildFragment(int id) {
        // Required empty public constructor
        this.id = id;
    }


    @Override
    protected WeChildPresenter initPresenter() {
        return new WeChildPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_we_child;
    }

    @Override
    protected void initData() {
        mPresenter.getWeChild(id, page);
    }

    @Override
    protected void initView() {
        datasBeans=new ArrayList<>();
        adapter = new WeChildAdapter(datasBeans, getContext());
        rl.setLayoutManager(new LinearLayoutManager(getContext()));
        rl.setAdapter(adapter);


        adapter.setSetOnClick(new WeChildAdapter.setOnClick() {
            @Override
            public void OnClickItem(WeChildBean.DataBean.DatasBean datasBean, int position) {
                Intent intent = new Intent(getContext(), WeChatChildActivity.class);
                intent.putExtra(Constants.LINK,datasBeans.get(position).getLink());
                intent.putExtra(Constants.NAME,datasBeans.get(position).getChapterName());
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initListener() {
        srl.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                initData();
                srl.finishLoadMore();
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page=1;
                initData();
                srl.finishRefresh();
            }
        });
    }


    @Override
    public void getWeChildSuccess(WeChildBean weChildBean) {
        datasBeans.addAll(weChildBean.getData().getDatas());
        adapter.setDatasBeans(datasBeans);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void getWeChildField(String error) {
        ToastUtil.showShort(error);
    }


}
