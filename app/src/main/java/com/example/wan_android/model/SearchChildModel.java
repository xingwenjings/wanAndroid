package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.SearchChildBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.net.WanandroidApiService;

import io.reactivex.disposables.Disposable;

/**
 * Created by apcnl on 2019/5/24.
 */

public class SearchChildModel extends BaseModel{

    public void getSearchChildData(int page, String query, final ResultCallBack<SearchChildBean> resultCallBack) {

        WanandroidApiService apiserver = HttpUtils.getInstance().getApiserver(WanandroidApiService.sUrl, WanandroidApiService.class);
        apiserver.getSearchChildData(page,query)
                .compose(RxUtils.<SearchChildBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SearchChildBean>() {
                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(SearchChildBean searchChildBean) {
                        if (searchChildBean != null){
                            resultCallBack.onSuccess(searchChildBean);
                        }
                    }
                });
    }
}
