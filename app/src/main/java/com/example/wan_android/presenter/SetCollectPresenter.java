package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.SetCollectBean;
import com.example.wan_android.model.SetCollectModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.SetCollectView;

/**
 * Created by apcnl on 2019/5/24.
 */

public class SetCollectPresenter extends BasePresenter<SetCollectView>{

    private SetCollectModel mModel;

    @Override
    protected void initModel() {
        mModel = new SetCollectModel();
        mModels.add(mModel);
    }

    public void setCollectData(int id, String name1, String password1) {
        mModel.setCollectData(id,name1,password1, new ResultCallBack<SetCollectBean>() {
            @Override
            public void onSuccess(SetCollectBean bean) {
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
