package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.ClassifyBean;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/20
 * 项目工作空间：wanAndroid
 */
public interface ProjectView extends BaseMvpView {
    void setData(ClassifyBean bean);
}
