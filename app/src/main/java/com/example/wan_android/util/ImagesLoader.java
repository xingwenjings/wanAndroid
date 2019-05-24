package com.example.wan_android.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImagesLoader {
    /**
     * 通过链接加载网络图片
     * @param context
     * @param url
     * @param iv
     * @param placeImg
     */
    public static void setImage(Context context, String url, ImageView iv, int placeImg){
        RequestOptions options = new RequestOptions()
                .placeholder(placeImg);
        Glide.with(context).load(url).apply(options).into(iv);
    }

    /**
     * 加载本地资源图片
     * @param context
     * @param resId
     * @param iv
     * @param placeImg
     */
    public static void setImage(Context context, int resId, ImageView iv,int placeImg){
        RequestOptions options = new RequestOptions()
                .placeholder(placeImg);
        Glide.with(context).load(resId).apply(options).into(iv);
    }

    /**
     * 加载本地资源图片--圆形
     * @param context
     * @param resId
     * @param iv
     * @param placeImg
     */
    public static void setCircleImage(Context context, int resId, ImageView iv,int placeImg){
        RequestOptions options = new RequestOptions()
                .placeholder(placeImg)
                .circleCrop();
        Glide.with(context).load(resId).apply(options).into(iv);
    }

    /**
     * 通过链接加载网络图片 -- 圆形
     * @param context
     * @param url
     * @param iv
     * @param placeImg
     */
    public static void setCircleImage(Context context, String url, ImageView iv,int placeImg){
        RequestOptions options = new RequestOptions()
                .placeholder(placeImg)
                .circleCrop();
        Glide.with(context).load(url).apply(options).into(iv);
    }


}
