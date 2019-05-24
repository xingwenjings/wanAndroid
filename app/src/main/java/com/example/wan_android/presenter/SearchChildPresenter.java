package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.SearchChildBean;
import com.example.wan_android.model.SearchChildModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.SearchChildView;

/**
 * Created by apcnl on 2019/5/24.
 */

public class SearchChildPresenter extends BasePresenter<SearchChildView>{

    private SearchChildModel mModel;

    @Override
    protected void initModel() {
        mModel = new SearchChildModel();
        mModels.add(mModel);
    }

    public void getSearchChildData(int page, String query) {
        mModel.getSearchChildData(page,query, new ResultCallBack<SearchChildBean>() {
            @Override
            public void onSuccess(SearchChildBean bean) {
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
