package com.example.wan_android.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wan_android.R;
import com.example.wan_android.bean.SearchChildBean;
import com.example.wan_android.ui.activity.SearchChildActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apcnl on 2019/5/24.
 */

public class SearchChildRlvAdapter extends RecyclerView.Adapter{

    private Context mContext;
    private ArrayList<SearchChildBean.DataBean.DatasBean> mList;

    public SearchChildRlvAdapter(Context context, ArrayList<SearchChildBean.DataBean.DatasBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0){
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_holllist, null, false);
            return new Viewholder(inflate);
        }else {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_holllist, null, false);
            return new Viewholder2(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 0){
            Viewholder holder = (Viewholder) viewHolder;
            holder.re_contauber.setVisibility(View.GONE);
            holder.mname.setText(mList.get(i).getAuthor());
            holder.mriqi.setText(mList.get(i).getNiceDate());
            holder.mnei.setText(mList.get(i).getTitle());
            holder.mbiaoti.setText(mList.get(i).getSuperChapterName() + "/" + mList.get(i).getChapterName());
        }else {
            Viewholder2 holder = (Viewholder2) viewHolder;
            holder.re_contauber.setVisibility(View.VISIBLE);
            holder.mname.setText(mList.get(i).getAuthor());
            holder.mriqi.setText(mList.get(i).getNiceDate());
            holder.mnei.setText(mList.get(i).getTitle());
            holder.mbiaoti.setText(mList.get(i).getSuperChapterName() + "/" + mList.get(i).getChapterName());
            holder.mthepubli.setText(mList.get(i).getSuperChapterName());
            int width = holder.mthepubli.getWidth();
            holder.mtupian.setMaxWidth(width);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).getTags().size()>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addData(SearchChildBean bean) {
        this.mList.addAll(bean.getData().getDatas());
        notifyDataSetChanged();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        private ImageView mtupian;
        private TextView mriqi;
        private TextView mthepubli;
        private TextView mbiaoti;
        private TextView mnei;
        private TextView mname;
        private RelativeLayout re_contauber;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            mnei = itemView.findViewById(R.id.neirong);
            mthepubli = itemView.findViewById(R.id.thepublic);
            mbiaoti = itemView.findViewById(R.id.biaoti);
            mriqi = itemView.findViewById(R.id.riqi);
            mname = itemView.findViewById(R.id.name);
            mtupian = itemView.findViewById(R.id.tupian);
            re_contauber = itemView.findViewById(R.id.re);
        }
    }

    class Viewholder2 extends RecyclerView.ViewHolder {

        private ImageView mtupian;
        private TextView mriqi;
        private TextView mthepubli;
        private TextView mbiaoti;
        private TextView mnei;
        private TextView mname;
        private RelativeLayout re_contauber;

        public Viewholder2(@NonNull View itemView) {
            super(itemView);
            mnei = itemView.findViewById(R.id.neirong);
            mthepubli = itemView.findViewById(R.id.thepublic);
            mbiaoti = itemView.findViewById(R.id.biaoti);
            mriqi = itemView.findViewById(R.id.riqi);
            mname = itemView.findViewById(R.id.name);
            mtupian = itemView.findViewById(R.id.tupian);
            re_contauber = itemView.findViewById(R.id.re);
        }
    }
}
