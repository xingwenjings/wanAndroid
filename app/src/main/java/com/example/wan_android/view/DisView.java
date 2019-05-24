package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;

public interface DisView extends BaseMvpView {

    void onSuccess(String bean);

    void onFail(String msg);
}
