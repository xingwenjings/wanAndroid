package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.KnowArticleBean;
import com.example.wan_android.bean.ZWBean;
import com.example.wan_android.model.KnowArticleModel;
import com.example.wan_android.model.KnowZWModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.KnowZWView;

public class KnowZWPresenter extends BasePresenter<KnowZWView> {
    private KnowZWModel model;
    @Override
    protected void initModel() {
        model=new KnowZWModel();
        mModels.add(model);
    }
    public void getKnowledgeData(String username,String password,String title,String auther,String link){
        model.gwtZWData(username,password,title,auther,link,new ResultCallBack<ZWBean>() {
            @Override
            public void onSuccess(ZWBean bean) {
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
