package com.twimsos.judu.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.twimsos.judu.Fragment.NewsTabFragment;
import com.twimsos.judu.R;
import com.twimsos.judu.activity.WebActivity;
import com.twimsos.judu.model.bean.ContentlistBean;
import com.twimsos.judu.model.bean.NewsPage;
import com.twimsos.judu.model.server.DaggerServiceModelComponent5;
import com.twimsos.judu.model.server.SchedulerTransform;
import com.twimsos.judu.model.server.ServiceAPI5;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;


public class NewsTabPresenter extends BeamListFragmentPresenter<NewsTabFragment,ContentlistBean> implements RecyclerArrayAdapter.OnItemClickListener{
    @Inject
    ServiceAPI5 mServer;

    private ArrayList<ContentlistBean> mList;
    private String tab;

    @Override
    protected void onCreate(NewsTabFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        tab = view.getResources().getStringArray(R.array.search_News_tab)[view.getArguments().getInt("tab")];
        DaggerServiceModelComponent5.builder().build().injectNewsPresenter(this);
        onRefresh();
    }

    @Override
    protected void onCreateView(@NonNull NewsTabFragment view) {
        super.onCreateView(view);
        getAdapter().setOnItemClickListener(NewsTabPresenter.this);
    }

    @Override
    public void onRefresh() {
        mServer.getNewsPage(tab,"1")
                .compose(new SchedulerTransform<>())
                .map(NewsPage::getShowapi_res_body)
                .map(NewsPage.ShowapiResBodyBean::getPagebean)
                .map(NewsPage.ShowapiResBodyBean.PagebeanBean::getContentlist)
                .doOnNext(new Action1<List<ContentlistBean>>() {
                    @Override
                    public void call(List<ContentlistBean> news) {
                        NewsTabPresenter.this.mList=new ArrayList<ContentlistBean>(news);
                    }
                })
                .doAfterTerminate(()-> setCurPage(2))
                .unsafeSubscribe(getRefreshSubscriber());
    }

    @Override
    public void onLoadMore() {
        mServer.getNewsPage(tab,""+getCurPage())
                .compose(new SchedulerTransform<>())
                .map(NewsPage::getShowapi_res_body)
                .map(NewsPage.ShowapiResBodyBean::getPagebean)
                .map(NewsPage.ShowapiResBodyBean.PagebeanBean::getContentlist)
                .doOnNext(new Action1<List<ContentlistBean>>() {
                    @Override
                    public void call(List<ContentlistBean> news) {
                        NewsTabPresenter.this.mList.addAll(news);
                    }
                })
                .unsafeSubscribe(getRefreshSubscriber());
    }

    @Override
    public void onItemClick(int position) {
        ContentlistBean data=mList.get(position);
        Intent intent = new Intent();
        intent.putExtra("Url", data.getLink());
        intent.setClass(getView().getContext(), WebActivity.class);
        getView().getActivity().startActivityForResult(intent, 100);
    }
}
