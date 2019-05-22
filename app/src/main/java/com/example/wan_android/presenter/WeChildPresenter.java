package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.WeChildBean;
import com.example.wan_android.model.WeChildModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.WeChildView;

public class WeChildPresenter extends BasePresenter<WeChildView> {

    private WeChildModel weChildModel;

    @Override
    protected void initModel() {
        weChildModel = new WeChildModel();
        mModels.add(weChildModel);
    }

    public void getWeChild(int data, int page) {
        weChildModel.getChildModel(data,page, new ResultCallBack<WeChildBean>() {
            @Override
            public void onSuccess(WeChildBean bean) {
                mMvpView.getWeChildSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.getWeChildField(msg);
            }
        });
    }
}
