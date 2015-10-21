package com.jimmy.ordersystem.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jimmy.ordersystem.R;
import com.jimmy.ordersystem.bean.NavigationBean;
import com.jimmy.ordersystem.listener.OnRecyclerViewListener;

import java.util.List;

/**
 * Created by huguangwen on 15/10/21.
 */
public class NavigationAdapter extends RecyclerView.Adapter {
    private List<NavigationBean> list;
    private OnRecyclerViewListener onRecyclerViewListener;

    public NavigationAdapter(List<NavigationBean> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.navigation_item, null);
        return new NavigationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NavigationViewHolder viewHolder = (NavigationViewHolder) holder;
        viewHolder.position = position;
        NavigationBean bean = list.get(position);
        viewHolder.imageView.setImageResource(bean.iconID);
        viewHolder.textView.setText(bean.label);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }

    class NavigationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public View rootView;
        public ImageView imageView;
        public TextView textView;
        public int position;

        public NavigationViewHolder(View itemView) {
            super(itemView);
            rootView = itemView.findViewById(R.id.rl_navigation_item);
            imageView = (ImageView) itemView.findViewById(R.id.iv_navigation_item);
            textView = (TextView) itemView.findViewById(R.id.tv_navigation_item);
            rootView.setOnClickListener(this);
            rootView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (null != onRecyclerViewListener) {
                onRecyclerViewListener.onItemClick(position);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (null != onRecyclerViewListener) {
                return onRecyclerViewListener.onItemLongClick(position);
            }
            return false;
        }
    }
}
