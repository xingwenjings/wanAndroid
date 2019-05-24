package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.KnowArticleBean;
import com.example.wan_android.bean.KnowledgeBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.CollectServer;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.KnowledgeApi;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.util.Logger;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class KnowArticleModel extends BaseModel {
    public void getKnowledgeData(int page, int cid, final ResultCallBack<KnowArticleBean> callBack) {
        KnowledgeApi apiserver = HttpUtils.getInstance().getApiserver(KnowledgeApi.BaseUrl, KnowledgeApi.class);
        Observable<KnowArticleBean> knowledgeData = apiserver.getKnowArticleData(page, cid);
        knowledgeData.compose(RxUtils.<KnowArticleBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<KnowArticleBean>() {
                    @Override
                    public void onNext(KnowArticleBean knowArticleBean) {
                        if (knowArticleBean == null) {
                            callBack.onFail(knowArticleBean.getErrorMsg());
                        } else {
                            if (knowArticleBean != null && knowArticleBean.getErrorCode() == 0) {
                                callBack.onSuccess(knowArticleBean);
                            }
                        }
                    }

                    @Override
                    public void error(String msg) {
                        callBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }

    public void addCollect(String id, final ResultCallBack<String> callBack) {
        CollectServer apiserver = HttpUtils.getInstance().getApiserver(CollectServer.URL, CollectServer.class);
        Observable<String> knowledgeData = apiserver.getCollectData(id);
        knowledgeData.compose(RxUtils.<String>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<String>() {
                    @Override
                    public void onNext(String knowArticleBean) {
                        if (knowArticleBean == null) {
                            callBack.onFail("错误");
                        } else {
                            if (knowArticleBean != null) {
                                callBack.onSuccess(knowArticleBean);
                            }
                        }
                    }

                    @Override
                    public void error(String msg) {
                        callBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }

    public void disCollect(String id, final ResultCallBack<String> callBack) {
        CollectServer apiserver = HttpUtils.getInstance().getApiserver(CollectServer.DisURL, CollectServer.class);
        Observable<String> knowledgeData = apiserver.disCollectData(id);
        knowledgeData.compose(RxUtils.<String>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<String>() {
                    @Override
                    public void onNext(String knowArticleBean) {
                        if (knowArticleBean == null) {
                            callBack.onFail("错误");
                        } else {
                            if (knowArticleBean != null) {
                                callBack.onSuccess(knowArticleBean);
                            }
                        }
                    }

                    @Override
                    public void error(String msg) {
                        callBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }
}
