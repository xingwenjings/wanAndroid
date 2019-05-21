package com.example.wan_android.ui.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseFragment;
import com.example.wan_android.bean.WeChatBean;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.presenter.WeChatPresenter;
import com.example.wan_android.ui.adapters.MainAdapter;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.WeChatView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFragment extends BaseFragment<WeChatView, WeChatPresenter> implements WeChatView {


    @BindView(R.id.wechat_tab)
    TabLayout wechatTab;
    @BindView(R.id.wechat_vp)
    ViewPager wechatVp;
    private ArrayList<Fragment> fragments;
    private MainAdapter mainAdapter;

    @Override
    protected WeChatPresenter initPresenter() {
        return new WeChatPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_we_chat;
    }

    @Override
    protected void initData() {
        mPresenter.getTabData();
    }

    @Override
    public void getWeChatSuccess(WeChatBean weChatBean) {
        fragments = new ArrayList<>();
        List<WeChatBean.DataBean> data = weChatBean.getData();
        for (int i = 0; i < data.size(); i++) {
            fragments.add(new WeChildFragment(data.get(i).getId()));
            wechatTab.addTab(wechatTab.newTab().setText(data.get(i).getName()));
        }
        wechatTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                wechatVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        wechatVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(wechatTab));

        mainAdapter = new MainAdapter(getChildFragmentManager(), fragments);
        wechatVp.setAdapter(mainAdapter);
    }

    @Override
    public void getWeChatField(String error) {
        ToastUtil.showShort("请求错误"+error);
    }
}
