package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.CollectBean;

/**
 * Created by apcnl on 2019/5/23.
 */

public interface CollectView extends BaseMvpView{
    void setData(CollectBean bean);

    void onFail(String msg);
}
