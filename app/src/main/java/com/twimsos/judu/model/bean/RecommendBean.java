package com.twimsos.judu.model.bean;

/**
 * Created by Administrator on 2016/10/13.
 */

public class RecommendBean {
    private Long id;
    private String tip;
    private String imageUrl1;
    private String title1;
    private String content1;
    private String imageUrl2;
    private String title2;
    private String content2;

    public RecommendBean(Long id, String content2, String tip, String imageUrl1, String title1, String content1, String imageUrl2, String title2) {
        this.id = id;
        this.content2 = content2;
        this.tip = tip;
        this.imageUrl1 = imageUrl1;
        this.title1 = title1;
        this.content1 = content1;
        this.imageUrl2 = imageUrl2;
        this.title2 = title2;
    }

    @Override
    public String toString() {
        return "RecommendBean{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                ", imageUrl1='" + imageUrl1 + '\'' +
                ", title1='" + title1 + '\'' +
                ", content1='" + content1 + '\'' +
                ", imageUrl2='" + imageUrl2 + '\'' +
                ", title2='" + title2 + '\'' +
                ", content2='" + content2 + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }
}
