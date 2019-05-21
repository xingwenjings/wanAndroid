package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.WeChatBean;
import com.example.wan_android.model.WeChatModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.WeChatView;

public class WeChatPresenter extends BasePresenter<WeChatView> {

    private WeChatModel model;

    @Override
    protected void initModel() {
        model = new WeChatModel();
        mModels.add(model);
    }

    public void getTabData() {
        model.getTabWe(new ResultCallBack<WeChatBean>() {
            @Override
            public void onSuccess(WeChatBean bean) {
                if (bean!=null){
                    mMvpView.getWeChatSuccess(bean);
                }
            }

            @Override
            public void onFail(String msg) {
                mMvpView.getWeChatField(msg);
            }
        });
    }


}
