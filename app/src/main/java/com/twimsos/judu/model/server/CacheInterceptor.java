package com.twimsos.judu.model.server;

import com.jude.utils.JUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor{
    /*@Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        String cacheControl = request.cacheControl().toString();
        if (TextUtils.isEmpty(cacheControl)) {
            cacheControl = "public, max-age=60";
        }
        return response.newBuilder()
                .header("Cache-Control", cacheControl)
                .removeHeader("Pragma")
                .build();
    }*/
  @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!JUtils.isNetWorkAvilable()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response response = chain.proceed(request);

        if (JUtils.isNetWorkAvilable()) {
            int maxAge = 0 * 60; // 有网络时 设置缓存超时时间0个小时
            JUtils.Log("has network maxAge="+maxAge);
            response.newBuilder()
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .build();
        } else {
            JUtils.Log("network error");
            int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
            JUtils.Log("has maxStale="+maxStale);
            response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .removeHeader("Pragma")
                    .build();
            JUtils.Log("response build maxStale="+maxStale);
        }
        return response;
    }
}
