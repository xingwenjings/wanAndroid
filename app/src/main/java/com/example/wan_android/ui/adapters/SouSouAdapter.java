package com.example.wan_android.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.bean.SearchBean;
import com.example.wan_android.util.ColorUtil;

import java.util.ArrayList;

public class SouSouAdapter extends RecyclerView.Adapter<SouSouAdapter.ViewHolder>{
   private ArrayList<SearchBean.DataBean> dataBeans;
   private Context context;

    public SouSouAdapter(ArrayList<SearchBean.DataBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;
    }

    public void setDataBeans(ArrayList<SearchBean.DataBean> dataBeans) {
        this.dataBeans = dataBeans;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_label_search, null);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final SearchBean.DataBean dataBean = dataBeans.get(i);
        viewHolder.tv.setText(dataBeans.get(i).getName());
        viewHolder.tv.setBackgroundColor(Color.parseColor(ColorUtil.getRandomColor()));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onclick!= null){
                    onclick.onclick(i,dataBean);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
             tv = itemView.findViewById(R.id.tv_title);
        }
    }

    public itemClick onclick;
    public interface itemClick{
        void onclick(int position, SearchBean.DataBean dataBean);
    }

    public void setOnclick(itemClick onclick) {
        this.onclick = onclick;
    }
}
