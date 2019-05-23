package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.LoginInfo;

public interface LoginView extends BaseMvpView {
    void onSuccess(LoginInfo bean);

    void onFail(String msg);
}
