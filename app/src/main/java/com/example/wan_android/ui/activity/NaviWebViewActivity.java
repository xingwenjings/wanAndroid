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
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.Constants;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.util.ShareUtil;
import com.example.wan_android.util.UIUtils;
import com.example.wan_android.view.EmptyView;
import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NaviWebViewActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {


    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar_layout)
    AppBarLayout mAppbarLayout;
    //    WebView mWebview;
//    @BindView(R.id.pb)
//    ProgressBar mPb;
    @BindView(R.id.cl_container)
    CoordinatorLayout mClContainer;
    @BindView(R.id.ll_container)
    LinearLayout mLlContainer;
    private AgentWeb mAgentWeb;
    private String mLink;
    private String mName;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_navi_web_view;
    }

    @Override
    protected void initView() {


        mLink = getIntent().getStringExtra(Constants.LINK);
        mName = getIntent().getStringExtra(Constants.NAME);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mTvTitle.setSelected(true);
        mTvTitle.setText(UIUtils.getString(R.string.to_load));

        ChromeClientCallbackManager.ReceivedTitleCallback mCallback;
        mCallback = null;
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mLlContainer, new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setReceivedTitleCallback(mCallback)
                .createAgentWeb()
                .ready()
                .go(mLink);
        mAgentWeb.getWebCreator().get().setWebChromeClient(new WebChromeClient() {
            //获取网页标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                mTvTitle.setText(title);
            }


//            //获得网页的加载进度
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                if (newProgress < 100) {
//                    mPb.setProgress(newProgress);
//                } else {
//                    mPb.setVisibility(View.GONE);
//                }
//            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 0, "分享");
        menu.add(0, 1, 0, "收藏");
        menu.add(0, 2, 0, "用浏览器打开");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                ShareUtil.shareText(this, "玩Android分享\n 【" + mName + "】 ：\n" + mLink
                        , "");
                break;
            case 1:
                break;
            case 2:
                getBrowser();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 调用系统浏览器
     */
    private void getBrowser() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(mLink);
        intent.setData(content_url);
        startActivity(intent);
    }

    @OnClick(R.id.img)
    public void onClick() {
        finish();
    }

}
