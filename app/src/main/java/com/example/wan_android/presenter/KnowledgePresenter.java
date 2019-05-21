package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.KnowledgeBean;
import com.example.wan_android.model.KnowledgeModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.KnowledgeView;

public class KnowledgePresenter extends BasePresenter<KnowledgeView>{
    private KnowledgeModel knowledgeModel;
    @Override
    protected void initModel() {
        knowledgeModel=new KnowledgeModel();
        mModels.add(knowledgeModel);
    }
    public void getKnowledgeData(){
        knowledgeModel.getKnowledgeData(new ResultCallBack<KnowledgeBean>() {
            @Override
            public void onSuccess(KnowledgeBean bean) {
                if (mMvpView!=null){
                    mMvpView.onSuccess(bean.getData());
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
