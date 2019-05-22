package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.ClassifyBean;
import com.example.wan_android.model.ProjectModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.util.ToastUtil;
import com.example.wan_android.view.ProjectView;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/20
 * 项目工作空间：wanAndroid
 */
public class ProjectPresenter extends BasePresenter<ProjectView> {

    private ProjectModel mProjectModel;
    //初始化Model
    @Override
    protected void initModel() {
        mProjectModel = new ProjectModel();
        mModels.add(mProjectModel);
    }
    public void getData(){
       mProjectModel.getData(new ResultCallBack<ClassifyBean>() {
           //加载成功
           @Override
           public void onSuccess(ClassifyBean bean) {
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
