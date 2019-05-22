package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.KnowArticleBean;
import com.example.wan_android.bean.KnowledgeBean;

import java.util.List;

public interface KnowArticleView extends BaseMvpView {


    void onFail(String msg);

    void onSuccess(KnowArticleBean bean);
}
