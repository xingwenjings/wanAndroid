package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.NavigationBean;

/**
 * Created by apcnl on 2019/5/20.
 */

public interface NaviView extends BaseMvpView{
    void setData(NavigationBean bean);

    void onFail(String msg);
}
