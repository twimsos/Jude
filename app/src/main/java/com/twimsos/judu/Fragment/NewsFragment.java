package com.twimsos.judu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.beam.expansion.list.BeamListFragment;
import com.twimsos.judu.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/10.
 */

public class NewsFragment extends Fragment {
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    private String[] News_tabs;
    private HashMap<String, Fragment> fragments;
    private MyFragmentPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        News_tabs = getResources().getStringArray(R.array.News_tab);
        fragments = new HashMap<String, Fragment>();
        View view = inflater.inflate(R.layout.fragment_news, null, false);
        ButterKnife.bind(this, view);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUp(0);
            }
        });
        //初始化视图
        initViews();
        return view;
    }

    private void initViews() {

        adapter = new MyFragmentPagerAdapter(this.getChildFragmentManager());
        mViewPager.setAdapter(adapter);

        for (String tab : News_tabs
                ) {
            mTabLayout.addTab(mTabLayout.newTab().setText(tab));
        }

        //将TabLayout与ViewPager绑定在一起
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
    }

    public void goToUp(int position) {
        if (adapter.getFragment(mViewPager.getCurrentItem()) != null) {
            ((BeamListFragment) adapter.getFragment((mViewPager.getCurrentItem()))).getListView().scrollToPosition(position);
        }
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt("tab", position);
            NewsTabFragment fragment = new NewsTabFragment();
            fragment.setArguments(bundle);
            fragments.put(position + "", fragment);
            return fragment;
        }

        @Override
        public int getCount() {
            return News_tabs.length;
        }

        //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
        @Override
        public CharSequence getPageTitle(int position) {
            return News_tabs[position];
        }

        public Fragment getFragment(int position) {
            return fragments.get(position + "");
        }
    }


}
