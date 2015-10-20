package com.jimmy.ordersystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * 欢迎页
 * Created by jimmy on 2015/10/12.
 */
public class WelcomeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //进行一些初始化工作

        //使用handler定时执行线程
        Handler handler = new Handler();
        handler.postDelayed(new EnterMainActivity(),2000);

    }

    class EnterMainActivity implements Runnable{
        @Override
        public void run() {
            startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            WelcomeActivity.this.finish();
        }
    }
}
