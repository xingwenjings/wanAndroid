package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.KnowledgeBean;

import java.util.List;

public interface KnowledgeView extends BaseMvpView {
    void onSuccess(List<KnowledgeBean.DataBean> data);

    void onFail(String msg);
}
