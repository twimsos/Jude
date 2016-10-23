package com.twimsos.judu.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.utils.SizeUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.twimsos.judu.R;
import com.twimsos.judu.activity.RecommendAdapter;
import com.twimsos.judu.app.APP;
import com.twimsos.judu.greendaodemo.greendao.gen.DaoMaster;
import com.twimsos.judu.greendaodemo.greendao.gen.DaoSession;
import com.twimsos.judu.greendaodemo.greendao.gen.RecommendDao;
import com.twimsos.judu.model.bean.Recommend;

import java.util.List;


/**
 * Created by Administrator on 2016/10/13.
 */

public class RecommendFragment extends Fragment {
    private EasyRecyclerView recyclerView;
    private RecommendAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.activity_recyclerview, null);
        recyclerView = (EasyRecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter = new RecommendAdapter(getContext()));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(APP.getContext(), "Recommend", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RecommendDao recommendDao = daoSession.getRecommendDao();
        List<Recommend> RecommendList = recommendDao.queryBuilder()
                .where(RecommendDao.Properties.Id.notEq(999))
                .orderAsc(RecommendDao.Properties.Id)
                .build().list();
        adapter.addAll(RecommendList);
        initHeader();
        initFooter();
        return view;
    }

    private void initFooter() {
        adapter.addFooter(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                TextView tv = new TextView(getContext());
                tv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,SizeUtils.dp2px(getContext(),56)));
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                tv.setText("(-_-)/~~~死宅真是恶心");
                return tv;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
    }

    private void initHeader() {
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                RollPagerView header = new RollPagerView(getContext());
                header.setGravity(2);
                header.setHintView(new ColorPointHintView(getContext(), Color.YELLOW,Color.GRAY));
                header.setHintPadding(0, 0, 0,SizeUtils.dp2px( getContext(),8));
                header.setPlayDelay(4000);
                header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, SizeUtils.dp2px( getContext(),200)));
                header.setAdapter(new BannerAdapter(getContext()));
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
    }
}
