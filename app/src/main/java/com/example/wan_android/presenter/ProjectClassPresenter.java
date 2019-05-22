package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.ClassifyBean;
import com.example.wan_android.bean.ListBean;
import com.example.wan_android.model.ProjectClassifyModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.ProjectClassifyView;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/21
 * 项目工作空间：wanAndroid
 */
public class ProjectClassPresenter extends BasePresenter<ProjectClassifyView>{

    private ProjectClassifyModel mProjectClassifyModel;
//初始化Modle
    @Override
    protected void initModel() {
        mProjectClassifyModel = new ProjectClassifyModel();
        mModels.add(mProjectClassifyModel);
    }
    public void getData(int page,int cid){
        mProjectClassifyModel.getData(page, cid, new ResultCallBack<ListBean>() {
            //加载成功
            @Override
            public void onSuccess(ListBean bean) {
                if (bean != null){
                    mMvpView.setData(bean);
                }
            }
            //加载失败
            @Override
            public void onFail(String msg) {
                ToastUtil.showLong(msg);
            }
        });
    }
}