package com.jaaaelu.gzw.threadpoolexecutordemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.jaaaelu.gzw.threadpoolexecutordemo.R;
import com.jaaaelu.gzw.threadpoolexecutordemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jaaaelu.gzw.threadpoolexecutordemo.ui.activity.UserThreadToolActivity.CACHED_THREAD_POOL;
import static com.jaaaelu.gzw.threadpoolexecutordemo.ui.activity.UserThreadToolActivity.CUSTOM_THREAD_POOL;
import static com.jaaaelu.gzw.threadpoolexecutordemo.ui.activity.UserThreadToolActivity.FIXED_THREAD_POOL;
import static com.jaaaelu.gzw.threadpoolexecutordemo.ui.activity.UserThreadToolActivity.SINGLE_THREAD_POOL;
import static com.jaaaelu.gzw.threadpoolexecutordemo.ui.activity.UserThreadToolActivity.THREAD_TOOL_TYPE;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;                               // 顶部Toolbar
    @BindView(R.id.btn_single_thread_pool)
    Button mSingleThreadPoolBtn;                    //  单线程的按钮
    @BindView(R.id.btn_fixed_thread_pool)
    Button mFixedThreadPoolBtn;                     //  固定线程的按钮
    @BindView(R.id.btn_cached_thread_pool)
    Button mCachedThreadPoolBtn;                    //  动态线程的按钮
    @BindView(R.id.btn_custom_thread_pool)
    Button mCustomThreadPoolBtn;                    //  自定义为线程的按钮

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //  初始化Toolbar
        initToolbar(mToolbar);
        mToolbar.setTitle("线程池使用Demo");
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.btn_single_thread_pool, R.id.btn_fixed_thread_pool, R.id.btn_cached_thread_pool, R.id.btn_custom_thread_pool})
    public void onClick(View view) {
        //  跳转到图片加载的页面, 并传递线程池类型参数
        Intent intent = new Intent(this, UserThreadToolActivity.class);
        switch (view.getId()) {
            case R.id.btn_single_thread_pool:
                intent.putExtra(THREAD_TOOL_TYPE, SINGLE_THREAD_POOL);
                break;
            case R.id.btn_fixed_thread_pool:
                intent.putExtra(THREAD_TOOL_TYPE, FIXED_THREAD_POOL);
                break;
            case R.id.btn_cached_thread_pool:
                intent.putExtra(THREAD_TOOL_TYPE, CACHED_THREAD_POOL);
                break;
            case R.id.btn_custom_thread_pool:
                intent.putExtra(THREAD_TOOL_TYPE, CUSTOM_THREAD_POOL);
                break;
        }
        startActivity(intent);
    }
}
