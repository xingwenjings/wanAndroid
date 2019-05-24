package com.example.wan_android.model;

import android.util.Log;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.SetCollectBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.net.WanandroidApiService;

import io.reactivex.disposables.Disposable;

/**
 * Created by apcnl on 2019/5/24.
 */

public class SetCollectModel extends BaseModel{
    private static final String TAG = "SetCollectModel";

    public void setCollectData(int id, String name1, String password1, final ResultCallBack<SetCollectBean> resultCallBack) {
        WanandroidApiService apiserver = HttpUtils.getInstance().getApiserver(WanandroidApiService.sUrl, WanandroidApiService.class);
        apiserver.SetCollectData(id,name1,password1)
                .compose(RxUtils.<SetCollectBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SetCollectBean>() {
                    @Override
                    public void error(String msg) {
                        Log.d(TAG, "error: "+msg);
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(SetCollectBean setCollectBean) {
                        if (setCollectBean != null){
                            resultCallBack.onSuccess(setCollectBean);
                        }
                    }
                });
    }
}
