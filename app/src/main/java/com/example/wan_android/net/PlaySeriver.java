package com.example.wan_android.net;

import com.example.wan_android.bean.SearchBean;
import com.example.wan_android.bean.WeChatBean;
import com.example.wan_android.bean.WeChatCollectBean;
import com.example.wan_android.bean.WeChatOutsideBean;
import com.example.wan_android.bean.WeChildBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PlaySeriver {
    public static final int SUCCESS_CODE = 0;
    public static final int VERIFY_CODE_ERROR = 200502;
    public static final int WECHAT_HAVE_BINDED = 20171102;
    //token 失效
    public static final int TOKEN_EXPIRE = 20170707;
    //余额不足
    public static final int MONEY_NOT_ENOUGH = 200607;
    String BASE_URL = "http://wanandroid.com/";

    @GET("wxarticle/chapters/json")
    Observable<WeChatBean> getWeChat();

    @GET("wxarticle/list/{id}/{page}/json")
    Observable<WeChildBean> getChildData(@Path("id") int id,@Path("page") int page);

    //搜索
    //http://www.wanandroid.com//hotkey/json
    String api_shou = "http://www.wanandroid.com///hotkey/";
    @GET("json")
    Observable<SearchBean> getSearch();


    /**
     * 收藏
     * @param userName
     * @param password
     * @param id
     * @return
     */
    @POST("lg/collect/{id}/json")
    Observable<WeChatCollectBean> setCollect(@Header("Cookie") String userName,
                                             @Header("Cookie") String password,
                                             @Path("id") int id);


}
