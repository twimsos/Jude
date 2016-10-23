package com.twimsos.judu.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2016/10/13.
 */
@Entity
public class Recommend {
    @Id
    private Long id;
    private String tip;
    private String imageUrl1;
    private String title1;
    private String content1;
    private String imageUrl2;
    private String title2;
    private String content2;
    public String getContent2() {
        return this.content2;
    }
    public void setContent2(String content2) {
        this.content2 = content2;
    }
    public String getTitle2() {
        return this.title2;
    }
    public void setTitle2(String title2) {
        this.title2 = title2;
    }
    public String getImageUrl2() {
        return this.imageUrl2;
    }
    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }
    public String getContent1() {
        return this.content1;
    }
    public void setContent1(String content1) {
        this.content1 = content1;
    }
    public String getTitle1() {
        return this.title1;
    }
    public void setTitle1(String title1) {
        this.title1 = title1;
    }
    public String getImageUrl1() {
        return this.imageUrl1;
    }
    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }
    public String getTip() {
        return this.tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1584912534)
    public Recommend(Long id, String tip, String imageUrl1, String title1,
            String content1, String imageUrl2, String title2, String content2) {
        this.id = id;
        this.tip = tip;
        this.imageUrl1 = imageUrl1;
        this.title1 = title1;
        this.content1 = content1;
        this.imageUrl2 = imageUrl2;
        this.title2 = title2;
        this.content2 = content2;
    }
    @Generated(hash = 851270828)
    public Recommend() {
    }
}
