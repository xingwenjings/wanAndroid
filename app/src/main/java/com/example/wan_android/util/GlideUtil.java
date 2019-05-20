package com.example.wan_android.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;


/**
 * Created by 灵风 on 2019/5/6.
 */

public class GlideUtil {
    /**
     * 加载圆形资源图片
     * @param errorImg      图片加载错误时显示的图片
     * @param placeholderImg    图片加载时的占位图
     * @param imgId         要加载的资源图片Id
     * @param iv
     * @param context
     */
    public static void loadResCircleImage(int errorImg, int placeholderImg, int imgId, ImageView iv, Context context){
        RequestOptions options = new RequestOptions()
                .error(errorImg)
                .placeholder(placeholderImg)
                .circleCrop();
        Glide.with(context)
                .load(imgId)
                .apply(options)
                .into(iv);
    }

    //加载资源图片
    public static void loadResImage(int errorImg, int placeholderImg, int imgId, ImageView iv, Context context){
        RequestOptions options = new RequestOptions()
                .error(errorImg)
                .placeholder(placeholderImg);
        Glide.with(context)
                .load(imgId)
                .apply(options)
                .into(iv);
    }

    /**
     *  加载圆形网络图片
     * @param errorImg      图片加载错误时显示的图片
     * @param placeholderImg    图片加载时的占位图
     * @param url         要加载的图片路径
     * @param iv
     * @param context
     */
    public static void loadUrlCircleImage(int errorImg, int placeholderImg, String url, ImageView iv, Context context){
        RequestOptions options = new RequestOptions()
                .error(errorImg)
                .placeholder(placeholderImg)
                .circleCrop();
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    //加载网络图片
    public static void loadUrlImage(int errorImg, int placeholderImg, String url, ImageView iv, Context context){
        RequestOptions options = new RequestOptions()
                .error(errorImg)
                .placeholder(placeholderImg);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }

    public static void loadUrlRoundImg(int roundRadius,int errorImg, int placeholderImg, String url, ImageView iv, Context context) {
        RoundedCorners corners = new RoundedCorners(SystemUtil.dp2px(roundRadius));
        RequestOptions options = RequestOptions.bitmapTransform(corners)
                .error(errorImg)
                .placeholder(placeholderImg);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(iv);
    }
}
