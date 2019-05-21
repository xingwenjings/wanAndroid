package com.example.wan_android.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.bean.NavigationBean;
import com.example.wan_android.util.UIUtils;
import com.example.wan_android.widght.FlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apcnl on 2019/5/21.
 */

public class NaviRlvAdapter extends RecyclerView.Adapter{

    private Context mContext;
    private ArrayList<NavigationBean.DataBean> mList;

    public NaviRlvAdapter(Context context, ArrayList<NavigationBean.DataBean> list) {

        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_navi, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.mFlowLayout.removeAllViews();
        NavigationBean.DataBean dataBean = mList.get(i);
        List<NavigationBean.DataBean.ArticlesBean> list = dataBean.getArticles();
        for (int j = 0; j < list.size(); j++) {
            //获取视图,视图可以自定义,可以添加自己想要的效果
            View inflate = View.inflate(mContext, R.layout.item_label, null);
            TextView label = inflate.findViewById(R.id.tv_title);
            //获取数据
            final String title = list.get(j).getTitle();
            //绑定数据
            label.setText(title);
            //设置字体颜色
            setTextColor(title,label,j);
            //加到容器中,parent是FlowLayout
            holder.mFlowLayout.addView(inflate);
        }
        int index = 0;
        for (int j = index; j < list.size(); j++) {
            String name = list.get(j).getChapterName();
            holder.title.setText(name);
            index++;
            return;
        }
    }

    private void setTextColor(String title, TextView label, int j) {
        String s = label.getText().toString();
        if (title.length() >0 &&title.length() <3){
            label.setTextColor(UIUtils.getColor(R.color.c_fa6a13));
        }else if (title.length() >=3 &&title.length() <6){
            label.setTextColor(UIUtils.getColor(R.color.colorPrimaryDark));
        }else if (title.length() >=6 &&title.length() <9){
            label.setTextColor(UIUtils.getColor(R.color.c_FF9D53));
        }else if (title.length() >=9 &&title.length() <12){
            label.setTextColor(UIUtils.getColor(R.color.colorPrimary));
        }else if (title.length() >=12){
            label.setTextColor(UIUtils.getColor(R.color.c_333333));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(List<NavigationBean.DataBean> data) {
        this.mList.clear();
        this.mList.addAll(data);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private FlowLayout mFlowLayout;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mFlowLayout = itemView.findViewById(R.id.fl);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}
