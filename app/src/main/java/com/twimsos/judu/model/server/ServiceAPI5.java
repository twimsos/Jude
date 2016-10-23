package com.twimsos.judu.model.server;


import com.twimsos.judu.model.bean.NewsPage;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ServiceAPI5 {
    String URL="http://apis.baidu.com/showapi_open_bus/channel_news/";
    @GET("search_news?")
    Observable<NewsPage> getNewsPage(@Query("channelName") String channelName, @Query("page") String page);
}