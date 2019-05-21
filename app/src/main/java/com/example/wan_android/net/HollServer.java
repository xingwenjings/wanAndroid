package com.example.wan_android.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HollServer {
    //https://www.wanandroid.com/article/list/1/json
    String url="https://www.wanandroid.com/";
    @GET()
    Observable<String> getEmptyData(@Url String url);
}
