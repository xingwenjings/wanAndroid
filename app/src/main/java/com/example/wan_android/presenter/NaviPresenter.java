package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.NavigationBean;
import com.example.wan_android.model.NaviModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.NaviView;

/**
 * Created by apcnl on 2019/5/20.
 */

public class NaviPresenter extends BasePresenter<NaviView> implements ResultCallBack<NavigationBean> {

    private NaviModel mModel;

    @Override
    protected void initModel() {
        mModel = new NaviModel();
        mModels.add(mModel);
    }

    public void initData() {
        mModel.initData(this);
    }

    @Override
    public void onSuccess(NavigationBean bean) {
        if (bean != null){
            if (mMvpView != null){
                mMvpView.setData(bean);
            }
        }
    }

    @Override
    public void onFail(String msg) {
        if (mMvpView != null){
            mMvpView.onFail(msg);
        }
    }
}
