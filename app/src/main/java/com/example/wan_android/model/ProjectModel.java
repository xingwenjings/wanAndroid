package com.example.wan_android.model;

import com.example.wan_android.base.BaseModel;
import com.example.wan_android.bean.ClassifyBean;
import com.example.wan_android.net.ApiServer;
import com.example.wan_android.net.BaseObserver;
import com.example.wan_android.net.HttpUtils;
import com.example.wan_android.net.ResultCallBack;
import com.example.wan_android.net.RxUtils;
import com.example.wan_android.widght.TouchCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/20
 * 项目工作空间：wanAndroid
 */
public class ProjectModel extends BaseModel {
    //网络请求数据
    public void getData(final ResultCallBack<ClassifyBean> callBack){
        ApiServer apiserver = HttpUtils.getInstance().getApiserver(ApiServer.ClassIfyUrl, ApiServer.class);
        Observable<ClassifyBean> dataClassify = apiserver.getDataClassify();
        dataClassify.compose(RxUtils.<ClassifyBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<ClassifyBean>() {
                    @Override
                    public void onNext(ClassifyBean classifyBean) {
                        callBack.onSuccess(classifyBean);
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
