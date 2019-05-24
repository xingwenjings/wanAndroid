package com.example.wan_android.ui.activity;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.base.BaseActivity;
import com.example.wan_android.presenter.TodoxinzengPresenter;
import com.example.wan_android.util.Logger;
import com.example.wan_android.view.TodoxinzengView;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import java.util.Calendar;
import butterknife.BindView;
import static com.example.wan_android.util.UIUtils.getContext;

public class TodoxinzengActivity extends BaseActivity<TodoxinzengView, TodoxinzengPresenter> implements TodoxinzengView {

    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.yiban)
    RadioButton mYiban;
    @BindView(R.id.zhongyao)
    RadioButton mZhongyao;
    @BindView(R.id.radioGroup_gender)
    RadioGroup mRadioGroupGender;
    @BindView(R.id.riqi)
    TextView mRiqi;
    @BindView(R.id.relati_riqi)
    RelativeLayout mRelatiRiqi;
    private PopupWindow mPopupWindow;
    private MaterialCalendarView mvs;
    CalendarDay currentDate;//自定义的日期对象


    @Override
    protected TodoxinzengPresenter initPresenter() {
        return new TodoxinzengPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todoxinzeng;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRelatiRiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inirili();
            }
        });

    }

    private void inirili() {
        mPopupWindow = new PopupWindow();
        final View inflate = LayoutInflater.from(getContext()).inflate(R.layout.todorili, null, false);

        mPopupWindow.setContentView(inflate);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        mPopupWindow.setOutsideTouchable(true);
        inflate.findViewById(R.id.te_qu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();

            }
        });
        inflate.findViewById(R.id.te_que).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mvs = inflate.findViewById(R.id.mvs);
                //编辑日历属性
                mvs.state().edit()
                        .setFirstDayOfWeek(Calendar.MONDAY)   //设置每周开始的第一天
                        .setMinimumDate(CalendarDay.from(2010, 4, 3))  //设置可以显示的最早时间
                        .setMaximumDate(CalendarDay.from(2018, 5, 12))//设置可以显示的最晚时间
                        .setCalendarDisplayMode(CalendarMode.MONTHS)//设置显示模式，可以显示月的模式，也可以显示周的模式
                        .commit();// 返回对象并保存
                //      设置点击日期的监听
                mvs.setOnDateChangedListener(new OnDateSelectedListener() {
                    @Override
                    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                        currentDate=date;
                        int year = currentDate.getYear();
                        int month = currentDate.getMonth() + 1; //月份跟系统一样是从0开始的，实际获取时要加1
                        int day = currentDate.getDay();
                        String todoriqi=year+"-"+ month+"-"+day;
                        mRiqi.setText(todoriqi);
                    }
                });
                Logger.logD("dsdfsdf","日历"+currentDate);
                mPopupWindow.dismiss();
            }
        });

        mPopupWindow.showAtLocation(mRiqi, Gravity.CENTER, 0, 0);
    }


}
