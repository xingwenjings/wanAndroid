package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.KnowArticleBean;
import com.example.wan_android.bean.KnowledgeBean;
import com.example.wan_android.model.KnowArticleModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.KnowArticleView;

public class KnowArticlePresenter extends BasePresenter<KnowArticleView> {
    private KnowArticleModel model;
    @Override
    protected void initModel() {
        model=new KnowArticleModel();
        mModels.add(model);
    }
    public void getKnowledgeData(int page,int cid){
        model.getKnowledgeData(page,cid,new ResultCallBack<KnowArticleBean>() {
            @Override
            public void onSuccess(KnowArticleBean bean) {
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
