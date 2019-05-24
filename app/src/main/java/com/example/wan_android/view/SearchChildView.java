package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.SearchChildBean;

/**
 * Created by apcnl on 2019/5/24.
 */

public interface SearchChildView extends BaseMvpView{
    void onFail(String msg);

    void setData(SearchChildBean bean);
}
