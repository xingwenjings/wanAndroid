package com.example.wan_android.net;

import com.example.wan_android.bean.NavigationBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by apcnl on 2019/5/20.
 */

public interface WanandroidApiService {

    String sUrl = "https://www.wanandroid.com/";

    @GET("navi/json")
    Observable<NavigationBean> getData();
}
