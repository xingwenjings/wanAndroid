package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.ClassifyBean;
import com.example.wan_android.bean.ListBean;
import com.example.wan_android.net.ApiServer;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/21
 * 项目工作空间：wanAndroid
 */
public class ProjectClassifyModel extends BaseModel {
    //网络请求数据
    public void getData(final int page, final int cid, final ResultCallBack<ListBean> callBack) {
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.ListUrl, ApiServer.class);
        Observable<ListBean> dataClassify = apiserver.getDataList(page, cid);
        dataClassify.compose(RxUtils.<ListBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ListBean>() {
                    @Override
                    public void onNext(ListBean listBean) {
                        callBack.onSuccess(listBean);
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
