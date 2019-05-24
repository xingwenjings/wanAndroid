package com.example.wan_android.model;

import android.util.Log;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.SearchBean;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.PlaySeriver;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class SearchModel extends BaseModel {
    private String TAG="SearchModel";

    public void setData(final ResultCallBack<SearchBean> resultCallBack) {
        PlaySeriver apiserver = HttpUtils.getInstance().getApiserver(PlaySeriver.api_shou, PlaySeriver.class);
        Observable<SearchBean> search = apiserver.getSearch();
        search.compose(RxUtils.<SearchBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SearchBean>() {
                    @Override
                    public void onNext(SearchBean searchBean) {
                        if (searchBean!=null){
                            resultCallBack.onSuccess(searchBean);
                        }
                    }

                    @Override
                    public void error(String msg) {
                        Log.d(TAG,"msg"+msg);
                        resultCallBack.onFail(msg);
                    }

                    @Override
                    protected void subscribe(Disposable d) {
                        addDisposable(d);
                    }
                });
    }
}
