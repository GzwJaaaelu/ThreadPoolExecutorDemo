package com.jaaaelu.gzw.threadpoolexecutordemo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jaaaelu.gzw.threadpoolexecutordemo.R;
import com.jaaaelu.gzw.threadpoolexecutordemo.ui.activity.UserThreadToolActivity;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2017/1/8.
 */

public class ImageLoadAdapter extends RecyclerView.Adapter<ImageLoadAdapter.ImageLoadHolder> {
    private WeakReference<UserThreadToolActivity> mActivityRef;         //  Activity的弱引用
    private LayoutInflater mLayoutInflater;

    public ImageLoadAdapter(UserThreadToolActivity activity) {
        mActivityRef = new WeakReference<>(activity);
        if (mActivityRef.get() != null) {
            mLayoutInflater = mActivityRef.get().getLayoutInflater();
        }
    }

    @Override
    public ImageLoadHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_load_image, parent, false);
        return new ImageLoadHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageLoadHolder holder, int position) {
        holder.loadImage(position);
    }

    @Override
    public int getItemCount() {
        if (mActivityRef.get() != null) {
            return mActivityRef.get().mImageUrl.size();
        } else {
            return 0;
        }
    }

    class ImageLoadHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_girl_0)
        SimpleDraweeView girl0;
        @BindView(R.id.iv_girl_1)
        SimpleDraweeView girl1;
        @BindView(R.id.iv_girl_2)
        SimpleDraweeView girl2;

        public ImageLoadHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            setLayoutParam(girl0);
            setLayoutParam(girl1);
            setLayoutParam(girl2);
        }

        /**
         * 动态计算View宽度
         *
         * @param iv
         */
        private void setLayoutParam(ImageView iv) {
            if (mActivityRef.get() != null) {
                DisplayMetrics dm = mActivityRef.get().getApplicationContext().getResources().getDisplayMetrics();
                int screenWidth = dm.widthPixels;
                ViewGroup.LayoutParams lp = iv.getLayoutParams();
                lp.width = lp.height = screenWidth / 3;
            }
        }

        /**
         * 执行加载图片任务
         * @param position
         */
        public void loadImage(int position) {
            if (mActivityRef.get() != null) {
                mActivityRef.get().mExecutorService.execute(new ImageTask(girl0, (position + 1) * 1));
                mActivityRef.get().mExecutorService.execute(new ImageTask(girl1, (position + 1) * 2));
                mActivityRef.get().mExecutorService.execute(new ImageTask(girl2, (position + 1) * 3));
                girl0.setImageURI("");
                girl1.setImageURI("");
                girl2.setImageURI("");
            }
        }


    }

    class ImageTask implements Runnable {
        private WeakReference<SimpleDraweeView> image;
        private int position;

        public ImageTask(SimpleDraweeView image, int position) {
            this.image = new WeakReference<>(image);
            this.position = position;
        }

        @Override
        public void run() {
            // 假装很耗时
            for (int i = 0; i < 30000; i++) {
                for (int j = 0; j < 10000; j++) {
                    // empty
                }
            }

            if (mActivityRef.get() != null && image.get() != null) {
                mActivityRef.get().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        image.get().setImageURI(mActivityRef.get().mImageUrl.get(position % 15));
                    }
                });
            }
        }
    }
}
