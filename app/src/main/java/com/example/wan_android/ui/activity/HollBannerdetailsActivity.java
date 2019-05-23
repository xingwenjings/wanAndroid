package com.example.wan_android.ui.activity;


import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.Constants;
import com.example.wan_android.presenter.HollBannerdetailsPresenter;
import com.example.wan_android.util.UIUtils;
import com.example.wan_android.view.HollBannerdetailsView;
import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

import butterknife.BindView;

public class HollBannerdetailsActivity extends BaseActivity<HollBannerdetailsView, HollBannerdetailsPresenter> implements HollBannerdetailsView {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.te_toolbar)
    TextView mTeToolbar;
    @BindView(R.id.toobar)
    Toolbar mToobar;
    @BindView(R.id.con)
    ConstraintLayout mCon;
    private AgentWeb magenWeb;
    private String murl;

    @Override
    protected HollBannerdetailsPresenter initPresenter() {
        return new HollBannerdetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_holl_bannerdetails;
    }

    @Override
    protected void initView() {
        mToobar.setTitle("");
        setSupportActionBar(mToobar);
        mTeToolbar.setSelected(true);
        mTeToolbar.setText(UIUtils.getString(R.string.loade));
        String title = getIntent().getStringExtra(Constants.TITLE);
        murl = getIntent().getStringExtra(Constants.URL);
        mTeToolbar.setText(title);
        ChromeClientCallbackManager.ReceivedTitleCallback mCallback;
        mCallback = null;
        magenWeb = AgentWeb.with(this)
                .setAgentWebParent(mCon, new RelativeLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .defaultProgressBarColor()
                .setReceivedTitleCallback(mCallback)
                .createAgentWeb()
                .ready()
                .go(murl);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "分享");
        menu.add(1, 2, 1, "收藏");
        menu.add(1, 3, 1, "用浏览器打开");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                initfenxiang();
                break;
            case 2:
                break;
            case 3:
                initliulan();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initliulan() {
        Uri uri = Uri.parse(murl);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void initfenxiang() {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, murl);
        startActivity(Intent.createChooser(textIntent, "分享"));

              //分享图片
        ///*String path = bean.getEnvelopePic();
        //Intent imageIntent = new Intent(Intent.ACTION_SEND);
        //imageIntent.setType("image/png");
        //imageIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(path));
        //startActivity(Intent.createChooser(imageIntent, "分享"));*/
    }

    @Override
    protected void onPause() {
        magenWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        magenWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        magenWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }
}
