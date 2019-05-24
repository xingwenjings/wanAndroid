package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.KnowArticleBean;

public interface KnowArticleView extends BaseMvpView {


    void onFail(String msg);

    void onSuccess(KnowArticleBean bean);
    void success(String bean);

    void fail(String msg);
}
