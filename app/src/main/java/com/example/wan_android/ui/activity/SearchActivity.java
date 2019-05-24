package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.SearchBean;
import com.example.wan_android.presenter.SearchPresenter;
import com.example.wan_android.ui.adapters.SearchChildAdapter;
import com.example.wan_android.ui.adapters.SouSouAdapter;
import com.example.wan_android.view.SearchView;
import com.example.wan_android.widght.FlowlayoutManger;
import com.miguelcatalan.materialsearchview.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity<SearchView, SearchPresenter> implements SearchView, View.OnClickListener {


    @BindView(R.id.s_iv)
    ImageButton sIv;
    @BindView(R.id.search_tv)
    TextView searchTv;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    @BindView(R.id.ivv)
    ImageView ivv;
    @BindView(R.id.s_re)
    RecyclerView sRe;
    @BindView(R.id.shou_tv)
    TextView shouTv;
    @BindView(R.id.search_scroll_view)
    NestedScrollView searchScrollView;
    private ArrayList<SearchBean.DataBean> dataBeans;
    private SouSouAdapter adapter;

    @Override
    protected SearchPresenter initPresenter() {
        return new SearchPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        sIv.setOnClickListener(this);
        searchEdit.setOnClickListener(this);
        searchTv.setOnClickListener(this);
        dataBeans = new ArrayList<>();
        adapter = new SouSouAdapter(dataBeans,SearchActivity.this);
        sRe.setAdapter(adapter);
        FlowlayoutManger flowlayoutManger = new FlowlayoutManger();
        sRe.setLayoutManager(flowlayoutManger);

        adapter.setOnclick(new SouSouAdapter.itemClick() {
            @Override
            public void onclick(int position, SearchBean.DataBean dataBean) {
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.getSearchData();
    }

    @Override
    public void getSearchSuccess(SearchBean searchBean) {
        List<SearchBean.DataBean> data = searchBean.getData();
        dataBeans.addAll(data);
        adapter.setDataBeans(dataBeans);
        adapter.notifyDataSetChanged();
    }



    @Override
    public void getSearchField(String error) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.s_iv:
                finish();
                break;
            case R.id.search_edit:

                break;
            case R.id.search_tv:

                break;
        }
    }
}
