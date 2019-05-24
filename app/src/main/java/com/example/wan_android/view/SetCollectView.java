package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.SetCollectBean;

/**
 * Created by apcnl on 2019/5/24.
 */

public interface SetCollectView extends BaseMvpView{
    void setData(SetCollectBean bean);

    void onFail(String msg);
}
