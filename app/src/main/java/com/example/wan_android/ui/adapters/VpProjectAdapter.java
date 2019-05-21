package com.example.wan_android.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/21
 * 项目工作空间：wanAndroid
 */
public class VpProjectAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> mFragment;

    public VpProjectAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragment = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragment.get(i);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }
}
