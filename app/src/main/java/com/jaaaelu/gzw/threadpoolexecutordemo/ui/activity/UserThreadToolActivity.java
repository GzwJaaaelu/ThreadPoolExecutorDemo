package com.jaaaelu.gzw.threadpoolexecutordemo.ui.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jaaaelu.gzw.threadpoolexecutordemo.R;
import com.jaaaelu.gzw.threadpoolexecutordemo.base.BaseActivity;
import com.jaaaelu.gzw.threadpoolexecutordemo.ui.adapter.ImageLoadAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserThreadToolActivity extends BaseActivity {
    public static final String THREAD_TOOL_TYPE = "THREAD_TOOL_TYPE";           //  线程池类型常量
    public static final String SINGLE_THREAD_POOL = "single_thread_pool";       //  表示单线程的线程池常量
    public static final String FIXED_THREAD_POOL = "fixed_thread_pool";         //  表示固定线程数的线程池常量
    public static final String CACHED_THREAD_POOL = "cached_thread_pool";       //  表示动态线程数的线程池常量
    public static final String CUSTOM_THREAD_POOL = "custom_thread_pool";       //  表示自定义的线程池常量
    @BindView(R.id.toolbar)
    Toolbar mToolbar;                                                           //  顶部的Toolbar
    @BindView(R.id.rv_image_list)
    RecyclerView mShowImagesView;                                               //  展示图片的列表
    public ExecutorService mExecutorService;                                    //  线程池
    public List<String> mImageUrl;                                              //  图片链接的List
    private ImageLoadAdapter mAdapter;                                          //  列表的适配器

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_thread_tool;
    }

    @Override
    protected void getData() {
        //  根据拿到的不同常量创建不同类型的线程池
        String type = getIntent().getStringExtra(THREAD_TOOL_TYPE);
        switch (type) {
            case SINGLE_THREAD_POOL:
                mExecutorService = Executors.newSingleThreadExecutor();
                break;
            case FIXED_THREAD_POOL:
                mExecutorService = Executors.newFixedThreadPool(3);
                break;
            case CACHED_THREAD_POOL:
                mExecutorService = Executors.newCachedThreadPool();
                break;
            case CUSTOM_THREAD_POOL:
                int cpuCount = Runtime.getRuntime().availableProcessors();
                int corePool = cpuCount + 1;
                int maximumPoolSize = 2 * cpuCount;

                mExecutorService = new ThreadPoolExecutor(corePool,     //  核心线程数
                        maximumPoolSize,                                //  最大线程数
                        30L,                                            //  空闲线程存活时间
                        TimeUnit.SECONDS,                               //  时间单位
                        new LinkedBlockingDeque<Runnable>(20));         //  任务等待队列
                break;
        }
        mImageUrl = girlList();
    }

    @Override
    protected void initView() {
        initToolbar(mToolbar);
        mToolbar.setTitle("图片加载");
        //  初始化列表
        mShowImagesView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ImageLoadAdapter(this);
        mShowImagesView.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {

    }

    public List<String> girlList() {
        //  假数据 图片来源来自GankIo
        List<String> girlList = new ArrayList<>();
        girlList.add("http://ww3.sinaimg.cn/large/7a8aed7bgw1etlw75so1hj20qo0hsgpk.jpg");
        girlList.add("http://ww3.sinaimg.cn/large/7a8aed7bjw1eyd07uugyvj20qo0hqgom.jpg");
        girlList.add("http://ww1.sinaimg.cn/large/610dc034jw1fahy9m7xw0j20u00u042l.jpg");
        girlList.add("http://ww4.sinaimg.cn/large/610dc034jw1fagrnmiqm1j20u011hanr.jpg");
        girlList.add("http://ww4.sinaimg.cn/large/610dc034gw1fafmi73pomj20u00u0abr.jpg");
        girlList.add("http://ww4.sinaimg.cn/large/610dc034gw1fac4t2zhwsj20sg0izahf.jpg");
        girlList.add("http://ww1.sinaimg.cn/large/7a8aed7bgw1esojpl5gmgj20qo0hstbs.jpg");
        girlList.add("http://ww1.sinaimg.cn/large/7a8aed7bgw1evdga4dimoj20qo0hsmzf.jpg");
        girlList.add("http://ww2.sinaimg.cn/large/610dc034jw1fa8n634v0vj20u00qx0x4.jpg");
        girlList.add("http://ww3.sinaimg.cn/large/610dc034jw1fa7jol4pgvj20u00u0q51.jpg");
        girlList.add("http://ww2.sinaimg.cn/large/610dc034gw1f9zjk8iaz2j20u011hgsc.jpg");
        girlList.add("http://ww4.sinaimg.cn/large/610dc034gw1fa0ppsw0a7j20u00u0thp.jpg");
        girlList.add("http://ww2.sinaimg.cn/large/7a8aed7bgw1evuryc3xumj20qo0hr41d.jpg");
        girlList.add("http://ww3.sinaimg.cn/large/7a8aed7bjw1ezplg7s8mdj20xc0m8jwf.jpg");
        girlList.add("http://ww2.sinaimg.cn/large/610dc034jw1fa42ktmjh4j20u011hn8g.jpg");
        return girlList;
    }
}
