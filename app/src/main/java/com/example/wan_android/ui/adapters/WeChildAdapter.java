package com.example.wan_android.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.bean.WeChatBean;
import com.example.wan_android.bean.WeChildBean;

import java.util.ArrayList;
import java.util.List;

public class WeChildAdapter extends RecyclerView.Adapter<WeChildAdapter.ViewHolder> {
    private ArrayList<WeChildBean.DataBean.DatasBean> datasBeans;
    private Context context;

    public WeChildAdapter(ArrayList<WeChildBean.DataBean.DatasBean> datasBeans, Context context) {
        this.datasBeans = datasBeans;
        this.context = context;
    }


    public void setDatasBeans(ArrayList<WeChildBean.DataBean.DatasBean> datasBeans) {
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_wechild, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.child_name.setText(datasBeans.get(i).getChapterName());
        viewHolder.data.setText(datasBeans.get(i).getNiceDate());
        viewHolder.titles.setText(datasBeans.get(i).getTitle());
        viewHolder.author.setText(datasBeans.get(i).getSuperChapterName()+datasBeans.get(i).getChapterName());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick.OnClickItem(datasBeans.get(i),i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datasBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView child_name;
        private TextView data;
        private TextView titles;
        private TextView author;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            child_name=itemView.findViewById(R.id.child_name);
            data=itemView.findViewById(R.id.data);
            titles=itemView.findViewById(R.id.titles);
            author=itemView.findViewById(R.id.author);
            img=itemView.findViewById(R.id.img);
        }
    }
    private setOnClick setOnClick;

    public void setSetOnClick(WeChildAdapter.setOnClick setOnClick) {
        this.setOnClick = setOnClick;
    }

    public interface setOnClick{
        void OnClickItem(WeChildBean.DataBean.DatasBean datasBean,int position);
    }
}
