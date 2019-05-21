package com.example.wan_android.net;

public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFail(String msg);
}