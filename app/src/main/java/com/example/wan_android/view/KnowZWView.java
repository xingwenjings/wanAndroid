package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.ZWBean;

public interface KnowZWView extends BaseMvpView{
    void onSuccess(ZWBean bean);

    void onFail(String msg);
}
