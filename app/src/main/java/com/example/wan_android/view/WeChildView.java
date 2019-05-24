package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.WeChatBean;
import com.example.wan_android.bean.WeChatCollectBean;
import com.example.wan_android.bean.WeChildBean;

import java.util.List;

public interface WeChildView extends BaseMvpView {
    void getWeChildSuccess(WeChildBean weChildBean);
    void getWeChildField(String error);


    void getWeChatCollect(WeChatCollectBean weChatCollectBean);

}
