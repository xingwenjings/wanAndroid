package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.WeChatBean;

public interface WeChatView extends BaseMvpView {
    void getWeChatSuccess(WeChatBean weChatBean);
    void getWeChatField(String error);
}
