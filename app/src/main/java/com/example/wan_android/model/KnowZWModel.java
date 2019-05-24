package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.KnowledgeBean;
import com.example.wan_android.bean.ZWBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.CollectServer;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.KnowledgeApi;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.util.Logger;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class KnowZWModel extends BaseModel {
    public void gwtZWData(String username,String password,String title,String auther,String link,final ResultCallBack<ZWBean> callBack){
        CollectServer apiserver = HttpUtils.getInstance().getApiserver(CollectServer.ZWUrl, CollectServer.class);
        Observable<ZWBean> knowledgeData = apiserver.zwData(username,password,title,auther,link);
        knowledgeData.compose(RxUtils.<ZWBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ZWBean>() {
                    @Override
                    public void onNext(ZWBean knowledgeBean) {
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
