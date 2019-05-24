package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.LoginInfo;
import com.example.wan_android.model.LoginModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginModel model;
    @Override
    protected void initModel() {
        model=new LoginModel();
        mModels.add(model);
    }
    public void login(String username,String password){
        model.login(username, password, new ResultCallBack<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo bean) {
                if (mMvpView!=null){
                    mMvpView.onSuccess(bean);
                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView!=null){
                    mMvpView.onFail(msg);
                }
            }
        });
    }
    public void register(String username,String password,String rePaw){
        model.register(username, password, rePaw,new ResultCallBack<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo bean) {
                if (mMvpView!=null){
                    mMvpView.onSuccess(bean);
                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView!=null){
                    mMvpView.onFail(msg);
                }
            }
        });
    }
}
