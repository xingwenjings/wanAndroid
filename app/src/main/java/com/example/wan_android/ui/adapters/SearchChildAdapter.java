package com.example.wan_android.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wan_android.R;

import java.util.ArrayList;

public class SearchChildAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> list;

    public SearchChildAdapter(Context mContext, ArrayList<String> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.search_child_item,null);
            TextView name = convertView.findViewById(R.id.tv_name);
            name.setText(list.get(position));

        }
        return convertView;
    }
}
