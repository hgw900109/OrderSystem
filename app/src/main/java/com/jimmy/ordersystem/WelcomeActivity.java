package com.jimmy.ordersystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;

import com.jimmy.ordersystem.constant.StaticCache;

/**
 * 欢迎页
 * Created by jimmy on 2015/10/12.
 */
public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //进行一些初始化工作
        initStaticCache();//初始化静态变量，便用全局使用
        //使用handler定时执行线程
        Handler handler = new Handler();
        handler.postDelayed(new EnterMainActivity(), 2000);

    }

    class EnterMainActivity implements Runnable {
        @Override
        public void run() {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            WelcomeActivity.this.finish();
        }
    }

    private void initStaticCache() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        if (StaticCache.ScreenHeight == 0) {
            StaticCache.ScreenHeight = dm.heightPixels;
        }
        if (StaticCache.ScreenWidth == 0) {
            StaticCache.ScreenWidth = dm.widthPixels;
        }
    }
}
