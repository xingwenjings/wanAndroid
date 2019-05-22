package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.model.EmptyModel;
import com.example.wan_android.model.HollModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.EmptyView;
import com.example.wan_android.view.HollView;

public class HollPresenter extends BasePresenter<HollView> {

    private HollModel mhollModel;

    @Override
    protected void initModel() {
        mhollModel = new HollModel();
        mModels.add(mhollModel);
    }

    public void getListData(String url) {
        mhollModel.setData(url, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if(mMvpView!=null){
                    mMvpView.setListData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void getBannerData(String url) {
        mhollModel.setData(url, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if(mMvpView!=null){
                    mMvpView.setBannerData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void getZhiDingData(String url) {
        mhollModel.setData(url, new ResultCallBack<String>() {
            @Override
            public void onSuccess(String bean) {
                if(mMvpView!=null){
                    mMvpView.setZhidingData(bean);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
