package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.net.Uri;
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
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.presenter.SetCollectPresenter;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.SetCollectView;
import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

import butterknife.BindView;

public class ParticularActivity extends BaseActivity<SetCollectView, SetCollectPresenter> implements SetCollectView {

    @BindView(R.id.container)
    LinearLayout mContainer;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private AgentWeb mAgentWeb;
    private String mLink;
    private String mTitle;
    private int mId;

    @Override
    protected SetCollectPresenter initPresenter() {
        return new SetCollectPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_particular;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        mId = intent.getIntExtra(Constants.ID,0);
        mLink = intent.getStringExtra(Constants.LINK);
        mTitle = intent.getStringExtra(Constants.TITLE);
        ChromeClientCallbackManager.ReceivedTitleCallback mCallback;
        mCallback = null;
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mContainer, new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setReceivedTitleCallback(mCallback)
                .createAgentWeb()
                .ready()
                .go(mLink);
        mTvTitle.setText(mTitle);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null); // or, setDisplayShowTitleEnabled(false)
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
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, "分享");
        menu.add(0, 2, 2, "收藏");
        menu.add(0, 3, 3, "用浏览器打开");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            Intent share_intent = new Intent();
            share_intent.setAction(Intent.ACTION_SEND);
            share_intent.setType("text/plain");
            share_intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
            share_intent = Intent.createChooser(share_intent, "分享");
            startActivity(share_intent);
        } else if (item.getItemId() == 2) {
            boolean flag = (boolean) SpUtil.getParam(Constants.LOGIN, false);
            if (flag){
                setCollect();
            }else {
                Intent intent = new Intent(ParticularActivity.this, LoginActivity.class);
                intent.putExtra("judge", "judge");
                startActivity(intent);
            }
        } else {
            Uri uri = Uri.parse(mLink);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        return true;
    }

    private void setCollect() {
        String name = (String) SpUtil.getParam(Constants.USERNAME, "");
        String register_password = (String) SpUtil.getParam(Constants.PASSWORD, "");
        String password1 = "loginUserPassword="+register_password;
        String name1 = "loginUserName="+name;
        mPresenter.setCollectData(mId,name1,password1);
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
