package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.bean.KnowledgeBean;
import com.example.wan_android.presenter.KnowledgePresenter;
import com.example.wan_android.ui.adapters.KnowPagerAdapter;
import com.example.wan_android.ui.fragments.KnowChildFragment;
import com.example.wan_android.view.KnowledgeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnowledgeTabActivity extends BaseActivity<KnowledgeView, KnowledgePresenter> implements KnowledgeView, View.OnClickListener {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img)
    ImageView img;
    private ArrayList<Fragment> list;
    private KnowPagerAdapter adapter;
    private int pos;

    @Override
    protected KnowledgePresenter initPresenter() {
        return new KnowledgePresenter();
    }

    @Override
    protected void initView() {
        img.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        pos = intent.getIntExtra("pos", 0);
        toolbar.setTitle("");
        tvTitle.setText(name);
        setSupportActionBar(toolbar);
        mPresenter.getKnowledgeData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_knowledge_tab;
    }

    @Override
    public void onSuccess(List<KnowledgeBean.DataBean> data) {
        list=new ArrayList<>();
        List<KnowledgeBean.DataBean.ChildrenBean> childrenBeans=data.get(pos).getChildren();
        for (int i = 0; i < childrenBeans.size(); i++) {
            list.add(new KnowChildFragment(childrenBeans.get(i).getId()));
            tab.addTab(tab.newTab().setText(childrenBeans.get(i).getName()));
        }
        adapter=new KnowPagerAdapter(getSupportFragmentManager(),list);
        vp.setAdapter(adapter);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 100, 100, "分享");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 100:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img:
                finish();
                break;
        }
    }
}
