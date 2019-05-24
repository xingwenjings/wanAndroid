package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
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
import com.example.wan_android.bean.SetCollectBean;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.presenter.SetCollectPresenter;
import com.example.wan_android.util.ShareUtil;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.util.UIUtils;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.SetCollectView;
import com.jaeger.library.StatusBarUtil;

import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//邢文静   webview
public class WeChatChildActivity extends BaseActivity<SetCollectView, SetCollectPresenter> implements SetCollectView {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    private String url;
    private String name;
    private AgentWeb mAgentWeb;
    private int mId;

    @Override
    protected SetCollectPresenter initPresenter() {
        return new SetCollectPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wechat_child;
    }

    @Override
    protected void initView() {
        url = getIntent().getStringExtra(Constants.LINK);
        name = getIntent().getStringExtra(Constants.NAME);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        tvTitle.setSelected(true);
        tvTitle.setText(UIUtils.getString(R.string.loade));
        ChromeClientCallbackManager.ReceivedTitleCallback mCallback;
        mCallback = null;
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(ll, new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setReceivedTitleCallback(mCallback)
                .createAgentWeb()
                .ready()
                .go(url);
        mAgentWeb.getWebCreator().get().setWebChromeClient(new WebChromeClient() {
            //获取网页标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                tvTitle.setText(title);
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
        menu.add(1,1,1,"分享");
        menu.add(1,2,2,"收藏");
        menu.add(1,3,3,"用浏览器打开");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                ShareUtil.shareText(this, "玩Android分享\n 【" + name + "】 ：\n" + url
                        , "");
                break;
            case 2:
                boolean flag = (boolean) SpUtil.getParam(Constants.LOGIN, false);
                if (flag){
                    setCollect();
                }else {
                    Intent intent = new Intent(WeChatChildActivity.this, LoginActivity.class);
                    intent.putExtra("judge", "judge");
                    startActivity(intent);
                }
                break;
            case 3:
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

    /**
     * 调用系统浏览器
     */
    private void getBrowser() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        startActivity(intent);
    }
    @OnClick(R.id.img)
    public void onClick() {
        finish();
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
