package com.example.wan_android.net;

import com.example.wan_android.bean.CollectBean;
import com.example.wan_android.bean.NavigationBean;
import com.example.wan_android.bean.SetCollectBean;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by apcnl on 2019/5/20.
 */

public interface WanandroidApiService {

    String sUrl = "https://www.wanandroid.com/";

    @GET("navi/json")
    Observable<NavigationBean> getData();

    @GET("lg/collect/list/{page}/json")
    Observable<CollectBean> getCollectData(@Path("page") int page,
                                           @Header("Cookie") String name,
                                           @Header("Cookie") String password);

    @POST("lg/collect/{id}/json")
    Observable<SetCollectBean> SetCollectData(@Path("id") int id,
                                              @Header("Cookie") String name,
                                              @Header("Cookie") String password);
}
