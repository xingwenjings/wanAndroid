package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.KnowledgeBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.KnowledgeApi;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.util.Logger;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class KnowledgeModel extends BaseModel {
    public void getKnowledgeData(final ResultCallBack<KnowledgeBean> callBack){
        KnowledgeApi apiserver = HttpUtils.getInstance().getApiserver(KnowledgeApi.BaseUrl, KnowledgeApi.class);
        Observable<KnowledgeBean> knowledgeData = apiserver.getKnowledgeData();
        knowledgeData.compose(RxUtils.<KnowledgeBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<KnowledgeBean>() {
                    @Override
                    public void onNext(KnowledgeBean knowledgeBean) {
                        if (knowledgeBean==null){
                            callBack.onFail(knowledgeBean.getErrorMsg());
                        }else {
                            if (knowledgeBean!=null&&knowledgeBean.getErrorCode()==0){
                                callBack.onSuccess(knowledgeBean);
                            }
                        }
                    }

                    @Override
                    public void error(String msg) {
                        Logger.logD("KnowledgeModel",msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }
}
