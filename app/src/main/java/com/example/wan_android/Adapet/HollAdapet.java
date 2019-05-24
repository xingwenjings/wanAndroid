package com.example.wan_android.Adapet;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wan_android.R;
import com.example.wan_android.base.Constants;
import com.example.wan_android.bean.HollBannerbean;
import com.example.wan_android.bean.HollListbean;
import com.example.wan_android.bean.HollZhidingbean;
import com.example.wan_android.ui.activity.HollBannerdetailsActivity;
import com.example.wan_android.ui.activity.HollListdetailsActivity;
import com.example.wan_android.ui.activity.HollZhidingdetailsActivity;
import com.example.wan_android.util.Logger;
import com.example.wan_android.util.SpUtil;
import com.example.wan_android.util.UIUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HollAdapet extends RecyclerView.Adapter {
    private Context mCon;
    private List<HollListbean.DataBean.DatasBean> mholllist;
    private List<HollBannerbean.DataBean> mhollbanner;
    private List<HollZhidingbean.DataBean> mhollZhiding;
    private OnBannerListener mBannerlistener;
    private OnItemClickListener mListener;

    public HollAdapet(Context context, List<HollBannerbean.DataBean> mhollbanner, List<HollListbean.DataBean.DatasBean> mholllist, List<HollZhidingbean.DataBean> mhollZhiding) {
        this.mCon = context;
        this.mhollbanner = mhollbanner;
        this.mholllist = mholllist;
        this.mhollZhiding = mhollZhiding;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder = null;
        if (i == 0) {
            View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_hollbanner, null, false);
            holder = new BannerH(inflate);
        } else if (i == 1) {
            View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_hollzhi, null, false);
            holder = new ZhiH(inflate);
        } else {
            View inflate = LayoutInflater.from(mCon).inflate(R.layout.item_holllist, null, false);
            holder = new ListH(inflate);
        }
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        if (viewHolder instanceof BannerH) {
            BannerH bannerh = (BannerH) viewHolder;
            ArrayList<String> strings = new ArrayList<>();
            for (int j = 0; j < mhollbanner.size(); j++) {
                String title = mhollbanner.get(j).getTitle();
                strings.add(title);
            }
            bannerh.mbanner.setImages(mhollbanner);
            bannerh.mbanner.setBannerTitles(strings);
            bannerh.mbanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
            bannerh.mbanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    HollBannerbean.DataBean banner = (HollBannerbean.DataBean) path;
                    Glide.with(context).load(banner.getImagePath()).into(imageView);
                }
            }).start();
            bannerh.mbanner.setOnBannerListener(new com.youth.banner.listener.OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Intent intent = new Intent(mCon, HollBannerdetailsActivity.class);
                    intent.putExtra(Constants.TITLE, mhollbanner.get(position).getTitle());
                    intent.putExtra(Constants.URL, mhollbanner.get(position).getUrl());
                    mCon.startActivity(intent);
                }
            });
        } else if (viewHolder instanceof ZhiH) {
            int p = i;
            if (mhollbanner.size() > 0) {
                p = i - 1;
            }
            ZhiH zhiH = (ZhiH) viewHolder;
            zhiH.mtupian.setBackgroundResource(R.drawable.holl_itemlist_borc_ff1a00f);
            zhiH.mthepubli.setText("置 顶");
            zhiH.mthepubli.setTextColor(UIUtils.getColor(R.color.c_ff1a00));
            zhiH.mbiaoti.setText(mhollZhiding.get(p).getSuperChapterName() + "/" + mhollZhiding.get(p).getChapterName());
            zhiH.mnei.setText(mhollZhiding.get(p).getTitle());
            zhiH.mriqi.setText(mhollZhiding.get(p).getNiceDate());
            zhiH.mname.setText(mhollZhiding.get(p).getAuthor());
            final int finalP = p;
            zhiH.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mCon, HollZhidingdetailsActivity.class);
                    SpUtil.setParam(Constants.TITLE, mhollZhiding.get(finalP).getTitle());
                    SpUtil.setParam(Constants.URL, mhollZhiding.get(finalP).getLink());
                    mCon.startActivity(intent);
                }
            });
        } else {
            int p = i;
            if (mhollZhiding.size() > 0) {
                p = i - 1;
            }
            final ListH listh = (ListH) viewHolder;
            listh.mtupian.setBackgroundResource(R.drawable.holl_itemlist_borc_00ceff);
            listh.mthepubli.setText("项 目");
            listh.mthepubli.setTextColor(UIUtils.getColor(R.color.c_00ceff));

            listh.mbiaoti.setText(mholllist.get(p).getSuperChapterName() + "/" + mholllist.get(p).getChapterName());
            listh.mnei.setText(mholllist.get(p).getTitle());
            listh.mriqi.setText(mholllist.get(p).getNiceDate());
            listh.mname.setText(mholllist.get(p).getAuthor());
            final int finalP = p;
            listh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.OnItemClick(v, finalP);
                    }
                }
            });

        }


    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1 || position == 2) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public int getItemCount() {
        if (mhollbanner.size() > 0) {
            return mholllist.size() + 1;
        } else if(mhollZhiding.size()>1){
            return mholllist.size()+1;
        }else {
            return mholllist.size();
        }
    }

    public void setListData(List<HollListbean.DataBean.DatasBean> mholllist) {
        this.mholllist.addAll(mholllist);
        notifyDataSetChanged();
    }

    public void setBanner(List<HollBannerbean.DataBean> mhollbanner) {
        this.mhollbanner.addAll(mhollbanner);
        notifyDataSetChanged();
    }

    public void setZhiding(List<HollZhidingbean.DataBean> mhollZhiding) {
        this.mhollZhiding.addAll(mhollZhiding);
        notifyDataSetChanged();
    }


    class BannerH extends RecyclerView.ViewHolder {

        private Banner mbanner;

        public BannerH(@NonNull View itemView) {
            super(itemView);
            mbanner = itemView.findViewById(R.id.banner);
        }
    }

    class ListH extends RecyclerView.ViewHolder {

        private RelativeLayout mre;
        private ImageView mtupian;
        private TextView mriqi;
        private TextView mthepubli;
        private TextView mbiaoti;
        private TextView mnei;
        private TextView mname;

        public ListH(@NonNull View itemView) {
            super(itemView);
            mnei = itemView.findViewById(R.id.neirong);
            mthepubli = itemView.findViewById(R.id.thepublic);
            mbiaoti = itemView.findViewById(R.id.biaoti);
            mriqi = itemView.findViewById(R.id.riqi);
            mname = itemView.findViewById(R.id.name);
            mtupian = itemView.findViewById(R.id.tupian);
            mre = itemView.findViewById(R.id.re);
        }
    }

    class ZhiH extends RecyclerView.ViewHolder {

        private ImageView mtupian;
        private TextView mriqi;
        private TextView mthepubli;
        private TextView mbiaoti;
        private TextView mnei;
        private TextView mname;

        public ZhiH(@NonNull View itemView) {
            super(itemView);
            mnei = itemView.findViewById(R.id.neirong);
            mthepubli = itemView.findViewById(R.id.thepublic);
            mbiaoti = itemView.findViewById(R.id.biaoti);
            mriqi = itemView.findViewById(R.id.riqi);
            mname = itemView.findViewById(R.id.name);
            mtupian = itemView.findViewById(R.id.tupian);

        }
    }

    public interface OnItemClickListener {
        void OnItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnBannerListener {
        void OnBannerItemClick(View v, int position);
    }

    public void setOnBannerListener(OnBannerListener Bannerlistener) {
        this.mBannerlistener = Bannerlistener;
    }
}
