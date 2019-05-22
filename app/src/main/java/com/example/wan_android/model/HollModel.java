package com.example.wan_android.model;

import android.util.Log;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HollServer;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.net.Http2Utils;

import io.reactivex.disposables.Disposable;

public class HollModel extends BaseModel {

    public void setData(String url, final ResultCallBack<String> resultCallBack) {
        HollServer apiserver = Http2Utils.getInstance().getApiserver(HollServer.url, HollServer.class);
        apiserver.getEmptyData(url)
                .compose(RxUtils.<String>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<String>() {
                    @Override
                    public void error(String msg) {
                        Log.e("whs", "error: "+msg );
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(String loginInfo) {
                        Log.e("whs", "onNext: "+loginInfo );
                        if (loginInfo != null){
                            resultCallBack.onSuccess(loginInfo);
                        }
                    }
                });
    }
}
