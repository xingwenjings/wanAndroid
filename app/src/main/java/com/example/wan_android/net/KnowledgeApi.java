package com.example.wan_android.net;

import com.example.wan_android.bean.KnowArticleBean;
import com.example.wan_android.bean.KnowledgeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface KnowledgeApi {
    public String BaseUrl="https://www.wanandroid.com/";
    @GET("tree/json")
    Observable<KnowledgeBean>getKnowledgeData();

    @GET("article/list/{page}/json")
    Observable<KnowArticleBean>getKnowArticleData(@Path("page") int page, @Query("cid") int cid);
}
