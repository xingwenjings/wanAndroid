package com.example.wan_android.net;

import com.example.wan_android.bean.KnowArticleBean;
import com.example.wan_android.bean.KnowledgeBean;
import com.example.wan_android.bean.LoginInfo;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface KnowledgeApi {
    public String BaseUrl="https://www.wanandroid.com/";
    int SUCCESS_CODE = 0;

    @GET("tree/json")
    Observable<KnowledgeBean>getKnowledgeData();

    @GET("article/list/{page}/json")
    Observable<KnowArticleBean>getKnowArticleData(@Path("page") int page, @Query("cid") int cid);

    public String Url = "http://yun918.cn/study/public/index.php/";

    public String LoginUrl="https://www.wanandroid.com/user/";
    @POST("login")
    @FormUrlEncoded
    Observable<LoginInfo> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Observable<LoginInfo> register(@Field("username")String username, @Field("password")String psw, @Field("repassword")String rePsw);

}
