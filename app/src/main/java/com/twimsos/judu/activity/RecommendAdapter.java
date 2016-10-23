package com.twimsos.judu.activity;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.twimsos.judu.VH.RecommendViewHolder;
import com.twimsos.judu.model.bean.Recommend;

/**
 * Created by Administrator on 2016/10/13.
 */

public class RecommendAdapter extends RecyclerArrayAdapter<Recommend> {
    public RecommendAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendViewHolder(parent);
    }
}
