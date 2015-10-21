package com.jimmy.ordersystem;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.jimmy.ordersystem.adapter.NavigationAdapter;
import com.jimmy.ordersystem.bean.NavigationBean;
import com.jimmy.ordersystem.constant.StaticCache;
import com.jimmy.ordersystem.listener.OnRecyclerViewListener;
import com.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    @Bind(R.id.iv_navigation)
    ImageView ivNavigation;
    @Bind(R.id.rv_navigation)
    RecyclerView rvNavigation;
    private SlidingMenu menu;//左滑菜单
    private NavigationAdapter adapter;//导航菜单适配器
    private List<NavigationBean> navigationBeanList;//导航菜单数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化左滑菜单
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setBehindOffset(StaticCache.ScreenWidth / 5);
        menu.setFadeDegree(0.35f);
        menu.setFadeEnabled(true);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.navigation);
        //注入组件
        ButterKnife.bind(this);
        //初始化导航菜单列表
        rvNavigation.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvNavigation.setLayoutManager(layoutManager);
        initNavigationData();
        adapter = new NavigationAdapter(navigationBeanList);
        adapter.setOnRecyclerViewListener(new OnRecyclerViewListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public boolean onItemLongClick(int position) {
                return false;
            }
        });
        rvNavigation.setAdapter(adapter);

    }

    private void initNavigationData() {
        navigationBeanList = new ArrayList<NavigationBean>();
        NavigationBean bean = new NavigationBean();
        bean.iconID = R.mipmap.topbar_navigation;
        bean.label = "点菜";
        navigationBeanList.add(bean);
    }

    @OnClick({R.id.iv_navigation})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_navigation:
                menu.toggle();
                break;
            default:
                break;
        }

    }
}
