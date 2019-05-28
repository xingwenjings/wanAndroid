package com.example.wan_android.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.bean.CollectBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apcnl on 2019/5/23.
 */

public class CollectRlvAdapter extends RecyclerView.Adapter{

    private Context mContext;
    private ArrayList<CollectBean.DataBean.DatasBean> mList;

    public CollectRlvAdapter(Context context, ArrayList<CollectBean.DataBean.DatasBean> list) {

        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_collect, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        CollectBean.DataBean.DatasBean bean = mList.get(i);
        holder.author.setText(bean.getAuthor());
        holder.chapterName.setText(bean.getChapterName());
        holder.niceDate.setText(bean.getNiceDate());
        holder.title.setText(bean.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(List<CollectBean.DataBean.DatasBean> datas) {
        this.mList.addAll(datas);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView author;
        private TextView niceDate;
        private TextView title;
        private TextView chapterName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.tv_name);
            niceDate = itemView.findViewById(R.id.tv_niceDate);
            chapterName = itemView.findViewById(R.id.tv_chapterName);
            title = itemView.findViewById(R.id.tv_title);
        }
    }
}