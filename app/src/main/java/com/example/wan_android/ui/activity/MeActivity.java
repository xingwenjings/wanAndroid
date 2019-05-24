package com.example.wan_android.ui.activity;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.presenter.EmptyPresenter;
import com.example.wan_android.util.Tools;
import com.example.wan_android.view.EmptyView;

import butterknife.BindView;


public class MeActivity extends BaseActivity<EmptyView, EmptyPresenter> implements EmptyView {
    @BindView(R.id.about_image_header)
    ImageView mAboutImageHeader;
    @BindView(R.id.about_tv_android)
    TextView mAboutTvAndroid;
    @BindView(R.id.about_tv_versionName)
    TextView mAboutTvVersionName;
    @BindView(R.id.about_tv_sites_title)
    TextView mAboutTvSitesTitle;
    @BindView(R.id.about_tv_sites_content_one)
    TextView mAboutTvSitesContentOne;
    @BindView(R.id.about_tv_sites_content_two)
    TextView mAboutTvSitesContentTwo;
    @BindView(R.id.about_tv_sites_content_three)
    TextView mAboutTvSitesContentThree;
    @BindView(R.id.about_tv_sites_content_four)
    TextView mAboutTvSitesContentFour;
    @BindView(R.id.about_tv_sites_content_five)
    TextView mAboutTvSitesContentFive;
    @BindView(R.id.about_tv_sites_content_six)
    TextView mAboutTvSitesContentSix;

    @Override
    protected EmptyPresenter initPresenter() {
        return new EmptyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_me;
    }

    @Override
    protected void initView() {
        super.initView();
      /*//Integer.parseInt("https://github.com/hongyangAndroid/wanandroid")
        String versionName = Tools.getVersionName();
        mAboutTvVersionName.setText(versionName);
        //SpannableString sp = new SpannableString(mAboutTvSitesContentSix.getText().toString());
        SpannableString spannableString = new SpannableString(mAboutTvSitesContentSix.getText().toString());
        //设置超链接
        spannableString.setSpan(new URLSpan("https://github.com/iceCola7/WanAndroid"), 28, 34,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置高亮样式二
        spannableString.setSpan(new ForegroundColorSpan(Color.BLUE), 28, 34, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //设置斜体
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 28, 34, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
       //SpannableString对象设置给TextView
        mAboutTvSitesContentSix.setText(spannableString);
      //设置TextView可点击
        mAboutTvSitesContentSix.setMovementMethod(LinkMovementMethod.getInstance());
*/

    }
}
