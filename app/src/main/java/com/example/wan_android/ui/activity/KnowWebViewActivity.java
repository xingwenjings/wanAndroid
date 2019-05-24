package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.SetCollectBean;
import com.example.wan_android.bean.ZWBean;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.presenter.KnowZWPresenter;
import com.example.wan_android.presenter.SetCollectPresenter;
import com.example.wan_android.util.ShareUtil;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.KnowZWView;
import com.example.wan_android.view.SetCollectView;
import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

import butterknife.BindView;
import butterknife.ButterKnife;

//马佳雪 用AgentWeb加载页面
public class KnowWebViewActivity extends BaseActivity<SetCollectView, SetCollectPresenter> implements SetCollectView, View.OnClickListener {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container)
    LinearLayout container;

    private String link;
    private String name;
    private AgentWeb mAgentWeb;
    private int mId;
    @Override
    protected SetCollectPresenter initPresenter() {
        return new SetCollectPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_know_webview;
    }

    @Override
    protected void initView() {
        link = getIntent().getStringExtra(Constants.LINK);
        name = getIntent().getStringExtra("name");
        tvTitle.setText(name);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ChromeClientCallbackManager.ReceivedTitleCallback mCallback;
        mCallback = null;
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(container, new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setReceivedTitleCallback(mCallback)
                .createAgentWeb()
                .ready()
                .go(link);
    }

    @Override
    protected void initListener() {
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img:
                if (!mAgentWeb.back()) {
                    finish();
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 100, 100, "分享");
        menu.add(1, 200, 200, "收藏");
        menu.add(1, 300, 300, "用浏览器打开");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 100:
                ShareUtil.shareText(this, "玩Android分享\n 【" + name + "】 ：\n" + link
                        , "");
                break;
            case 200:
                boolean flag = (boolean) SpUtil.getParam(Constants.LOGIN, false);
                if (flag){
                    setCollect();
                }else {
                    Intent intent = new Intent(KnowWebViewActivity.this, LoginActivity.class);
                    intent.putExtra("judge", "judge");
                    startActivity(intent);
                }
                break;
            case 300:
                getBrowser();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setCollect() {
        String name = (String) SpUtil.getParam(Constants.USERNAME, "");
        String register_password = (String) SpUtil.getParam(Constants.PASSWORD, "");
        String password1 = "loginUserPassword="+register_password;
        String name1 = "loginUserName="+name;
        mPresenter.setCollectData(mId,name1,password1);
    }

    private void getBrowser() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(link);
        intent.setData(content_url);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

    @Override
    public void setData(SetCollectBean bean) {
        if (bean.getErrorCode() == Constants.SUCCESS_CODE){
            ToastUtil.showShort("收藏成功");
        }
    }

    @Override
    public void onFail(String msg) {
        ToastUtil.showShort(msg);
    }
}
