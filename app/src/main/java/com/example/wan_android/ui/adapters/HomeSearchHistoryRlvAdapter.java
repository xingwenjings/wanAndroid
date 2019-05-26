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
import com.example.wan_android.ui.activity.SearchActivity;

import java.util.ArrayList;

/**
 * Created by apcnl on 2019/5/24.
 */

public class HomeSearchHistoryRlvAdapter extends RecyclerView.Adapter{

    private Context mContext;
    private ArrayList<String> mSearchList;
    private onItemClickListener mListener;

    public HomeSearchHistoryRlvAdapter(Context context, ArrayList<String> searchList) {

        mContext = context;
        mSearchList = searchList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_search_history, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tv.setText(mSearchList.get(i));

        holder.mImgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    mListener.clicklistener(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSearchList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private ImageView mImgClose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            mImgClose = itemView.findViewById(R.id.img_close);
        }
    }

    public interface onItemClickListener{
        void clicklistener(int position);
    }

    public void setonItemClickListener(onItemClickListener listener){
        this.mListener = listener;
    }
}
