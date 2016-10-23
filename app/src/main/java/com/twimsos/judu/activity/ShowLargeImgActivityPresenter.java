package com.twimsos.judu.activity;

import android.content.Context;

import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;
import com.twimsos.judu.library.EasyImageLoader;
import com.twimsos.judu.model.bean.NetImage;
import com.twimsos.judu.model.bean.SaveBitmapModel;
import com.twimsos.judu.model.bean.SqlModel;
import com.twimsos.judu.model.bean.WrapperModel;
import com.twimsos.judu.model.server.API;
import com.twimsos.judu.utils.Utils;
import com.twimsos.judu.widght.PinchImageViewPager;

import java.util.ArrayList;

import rx.functions.Action1;


public class ShowLargeImgActivityPresenter extends Presenter<ShowLargeImgActivity> implements PinchImageViewPager.OnPageChangeListener {
    private NetImage netImage;
    int currentPosition = 0;
    private ArrayList<NetImage> netImages;
    ShowLargeImgAdapter adapter;
    /**
     * -1 初始化
     * 0 下载图片
     * 1 分享图片
     * 3 设为壁纸
     * 4 设为锁屏
     */
    private int state = -1;

    @Override
    protected void onCreateView(ShowLargeImgActivity view) {
        super.onCreateView(view);
        netImages = (ArrayList<NetImage>) view.getIntent().getSerializableExtra("netImages");
        currentPosition = view.getIntent().getIntExtra("position", 0);
        adapter = new ShowLargeImgAdapter(netImages, getView());
        getView().getViewPager().setAdapter(adapter);
        getView().getViewPager().setCurrentItem(currentPosition);
        getView().getViewPager().setOnPageChangeListener(this);
        getView().getPg_tv().setText((currentPosition + 1) + "/" + netImages.size());
    }

    public void savePicture() {
        state = 0;
        downloadBitmap(getView(), netImages.get(currentPosition).getLargeImg(), netImages.get(currentPosition).getThumbImg());
    }

    public void collectPicture() {
        SqlModel.addCollectImg(getView(), netImages.get(currentPosition));

    }

    public void requestCollectPicture() {
        SqlModel.deleteCollectImgByUrl(getView(), netImages.get(currentPosition).getLargeImg());
        getView().setResult(100);
        getView().finish();

    }

    public void sharePicture() {
        state = 1;
        downloadBitmap(getView(), netImages.get(currentPosition).getLargeImg());
    }

    public void setWallWrapper() {
        state = 3;
        downloadBitmap(getView(), netImages.get(currentPosition).getLargeImg());
    }

    public void setLockWrapper() {
        state = 4;
        downloadBitmap(getView(), netImages.get(currentPosition).getLargeImg());
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        getView().getPg_tv().setText((position + 1) + "/" + netImages.size());
        currentPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public int getPosition() {
        return currentPosition;
    }

    public void downloadBitmap(final Context context, String url, String smallUrl) {
        EasyImageLoader.getInstance(context).getBitmap(url, bitmap -> {
            if (bitmap != null) {
                if (state == 0 || state == 1) {
                    SaveBitmapModel.getSaveBitmapObservable(bitmap).subscribe(saveSubscriber);
                } else if (state == 3) {
                    //设置桌面壁纸
                    WrapperModel.getSetWallWrapperObservable(bitmap, context).subscribe(callbackSubscriber);

                } else if (state == 4) {
                    //设置锁屏壁纸
                    WrapperModel.getSetLockWrapperObservable(bitmap, context).subscribe(callbackSubscriber);
                }
            } else {
                JUtils.Log("高清图下载失败，转去下载缩略图");
                downloadBitmap(context, smallUrl);
            }
        });
    }

    public void downloadBitmap(final Context context, String url) {
        EasyImageLoader.getInstance(context).getBitmap(url, bitmap -> {
            if (bitmap != null) {
                if (state == 0 || state == 1) {
                    SaveBitmapModel.getSaveBitmapObservable(bitmap).subscribe(saveSubscriber);
                } else if (state == 3) {
                    //设置桌面壁纸
                    WrapperModel.getSetWallWrapperObservable(bitmap, context).subscribe(callbackSubscriber);

                } else if (state == 4) {
                    //设置锁屏壁纸
                    WrapperModel.getSetLockWrapperObservable(bitmap, context).subscribe(callbackSubscriber);
                }
            } else {
                JUtils.Toast("下载图片失败");
            }
        });

    }

    //保存图片后的观察者
    Action1<String> saveSubscriber = new Action1<String>() {
        @Override
        public void call(String path) {

            if (!path.equals(API.status.error + "")) {
                if (state == 0) {
                    JUtils.Log("path: " + path);
                    JUtils.ToastLong("图片已保存至：" + path);
                    //保存到数据库
                    SqlModel.addDownloadImg(getView(), netImages.get(currentPosition), path);
                }
                if (state == 1) {
                    // startShareImg(path);
                    Utils.startShareImg(path, getView());
                }
            } else {
                JUtils.Toast("未获取到读写sd卡权限！无法保存图片");
            }
        }
    };
    //设置事件发生后的消费该事件的观察者
    Action1<Integer> callbackSubscriber = new Action1<Integer>() {
        @Override
        public void call(Integer integer) {
            if (integer.intValue() == API.status.success) {
                JUtils.Toast("设置成功！");
            } else {
                JUtils.Toast("设置失败...");
            }
        }
    };

}
