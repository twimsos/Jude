package com.twimsos.judu.activity;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.utils.JUtils;
import com.twimsos.judu.R;
import com.twimsos.judu.library.EasyImageLoader;
import com.twimsos.judu.model.bean.NetImage;
import com.twimsos.judu.widght.PinchImageView;

import java.util.ArrayList;


public class ShowLargeImgAdapter extends PagerAdapter implements View.OnClickListener {
    private PinchImageView pinchImageView;
    private ArrayList<NetImage> netImages;
    private Activity context;
    private LayoutInflater inflater;
    private int screenHeight;
    private int screenWidth;
    private View view;
    ViewGroup.LayoutParams mLayoutParams;

    public ShowLargeImgAdapter(ArrayList<NetImage> netImages, Activity context) {
        this.netImages = netImages;
        this.context = context;
        screenHeight = JUtils.getScreenHeight();
        screenWidth = JUtils.getScreenWidth();
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return netImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //  super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        view = inflater.inflate(R.layout.item_large_img, null);

        pinchImageView = (PinchImageView) view.findViewById(R.id.photoView);
        pinchImageView.setOnClickListener(this);
        //加载图片
        EasyImageLoader.getInstance(context).bindBitmap(netImages.get(position).getLargeImg(), pinchImageView, new EasyImageLoader.BindBitmapErrorCallBack() {
            @Override
            public void onError(ImageView imgView) {
                JUtils.Log("bindBitmap onError");
                EasyImageLoader.getInstance(context).bindBitmap(netImages.get(position).getThumbImg(), imgView);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void onClick(View v) {
        context.finish();
    }
}
