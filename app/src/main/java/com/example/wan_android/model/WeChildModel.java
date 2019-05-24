package com.example.wan_android.model;

import android.util.Log;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.WeChatCollectBean;
import com.example.wan_android.bean.WeChildBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.PlaySeriver;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WeChildModel extends BaseModel {
    private String TAG="WeChildModel";

    public void getChildModel(int data, int page, final ResultCallBack<WeChildBean> resultCallBack) {
        PlaySeriver apiserver = HttpUtils.getInstance().getApiserver(PlaySeriver.BASE_URL, PlaySeriver.class);
        Observable<WeChildBean> childData = apiserver.getChildData(data, page);
        childData.compose(RxUtils.<WeChildBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WeChildBean>() {
                    @Override
                    public void onNext(WeChildBean weChildBean) {
                        if (weChildBean!=null){
                            Log.d(TAG,weChildBean.getData().getDatas().toString());
                            resultCallBack.onSuccess(weChildBean);
                        }
                    }

                    @Override
                    public void error(String msg) {
                        Log.d(TAG,"错误"+msg);
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }

    public void getCollection(int id, ResultCallBack<WeChatCollectBean> resultCallBack) {
        PlaySeriver apiserver = HttpUtils.getInstance().getApiserver(PlaySeriver.BASE_URL, PlaySeriver.class);

    }
}
