package com.example.wan_android.net;


/**
 * @author xts
 *         Created by asus on 2019/4/2.
         */

public interface ResultCallBack<T> {
    //³É¹¦
    void onSuccess(T bean);
    //Ê§°Ü
    void onFail(String msg);
}
