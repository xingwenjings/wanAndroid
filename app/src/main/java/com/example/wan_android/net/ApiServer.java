package com.example.wan_android.net;

import com.example.wan_android.bean.ClassifyBean;
import com.example.wan_android.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/20
 * 项目工作空间：wanandroid
 */
public interface ApiServer {

    /**
     *  项目分类
     *
     */
    String ClassIfyUrl = "https://www.wanandroid.com/project/tree/";
    int SUCCESS_CODE = 0;

    @GET("json")
    Observable<ClassifyBean> getDataClassify();



    /**
     * 项目列表数据
     *
     */
    String ListUrl = "https://www.wanandroid.com/";
    @GET("project/list/{page}/json?")
    Observable<ListBean> getDataList(@Path("page") int page, @Query("cid") int cid);
}
