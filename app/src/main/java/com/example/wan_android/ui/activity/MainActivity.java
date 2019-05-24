package com.example.wan_android.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.base.Constants;

import com.example.wan_android.base.Constants;
import com.example.wan_android.net.KnowledgeApi;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.ui.fragments.HomeFragment;
import com.example.wan_android.ui.fragments.KnowLedgeFragment;
import com.example.wan_android.ui.fragments.NavigationFragment;
import com.example.wan_android.ui.fragments.ProjectFragment;
import com.example.wan_android.ui.fragments.WeChatFragment;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.UIModeUtil;
import com.example.wan_android.util.UIUtils;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.widght.ScrollAwareFABBehavior;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView, View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_fl)
    FrameLayout mainFl;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.nav)
    NavigationView nav;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tool_img)
    ImageButton tool_img;
    private ArrayList<BaseFragment> fragments;
    private FragmentManager mManager;
    private int mLastFragmentPosition = 0;

    private final int TYPE_HOME = 0;
    private final int TYPE_KNOWLEDGE = 1;
    private final int TYPE_WECHAT = 2;
    private final int TYPE_NAVIGATION = 3;
    private final int TYPE_PROJECT = 4;
    private AlertDialog alertDialog2;
    private boolean ma = false;
    private TextView tvLogin;


    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        //设置toolbar功能
        tv.setText(R.string.play);
        toolbar.setNavigationIcon(null);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.app_name, R.string.app_name);
        //设置旋转开关颜色
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        dl.addDrawerListener(toggle);
        fab.setOnClickListener(this);
        toggle.syncState();


        initNav();
        //设置tablayout
        initTitles();
        //设置fragment
        initFragment();
    }

    private void initNav() {
        //解决侧滑菜单图标不显示问题
        nav.setItemIconTintList(null);
    }

    @Override
    protected void initListener() {
        View headerView = nav.getHeaderView(0);
        tvLogin = (TextView) headerView.findViewById(R.id.tv_login);
        if ((boolean) SpUtil.getParam(Constants.LOGIN, false)) {
            tvLogin.setText((String) SpUtil.getParam(Constants.USERNAME, "登录"));
        }
        tvLogin.setOnClickListener(this);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.collect:
                        startActivity(new Intent(MainActivity.this, CollectActivity.class));

                        break;
                    case R.id.settings:

                        startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                        break;
                    case R.id.night:

                        initNight();
                        break;
                    case R.id.todo:

                        startActivity(new Intent(MainActivity.this, TodoActivity.class));
                        break;
                    case R.id.me:

                        startActivity(new Intent(MainActivity.this, MeActivity.class));
                        break;
                    case R.id.unLogin:
                        if ((boolean) SpUtil.getParam(Constants.LOGIN, true)) {
                            tanChuang();
                        } else {
                        }
                        break;
                }
                return false;
            }
        });
        tool_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

    }

    private void tanChuang() {
        alertDialog2 = new AlertDialog.Builder(this)
                .setTitle("确认要退出登录？")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SpUtil.setParam(Constants.LOGIN, false);
                        tvLogin.setText("登录");
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog2.dismiss();
                    }
                })
                .create();
        alertDialog2.show();
    }

    private void initNight() {
        Toast.makeText(this, "夜间模式", Toast.LENGTH_SHORT).show();
        UIModeUtil.changeModeUI(MainActivity.this);
    }

    private void initTitles() {
        tab.addTab(tab.newTab().setText(R.string.home).setIcon(R.drawable.select_home));
        tab.addTab(tab.newTab().setText(R.string.knowledge).setIcon(R.drawable.select_knowledge));
        tab.addTab(tab.newTab().setText(R.string.wechat).setIcon(R.drawable.select_wechat));
        tab.addTab(tab.newTab().setText(R.string.navigation).setIcon(R.drawable.select_navigation));
        tab.addTab(tab.newTab().setText(R.string.project).setIcon(R.drawable.select_project));
    }

    private void initFragment() {
        mManager = getSupportFragmentManager();


        mManager = getSupportFragmentManager();
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new KnowLedgeFragment());
        fragments.add(new WeChatFragment());
        fragments.add(new NavigationFragment());
        fragments.add(new ProjectFragment());

        FragmentTransaction fragmentTransaction = mManager.beginTransaction();
        fragmentTransaction.add(R.id.main_fl, fragments.get(0));
        fragmentTransaction.commit();
    }

    @Override
    protected void initData() {
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                        case 0:
                            tv.setText(R.string.play);
                            switchFragment(TYPE_HOME);
                            break;
                        case 1:
                            tv.setText(R.string.knowledge);
                            switchFragment(TYPE_KNOWLEDGE);
                            break;
                        case 2:

                            tv.setText(R.string.wechat);
                            switchFragment(TYPE_WECHAT);
                            break;
                        case 3:
                            tv.setText(R.string.navigation);
                            switchFragment(TYPE_NAVIGATION);
                            break;
                        case 4:
                            tv.setText(R.string.project);
                            switchFragment(TYPE_PROJECT);
                            break;
                    }

                }

                @Override
                public void onTabUnselected (TabLayout.Tab tab){

                }

                @Override
                public void onTabReselected (TabLayout.Tab tab){

                }
            });

        }

        private void switchFragment ( int position){
            FragmentTransaction transaction = mManager.beginTransaction();
            BaseFragment fragment = fragments.get(position);
            if (!fragment.isAdded()) {
                transaction.add(R.id.main_fl, fragment);
            }
            transaction.hide(fragments.get(mLastFragmentPosition));
            transaction.show(fragment);
            transaction.commit();

            mLastFragmentPosition = position;

        }

        @Override
        public void onClick (View v){
            switch (v.getId()) {

                case R.id.tv_login:
                    if (tvLogin.getText().toString().trim().equals("登录"))
                        startActivityForResult(new Intent(this, LoginActivity.class), 100);
                    break;
                case R.id.fab:
                    mainFl.scrollBy(0, 0);
                    break;

            }
        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 100 && resultCode == KnowledgeApi.SUCCESS_CODE) {
                tvLogin.setText((String) SpUtil.getParam(Constants.USERNAME, "登录"));
            }
        }
    }
