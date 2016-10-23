package com.twimsos.judu.model.server;


import com.twimsos.judu.utils.Utils;

public class API {

    public static final String imgPath= Utils.getSDPath()+"/DownloadPicture";
    //图片搜索接口
    public static final String baseUrl="http://pic.sogou.com";
    //笑话api
    public static final String LAIFU_JOY_IMAGE="http://api.laifudao.com/open/tupian.json";
    public class status{
        public static final int success=200;
        public static final int error=-1;
    }
}
