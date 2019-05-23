package com.example.wan_android.view;

import com.example.wan_android.base.BaseMvpView;
import com.example.wan_android.bean.SearchBean;

public interface SearchView extends BaseMvpView {
    void getSearchSuccess(SearchBean searchBean);
    void getSearchField(String error);
}
