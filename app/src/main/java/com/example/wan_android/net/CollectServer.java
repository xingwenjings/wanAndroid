package com.example.wan_android.net;

import com.example.wan_android.bean.LoginInfo;
import com.example.wan_android.bean.ZWBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CollectServer {
    public String URL="https://www.wanandroid.com/lg/collect/{id}/";
    @POST("json")
    Observable<String>getCollectData(@Path("id")String id);

    public String DisURL="https://www.wanandroid.com/lg/uncollect_originId/{id}/";
    @POST("json")
    Observable<String>disCollectData(@Path("id")String id);

    //收藏站外文章
    public String ZWUrl="https://www.wanandroid.com/lg/collect/add/";
    @POST("json")
    Observable<ZWBean> zwData(@Field("username")String username,
                                @Field("password")String password,
                                @Field("title")String title,
                                @Field("author")String author,
                                @Field("link")String link);

}
