package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.CollectBean;
import com.example.wan_android.model.CollectModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.CollectView;

/**
 * Created by apcnl on 2019/5/23.
 */

public class CollectPresenter extends BasePresenter<CollectView>{

    private CollectModel mModel;

    @Override
    protected void initModel() {
        mModel = new CollectModel();
        mModels.add(mModel);
    }

    public void getCollectData(int page, String name, String password) {
        mModel.getCollectData(page,name,password, new ResultCallBack<CollectBean>() {
            @Override
            public void onSuccess(CollectBean bean) {
                if (bean != null){
                    if (mMvpView != null){
                        mMvpView.setData(bean);
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                if (mMvpView != null){
                    mMvpView.onFail(msg);
                }
            }
        });
    }
}
