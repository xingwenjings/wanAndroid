package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.view.EmptyView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParticularActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {

    @BindView(R.id.wv)
    WebView mWv;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_particular;
    }

    @Override
    protected void initView() {
        //接收
        Intent intent = getIntent();
        String name =  intent.getStringExtra("link");
        mWv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String s) {
                mWv.loadUrl(s);
                return super.shouldOverrideUrlLoading(view, s);
            }
        });
        //加载
        mWv.loadUrl(name);
        //支持js
        WebSettings settings = mWv.getSettings();
        settings.setJavaScriptEnabled(true);
    }
}
