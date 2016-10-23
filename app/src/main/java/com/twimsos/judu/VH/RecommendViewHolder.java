package com.twimsos.judu.VH;

import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.twimsos.judu.R;
import com.twimsos.judu.model.bean.Recommend;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecommendViewHolder extends BaseViewHolder<Recommend> {


    @BindView(R.id.recommend_tip)
    TextView mRecommendTip;
    @BindView(R.id.recommend_btn)
    Button mRecommendBtn;
    @BindView(R.id.recomend_img1)
    SimpleDraweeView mRecomendImg1;
    @BindView(R.id.recommend_title1)
    TextView mRecommendTitle1;
    @BindView(R.id.recommend_content1)
    TextView mRecommendContent1;
    @BindView(R.id.recommend_cardview1)
    CardView mRecommendCardview1;
    @BindView(R.id.recomend_img2)
    SimpleDraweeView mRecomendImg2;
    @BindView(R.id.recommend_title2)
    TextView mRecommendTitle2;
    @BindView(R.id.recommend_content2)
    TextView mRecommendContent2;
    @BindView(R.id.recommend_cardview2)
    CardView mRecommendCardview2;

    public RecommendViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_recommend);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(Recommend data) {
        mRecommendTip.setText(data.getTip());
        mRecomendImg1.setImageURI(Uri.parse(data.getImageUrl1()));
        mRecomendImg2.setImageURI(Uri.parse(data.getImageUrl2()));
        mRecommendContent1.setText(data.getContent1());
        mRecommendContent2.setText(data.getContent2());
        mRecommendTitle1.setText(data.getTitle1());
        mRecommendTitle2.setText(data.getTitle2());
    }
}
