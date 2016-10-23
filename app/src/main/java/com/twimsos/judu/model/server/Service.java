package com.twimsos.judu.model.server;


import com.twimsos.judu.model.bean.ImageJoy;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 服务器接口
 */

public interface Service {
    @GET("http://pic.sogou.com/pics?reqType=ajax&reqFrom=result")
    Observable<SosoSearcher.SosoImage.WallImageResult> getImageList(

           /* @Query("reqType") String ajax,
            @Query("reqFrom") String result,*/
           @Query("query") String word,
           @Query("start") int page);

    @GET(API.LAIFU_JOY_IMAGE)
    Observable<ImageJoy[]> getImageJoy();

}
