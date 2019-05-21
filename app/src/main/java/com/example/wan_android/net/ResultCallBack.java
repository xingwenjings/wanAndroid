package com.example.wan_android.net;


/**
 * @author xts
 *         Created by asus on 2019/4/2.
         */

public interface ResultCallBack<T> {
    //成功
    void onSuccess(T bean);
    //失败
    void onFail(String msg);
}
