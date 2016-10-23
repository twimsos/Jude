package com.twimsos.judu.Fragment;


import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.beam.expansion.list.ListConfig;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.twimsos.judu.VH.NetImageListViewHolder;
import com.twimsos.judu.R;
import com.twimsos.judu.model.bean.NetImage;
import com.twimsos.judu.presenter.NetImgListPresenter;
@RequiresPresenter(NetImgListPresenter.class)
public class NetImgFragment extends BeamListFragment<NetImgListPresenter,NetImage>{

    @Override
    public BaseViewHolder<NetImage> getViewHolder(ViewGroup parent, int viewType) {
        return new NetImageListViewHolder(parent);
    }

    @Override
    public ListConfig getConfig() {
        return super.getConfig()
                .setRefreshAble(true)
                .setNoMoreAble(true)
                .setLoadmoreAble(true)
                .setErrorAble(true)
                .setContainerErrorAble(true)
                .setContainerErrorRes(R.layout.view_net_error)
                .setContainerProgressRes(R.layout.page_progress)
                .setLoadMoreRes(R.layout.page_loadmore);
    }
}
