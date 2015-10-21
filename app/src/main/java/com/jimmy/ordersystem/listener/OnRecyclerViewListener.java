package com.jimmy.ordersystem.listener;

/**
 * RecyclerView没有提供点击和长按事件，因此，我们需要在适配器中实现所需的事件方法
 * Created by huguangwen on 15/10/21.
 */
public interface OnRecyclerViewListener {
    //RecyclerView的每个item点击事件
    void onItemClick(int position);
    //RecyclerView的每个item长按事件
    boolean onItemLongClick(int position);
}
