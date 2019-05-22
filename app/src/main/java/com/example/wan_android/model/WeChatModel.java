package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.WeChatBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.PlaySeriver;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;


import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WeChatModel extends BaseModel {
    public void getTabWe(final ResultCallBack<WeChatBean> resultCallBack) {
        PlaySeriver apiserver = HttpUtils.getInstance().getApiserver(PlaySeriver.BASE_URL, PlaySeriver.class);
        Observable<WeChatBean> weChat = apiserver.getWeChat();
        weChat.compose(RxUtils.<WeChatBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WeChatBean>() {
                    @Override
                    public void onNext(WeChatBean weChatBean) {
                        if (weChatBean!=null){
                            resultCallBack.onSuccess(weChatBean);
                        }
                    }

                    @Override
                    public void error(String msg) {
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }
}
