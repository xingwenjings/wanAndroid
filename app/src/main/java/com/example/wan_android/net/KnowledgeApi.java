package com.example.wan_android.net;

import com.example.wan_android.bean.KnowledgeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface KnowledgeApi {
    public String BaseUrl="https://www.wanandroid.com/";
    @GET("tree/json")
    Observable<KnowledgeBean>getKnowledgeData();

}
