package com.twimsos.judu.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.jude.beam.Beam;
import com.jude.utils.JActivityManager;
import com.jude.utils.JFileManager;
import com.jude.utils.JUtils;
import com.lzy.ninegrid.NineGridView;
import com.squareup.picasso.Picasso;
import com.twimsos.judu.R;


public class APP extends Application {
    public  static APP instance;
    public static  APP getInstance(){
        return instance;
    }

    public  static APP context;
    public static  APP getContext(){
        return context;
    }
    @Override
    public void onCreate() {
        context=this;
        instance=this;
        super.onCreate();
        JUtils.initialize(this);
        JUtils.setDebug(false, "heheda");
        JFileManager.getInstance().init(this, Dir.values());
        Beam.init(this);
        Fresco.initialize(this);//使用Fresco图片加载框架
        registerActivityLifecycleCallbacks(JActivityManager.getActivityLifecycleCallbacks());
        NineGridView.setImageLoader(new PicassoImageLoader());
    }
    /** Picasso 加载 */
    private class PicassoImageLoader implements NineGridView.ImageLoader {

        @Override
        public void onDisplayImage(Context context, ImageView imageView, String url) {
            Picasso.with(context).load(url)//
                    .placeholder(R.drawable.ic_default_image)//
                    .error(R.drawable.ic_default_image)//
                    .into(imageView);
        }

        @Override
        public Bitmap getCacheImage(String url) {
            return null;
        }
    }
    //文件目录列表
    public enum Dir{
        Object
    }

}
