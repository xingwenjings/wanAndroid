package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.adapter.CollectRlvAdapter;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.CollectBean;
import com.example.wan_android.presenter.CollectPresenter;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.CollectView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CollectActivity extends BaseActivity<CollectView, CollectPresenter> implements CollectView {


    private static final String TAG = "CollectActivity";
    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.tv)
    TextView mTv;
    private int mPage = 0;
    private CollectRlvAdapter mAdapter;

    @Override
    protected CollectPresenter initPresenter() {
        return new CollectPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collect;
    }

    @OnClick(R.id.img)
    public void onClick() {
        finish();
    }

    @Override
    protected void initView() {
        showLoading();
        ArrayList<CollectBean.DataBean.DatasBean> list = new ArrayList<>();
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CollectRlvAdapter(this, list);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        String name = (String) SpUtil.getParam(Constants.USERNAME, "");
        String register_password = (String) SpUtil.getParam(Constants.PASSWORD, "");
        String password1 = "loginUserPassword="+register_password;
        String name1 = "loginUserName="+name;
        Log.d(TAG, "initData: "+name1+",password:"+password1);
        mPresenter.getCollectData(mPage,name1,password1);

    }

    @Override
    public void setData(CollectBean bean) {
        if (bean.getErrorCode() == Constants.SUCCESS_CODE){
            hideLoading();
            List<CollectBean.DataBean.DatasBean> list = bean.getData().getDatas();
            if (list.size()>0){
                mAdapter.addData(bean.getData().getDatas());
            }else {
                mTv.setVisibility(View.VISIBLE);
            }
        }else {
            hideLoading();
            ToastUtil.showShort(bean.getErrorMsg());
            startActivity(new Intent(CollectActivity.this,LoginActivity.class));
            finish();
        }

    }

    @Override
    public void onFail(String msg) {
        Log.d(TAG, "onFail: "+msg);
    }
}