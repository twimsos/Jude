package com.twimsos.judu.model.bean;

import com.twimsos.judu.model.bean.Ad;
import com.twimsos.judu.model.bean.RecommendBean;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static List<RecommendBean> getRecommendList(int page){
        ArrayList<RecommendBean> arr = new ArrayList<>();
        arr.add(new RecommendBean(null,"热门搜索","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里"));
        arr.add(new RecommendBean(null,"手机壁纸","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里"));
        arr.add(new RecommendBean(null,"美女壁纸","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里"));
        arr.add(new RecommendBean(null,"摄影作品","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里"));
        arr.add(new RecommendBean(null,"萌宠","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里"));
        arr.add(new RecommendBean(null,"自然风光","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里"));
        arr.add(new RecommendBean(null,"魅力都市","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里"));
        arr.add(new RecommendBean(null,"时尚街头","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里","http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg","动漫壁纸","海量二次元图片在这里"));
        return arr;
    }

    public static List<Ad> getAdList(){
        ArrayList<Ad> arr = new ArrayList<>();
        arr.add(new Ad("http://pica.nipic.com/2008-01-06/20081611025280_2.jpg","http://www.bilibili.com/topic/v2/1004.html"));
        arr.add(new Ad("http://img02.sogoucdn.com/app/a/100520093/ac75323d6b6de243-cb1a21ced629c7a4-515c992a1d2ac4c008ee5933db98fb5e.jpg","http://www.bilibili.com/topic/1003.html"));
        arr.add(new Ad("http://img01.sogoucdn.com/app/a/100520093/2ad11b094c93197d-fc1961d77e6a39e9-13da45002d603a6471d18dab64390bf7.jpg","http://yoo.bilibili.com/html/activity/cq2015/index.html"));
        arr.add(new Ad("http://img2.pconline.com.cn/pconline/0705/13/1014346_070517movie07.jpg","http://www.bilibili.com/html/activity-acsociety.html"));
        return arr;
    }

}
