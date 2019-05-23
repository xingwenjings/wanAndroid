package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.LoginInfo;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.KnowledgeApi;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.util.Logger;

import io.reactivex.disposables.Disposable;

public class LoginModel extends BaseModel {
    private static final String TAG = "LoginModel";

    public void login(String username, String psw, final ResultCallBack<LoginInfo> callBack) {
        HttpUtils.getInstance().getApiserver(KnowledgeApi.LoginUrl, KnowledgeApi.class)
                .login(username, psw)
                .compose(RxUtils.<LoginInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginInfo>() {
                    @Override
                    public void error(String msg) {
                        Logger.logD(TAG, msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginInfo loginInfo) {
                        if (loginInfo != null) {
                            if (loginInfo.getErrorCode() == KnowledgeApi.SUCCESS_CODE) {
                                callBack.onSuccess(loginInfo);
                            } else {
                                callBack.onFail(loginInfo.getErrorMsg());
                            }
                        }
                    }
                });
    }

    public void register(String name, String psw, String rePsw, final ResultCallBack<LoginInfo> callBack) {
        HttpUtils.getInstance().getApiserver(KnowledgeApi.LoginUrl, KnowledgeApi.class)
                .register(name, psw, rePsw)
                .compose(RxUtils.<LoginInfo>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginInfo>() {
                    @Override
                    public void error(String msg) {
                        Logger.logD(TAG, msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginInfo loginInfo) {
                        if (loginInfo != null) {
                            if (loginInfo.getErrorCode() == KnowledgeApi.SUCCESS_CODE) {
                                callBack.onSuccess(loginInfo);
                            } else {
                                callBack.onFail(loginInfo.getErrorMsg());
                            }
                        }
                    }
                });
    }
}
