package com.example.wan_android.ui.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.wan_android.Adapet.VpTodoAdapet;
import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.base.Constants;
import com.example.wan_android.presenter.TodoPresenter;
import com.example.wan_android.ui.fragments.TodoBacklogFragment;
import com.example.wan_android.ui.fragments.TodoOffFragment;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.view.TodoView;
import com.example.wan_android.widght.ControlScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TodoActivity extends BaseActivity<TodoView, TodoPresenter> implements TodoView {
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.img_qiehuan)
    ImageView mImgQiehuan;
    @BindView(R.id.to)
    Toolbar mTo;
    @BindView(R.id.viewpager)
    ControlScrollViewPager mViewpager;
    @BindView(R.id.ta)
    TabLayout mTa;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    private PopupWindow mPopupWindow;

    @Override
    protected TodoPresenter initPresenter() {
        return new TodoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo;
    }

    @Override
    protected void initView() {
        mTo.setTitle("");
        String name = (String) SpUtil.getParam(Constants.POP, "");
        mText.setText(name);
        setSupportActionBar(mTo);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new TodoBacklogFragment());
        fragments.add(new TodoOffFragment());
        ArrayList<String> list = new ArrayList<>();
        list.add("待办");
        list.add("已完成");
        VpTodoAdapet vpTodoAdapet = new VpTodoAdapet(getSupportFragmentManager(), fragments, list);
        mViewpager.setAdapter(vpTodoAdapet);
        mTa.setupWithViewPager(mViewpager);
        mTa.getTabAt(0).setIcon(R.mipmap.icon_todo);
        mTa.getTabAt(1).setIcon(R.mipmap.icon_ok);
    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mImgQiehuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inipop();
            }
        });
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TodoActivity.this, TodoxinzengActivity.class);
                startActivity(intent);
            }
        });
    }

    private void inipop() {
        mPopupWindow = new PopupWindow();
        final View inflate = LayoutInflater.from(this).inflate(R.layout.pop, null, false);

        mPopupWindow.setContentView(inflate);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        mPopupWindow.setOutsideTouchable(true);

        inflate.findViewById(R.id.ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();

            }
        });
        inflate.findViewById(R.id.zhineng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText("只能用一个");
                SpUtil.setParam(Constants.POP, "只能用一个");
                mPopupWindow.dismiss();

            }
        });
        inflate.findViewById(R.id.gong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText("工作");
                SpUtil.setParam(Constants.POP, "工作");
                mPopupWindow.dismiss();

            }
        });
        inflate.findViewById(R.id.xue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText("学习");
                SpUtil.setParam(Constants.POP, "学习");
                mPopupWindow.dismiss();

            }
        });
        inflate.findViewById(R.id.sheng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText.setText("生活");
                SpUtil.setParam(Constants.POP, "生活");
                mPopupWindow.dismiss();

            }
        });
        mPopupWindow.dismiss();
        mPopupWindow.showAtLocation(mTo, Gravity.CENTER, 1000, -670);
    }

}
