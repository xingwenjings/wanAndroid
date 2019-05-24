package com.example.wan_android.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wan_android.R;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.KnowArticleBean;
import com.example.wan_android.ui.activity.LoginActivity;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecKnowArticleAdapter extends RecyclerView.Adapter<RecKnowArticleAdapter.ViewHolder> {
    private ArrayList<KnowArticleBean.DataBean.DatasBean> list;
    private Context context;
    private int num;

    public void setList(ArrayList<KnowArticleBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    public RecKnowArticleAdapter(ArrayList<KnowArticleBean.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_know_article, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.tvAuther.setText(list.get(i).getAuthor());
        viewHolder.tvData.setText(list.get(i).getNiceDate());
        viewHolder.tvChapterName.setText(list.get(i).getChapterName());
        viewHolder.tvSuperChapterName.setText(list.get(i).getSuperChapterName() + "/");
        viewHolder.tvTitle.setText(list.get(i).getTitle());
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(i).isCollect()) {
                    if ((boolean) SpUtil.getParam(Constants.LOGIN, false)) {
                        Glide.with(context).load(R.mipmap.follow_unselected).into(viewHolder.img);
                        list.get(i).setCollect(false);
                    }
                    onItemUrl.setDislike(num);
                } else {
                    if ((boolean) SpUtil.getParam(Constants.LOGIN, false)) {
                        Glide.with(context).load(R.mipmap.follow).into(viewHolder.img);
                        list.get(i).setCollect(true);
                    }
                    onItemUrl.setLike(num);
                }
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClickListener(list.get(i), i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_auther)
        TextView tvAuther;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv_data)
        TextView tvData;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_superChapterName)
        TextView tvSuperChapterName;
        @BindView(R.id.tv_chapterName)
        TextView tvChapterName;
        @BindView(R.id.rl_parent)
        RelativeLayout rlParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClickListener(KnowArticleBean.DataBean.DatasBean bean, int position);
    }

    private OnItemUrl onItemUrl;

    public void setOnItemUrl(OnItemUrl onItemUrl) {
        this.onItemUrl = onItemUrl;
    }

    public interface OnItemUrl {
        void setLike(int position);

        void setDislike(int id);
    }
}
