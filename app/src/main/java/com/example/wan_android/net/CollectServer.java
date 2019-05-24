package com.example.wan_android.net;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CollectServer {
    public String URL="https://www.wanandroid.com/lg/collect/{id}/";
    @POST("json")
    Observable<String>getCollectData(@Path("id")String id);

    public String DisURL="https://www.wanandroid.com/lg/uncollect_originId/{id}/";
    @POST("json")
    Observable<String>disCollectData(@Path("id")String id);
}
