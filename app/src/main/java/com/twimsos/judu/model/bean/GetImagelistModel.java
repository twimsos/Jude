package com.twimsos.judu.model.bean;


import com.twimsos.judu.model.bean.NetImage;
import com.twimsos.judu.model.server.ServiceCilent;
import com.twimsos.judu.model.server.SosoSearcher;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class GetImagelistModel {
    public static Observable<NetImage[]> getImageList(final String word, final int page){
        Observable<NetImage[]> observable = ServiceCilent.getService()
                .getImageList(/*"ajax", "result",*/ word, page*48)
                .map(new Func1<SosoSearcher.SosoImage.WallImageResult, NetImage[]>() {
                    @Override
                    public NetImage[] call(SosoSearcher.SosoImage.WallImageResult wallImageResult) {

                        return wallImageResult.getData();
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}
