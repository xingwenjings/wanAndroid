package com.example.wan_android.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.adapter.SearchChildRlvAdapter;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.SearchChildBean;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.presenter.SearchChildPresenter;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.SearchChildView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchChildActivity extends BaseActivity<SearchChildView, SearchChildPresenter>
        implements SearchChildView {


    private static final String TAG = "SearchChildActivity";
    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private String mQuery;
    private int mPage = 0;
    private SearchChildRlvAdapter mAdapter;

    @Override
    protected SearchChildPresenter initPresenter() {
        return new SearchChildPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_child;
    }

    @Override
    protected void initView() {


        mQuery = getIntent().getStringExtra("query");
        mTvTitle.setText(mQuery);

        ArrayList<SearchChildBean.DataBean.DatasBean> list = new ArrayList<>();
        mRlv.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new SearchChildRlvAdapter(this, list);
        mRlv.setAdapter(mAdapter);

    }

    @Override
    protected void initData() {
        mPresenter.getSearchChildData(mPage,mQuery);
    }

    @OnClick(R.id.img)
    public void onClick() {
        setResult(200);
        finish();

    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void setData(SearchChildBean bean) {
        if (bean.getErrorCode() == Constants.SUCCESS_CODE){
            if (bean.getData().getDatas().size()>0){
                mAdapter.addData(bean);
            }else {
                ToastUtil.showShort("暂无数据");
            }
        }
    }
}
