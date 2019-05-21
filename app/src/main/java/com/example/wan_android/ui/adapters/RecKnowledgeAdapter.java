package com.example.wan_android.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.bean.KnowledgeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecKnowledgeAdapter extends RecyclerView.Adapter<RecKnowledgeAdapter.ViewHolder> {
    private ArrayList<KnowledgeBean.DataBean> list;
    private Context context;

    public void setList(ArrayList<KnowledgeBean.DataBean> list) {
        this.list = list;
    }

    public RecKnowledgeAdapter(ArrayList<KnowledgeBean.DataBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_knowledge, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        KnowledgeBean.DataBean dataBean=list.get(i);
        viewHolder.tvTitle.setText(list.get(i).getName());
        final List<KnowledgeBean.DataBean.ChildrenBean> childrenBeans=list.get(i).getChildren();
        StringBuilder stringBuilder = new StringBuilder();
        for (KnowledgeBean.DataBean.ChildrenBean bean:childrenBeans) {
            stringBuilder.append(bean.getName()).append("   ");
        }
        viewHolder.tvName.setText(stringBuilder.toString());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onClick(i,list.get(i));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.rl_parent)
        RelativeLayout rlParent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onClick(int position,KnowledgeBean.DataBean bean);
    }
}
