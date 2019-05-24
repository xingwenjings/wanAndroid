package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.CollectBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.net.WanandroidApiService;

import io.reactivex.disposables.Disposable;

/**
 * Created by apcnl on 2019/5/23.
 */

public class CollectModel extends BaseModel{

    public void getCollectData(int page, String name, String password, final ResultCallBack<CollectBean> resultCallBack) {
        WanandroidApiService apiserver = HttpUtils.getInstance().getApiserver(WanandroidApiService.sUrl, WanandroidApiService.class);
        apiserver.getCollectData(page,name,password)
                .compose(RxUtils.<CollectBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<CollectBean>() {
                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(CollectBean collectBean) {
                        if (collectBean != null){
                            resultCallBack.onSuccess(collectBean);
                        }
                    }
                });
    }
}
