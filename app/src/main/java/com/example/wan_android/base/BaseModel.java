package com.example.wan_android.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseModel {
    private CompositeDisposable mCompositeDisposable;

    public void onDestory() {
        //切换所有的Disposable对象\
        if (mCompositeDisposable!=null){
            mCompositeDisposable.clear();
        }

    }

    public void addDisposable(Disposable d){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(d);
    }

}
