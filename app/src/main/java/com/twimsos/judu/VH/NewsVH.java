package com.twimsos.judu.VH;

import android.support.v7.widget.CardView;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;
import com.twimsos.judu.R;
import com.twimsos.judu.model.bean.ContentlistBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsVH extends BaseViewHolder<ContentlistBean> {


    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.desc)
    TextView mDesc;
    @BindView(R.id.nineGrid)
    com.lzy.ninegrid.NineGridView mNineGrid;
    @BindView(R.id.pubDate)
    TextView mPubDate;
    @BindView(R.id.source)
    TextView mSource;
    @BindView(R.id.container)
    LinearLayout mContainer;
    @BindView(R.id.cardView)
    CardView mCardView;
    String uri;

    public NewsVH(ViewGroup parent) {
        super(parent, R.layout.item_news3);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(ContentlistBean data) {
        String Html=data.getHtml();
        this.uri=Html;
        mTitle.setText(data.getTitle());
        mDesc.setText(data.getDesc());
        mPubDate.setText(data.getPubDate());
        mSource.setText(data.getSource());
        ArrayList<ImageInfo> imageInfo = new ArrayList<>();
        List<ContentlistBean.ImageurlsBean> images = data.getImageurls();
        if (images != null) {
            for (ContentlistBean.ImageurlsBean image : images) {
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(image.getUrl());
                info.setBigImageUrl(image.getUrl());
                imageInfo.add(info);
            }
        }
        mNineGrid.setAdapter(new NineGridViewClickAdapter(getContext(), imageInfo));

        if (images != null && images.size() == 1) {
            mNineGrid.setSingleImageRatio(images.get(0).getWidth() * 1.0f / images.get(0).getWidth());
        }

    }
}
