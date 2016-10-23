package com.twimsos.judu.Fragment;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.twimsos.judu.VH.NewsVH;
import com.twimsos.judu.model.bean.ContentlistBean;
import com.twimsos.judu.presenter.NewsTabPresenter;

/**
 * Created by Administrator on 2016/10/11.
 */
@RequiresPresenter(NewsTabPresenter.class)
public class NewsTabFragment extends BeamListFragment<NewsTabPresenter,ContentlistBean>{
    @Override
    public BaseViewHolder<ContentlistBean> getViewHolder(ViewGroup parent, int viewType) {
        return new NewsVH(parent);
    }
    @Override
    public ListConfig getConfig() {
        return super.getConfig()
                .setLoadmoreAble(true)
                .setRefreshAble(true)
                .setNoMoreAble(true)
                .setErrorAble(true)
                .setErrorTouchToResumeAble(true);
    }
}
