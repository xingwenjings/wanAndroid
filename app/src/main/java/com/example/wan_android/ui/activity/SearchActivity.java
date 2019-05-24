package com.example.wan_android.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.BaseApp;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.SearchBean;
import com.example.wan_android.presenter.SearchPresenter;
import com.example.wan_android.ui.adapters.HomeSearchHistoryRlvAdapter;
import com.example.wan_android.ui.adapters.SouSouAdapter;
import com.example.wan_android.util.ListDataSave;
import com.example.wan_android.util.Tools;
import com.example.wan_android.view.SearchView;
import com.example.wan_android.widght.FlowlayoutManger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity<SearchView, SearchPresenter> implements SearchView, View.OnClickListener {


    private static final String TAG = "SearchActivity";
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
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.tv_search_money)
    TextView mTvSearchMoney;
    @BindView(R.id.tv_clear)
    TextView mTvClear;
    private ArrayList<SearchBean.DataBean> dataBeans;
    private SouSouAdapter adapter;
    private ArrayList<String> mSearchList;
    private ListDataSave mListDataSave;
    private HomeSearchHistoryRlvAdapter mAdapter;

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

        mListDataSave = new ListDataSave(BaseApp.getInstance(), "search");
        mSearchList = new ArrayList<>();

        mTvClear.setOnClickListener(this);
        sIv.setOnClickListener(this);
        searchEdit.setOnClickListener(this);
        searchTv.setOnClickListener(this);
        dataBeans = new ArrayList<>();
        adapter = new SouSouAdapter(dataBeans, SearchActivity.this);
        sRe.setAdapter(adapter);
        FlowlayoutManger flowlayoutManger = new FlowlayoutManger();
        sRe.setLayoutManager(flowlayoutManger);

        BingdingSearchRlv();
        if (getHistorySearch().size() > 0) {
            mRlv.setVisibility(View.VISIBLE);
            mTvSearchMoney.setVisibility(View.GONE);
        } else {
            mRlv.setVisibility(View.GONE);
            mTvSearchMoney.setVisibility(View.VISIBLE);
        }

        adapter.setOnclick(new SouSouAdapter.itemClick() {
            @Override
            public void onclick(int position, SearchBean.DataBean dataBean) {
                String name = dataBean.getName();
                mSearchList.add(0, name);
                mListDataSave.setDataList(Constants.LIST_SEARCH, mSearchList);
                Intent intent = new Intent(SearchActivity.this, SearchChildActivity.class);
                intent.putExtra("query", name);
                startActivityForResult(intent,200);
            }
        });
    }

    @Override
    protected void initListener() {
        mAdapter.setonItemClickListener(new HomeSearchHistoryRlvAdapter.onItemClickListener() {
            @Override
            public void clicklistener(int position) {
            }
        });
    }

    private void BingdingSearchRlv() {
        List<String> list = getHistorySearch();
        mSearchList.addAll(list);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new HomeSearchHistoryRlvAdapter(this, mSearchList);
        mRlv.setAdapter(mAdapter);
    }

    /**
     * 获取搜索历史
     */
    private List<String> getHistorySearch() {
        return mListDataSave.getDataList(Constants.LIST_SEARCH);
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
                String query = searchEdit.getText().toString();
                if (!TextUtils.isEmpty(query)) {
                    mSearchList.add(0, query);
                    mListDataSave.setDataList(Constants.LIST_SEARCH, mSearchList);
                    Intent intent = new Intent(SearchActivity.this, SearchChildActivity.class);
                    intent.putExtra("query", query);
                    startActivityForResult(intent, 100);
                } else {
                    searchEdit.setCursorVisible(false);
                    Tools.closeKeyBoard(this);
                }
                break;
            case R.id.tv_clear:
                mListDataSave.editor.clear().commit();
                mSearchList.clear();
                BingdingSearchRlv();
                if (getHistorySearch().size() > 0) {
                    mRlv.setVisibility(View.VISIBLE);
                    mTvSearchMoney.setVisibility(View.GONE);
                } else {
                    mRlv.setVisibility(View.GONE);
                    mTvSearchMoney.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            mSearchList.clear();
            BingdingSearchRlv();
        }if (requestCode == 200 && resultCode == 200) {
            mSearchList.clear();
            BingdingSearchRlv();
        }
    }

}
