package com.example.wan_android.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.bean.ListBean;
import com.example.wan_android.util.GlideUtil;

import java.util.ArrayList;

/**
 * 作者：周子强
 * 邮箱：1670375515@qq.com
 * 时间：2019/5/21
 * 项目工作空间：wanAndroid
 */
public class RlvProjectClassifyAdapter extends RecyclerView.Adapter {
    private FragmentActivity mContext;
    private ArrayList<ListBean.DataBean.DatasBean> mList;
    private OnItemClickListener mListener;

    public RlvProjectClassifyAdapter(FragmentActivity activity, ArrayList<ListBean.DataBean.DatasBean> list) {
        this.mContext = activity;
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_project, null, false);
        return new ProjectViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ProjectViewHolder viewHolders = (ProjectViewHolder) viewHolder;
        ListBean.DataBean.DatasBean datasBean = mList.get(i);
        String envelopePic = datasBean.getEnvelopePic();
        String title = datasBean.getTitle();
        String desc = datasBean.getDesc();
        String author = datasBean.getAuthor();
        String niceDate = datasBean.getNiceDate();

        GlideUtil.loadUrlImage(R.mipmap.ic_launcher, R.mipmap.ic_launcher, envelopePic, viewHolders.mIv, mContext);
        viewHolders.mTitles.setText(title);
        viewHolders.mSizetitle.setText(desc);
        viewHolders.mYingwen.setText(author);
        viewHolders.mTime.setText(niceDate);

        viewHolders.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(v, i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ProjectViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIv;
        private final TextView mTitles;
        private final TextView mSizetitle;
        private final TextView mYingwen;
        private final TextView mTime;
        private final ImageView mCollect;

        public ProjectViewHolder(@NonNull View itemView) {
            super(itemView);

            mIv = itemView.findViewById(R.id.iv);
            mTitles = itemView.findViewById(R.id.titles);
            mSizetitle = itemView.findViewById(R.id.sizetitle);
            mYingwen = itemView.findViewById(R.id.yingwen);
            mTime = itemView.findViewById(R.id.times);
            mCollect = itemView.findViewById(R.id.collect);
        }
    }

    //接口回调
    //1.写个接口
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    //2.写个方法,将OnItemClickListener设置到Adapter中
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}
