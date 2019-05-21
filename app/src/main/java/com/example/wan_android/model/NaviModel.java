package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.NavigationBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.net.WanandroidApiService;
import com.example.wan_android.presenter.NaviPresenter;

import io.reactivex.disposables.Disposable;

/**
 * Created by apcnl on 2019/5/20.
 */

public class NaviModel extends BaseModel{
    public void initData(final ResultCallBack<NavigationBean> callBack) {
        WanandroidApiService apiserver = HttpUtils.getInstance().getApiserver(WanandroidApiService.sUrl, WanandroidApiService.class);
        apiserver.getData()
                .compose(RxUtils.<NavigationBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<NavigationBean>() {
                    @Override
                    public void error(String msg) {
                        callBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(NavigationBean navigationBean) {
                        if (navigationBean != null){
                            callBack.onSuccess(navigationBean);
                        }
                    }
                });
    }
}
