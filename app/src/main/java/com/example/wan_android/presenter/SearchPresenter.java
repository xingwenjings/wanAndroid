package com.example.wan_android.presenter;

import com.example.wan_android.base.BasePresenter;
import com.example.wan_android.bean.SearchBean;
import com.example.wan_android.model.SearchModel;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.view.SearchView;

public class SearchPresenter extends BasePresenter<SearchView> {

    private SearchModel searchModel;

    @Override
    protected void initModel() {
        searchModel = new SearchModel();
        mModels.add(searchModel);
    }

    public void getSearchData() {
        searchModel.setData(new ResultCallBack<SearchBean>() {
            @Override
            public void onSuccess(SearchBean bean) {
                mMvpView.getSearchSuccess(bean);
            }

            @Override
            public void onFail(String msg) {
                mMvpView.getSearchField(msg);
            }
        });
    }
}
