package com.twimsos.judu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.utils.SPUtils;
import com.jude.utils.JUtils;
import com.twimsos.judu.Fragment.NewsFragment;
import com.twimsos.judu.Fragment.PicsFragment;
import com.twimsos.judu.R;
import com.twimsos.judu.app.APP;
import com.twimsos.judu.greendaodemo.greendao.gen.DaoMaster;
import com.twimsos.judu.greendaodemo.greendao.gen.DaoSession;
import com.twimsos.judu.greendaodemo.greendao.gen.RecommendDao;
import com.twimsos.judu.model.bean.Recommend;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.frame_content)
    FrameLayout mFrameContent;
    @BindView(R.id.content_main)
    RelativeLayout mContentMain;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                SPUtils sPUtils = new SPUtils(getApplicationContext(), "db");
                if (sPUtils.getBoolean("db", true)) {
                    initDb();
                    sPUtils.putBoolean("db", false);
                }
            }
        }).run();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_news);
        toolbar.setTitle("新闻");
        toolbar.setTitleTextColor(Color.BLACK);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
    }

    public void setDayNightMode(boolean day) {
        if (day)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
        recreate();
    }

    private void initDb() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(APP.getContext(), "Recommend", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        RecommendDao recommendDao = daoSession.getRecommendDao();
        Recommend recommend = new Recommend(null, "热门搜索", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里");
        recommendDao.insert(recommend);
        Recommend recommend1 = new Recommend(null, "手机壁纸", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里");
        recommendDao.insert(recommend1);
        Recommend recommend2 = new Recommend(null, "美女壁纸", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里");
        recommendDao.insert(recommend2);
        Recommend recommend3 = new Recommend(null, "动漫壁纸", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里");
        recommendDao.insert(recommend3);
        Recommend recommend4 = new Recommend(null, "明星", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里");
        recommendDao.insert(recommend4);
        Recommend recommend5 = new Recommend(null, "影视壁纸", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里");
        recommendDao.insert(recommend5);
        Recommend recommend6 = new Recommend(null, "头像", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里");
        recommendDao.insert(recommend6);
        Recommend recommend7 = new Recommend(null, "老司机", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里", "http://img03.sogoucdn.com/app/a/100520093/19da5b63d13835a0-1f9b8b96c7e772fb-a886e45b6cbee6e529b3fff70afcde9d.jpg", "动漫壁纸", "海量二次元图片在这里");
        recommendDao.insert(recommend7);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }if(id == R.id.action_settings) {
            SPUtils spUtils = new SPUtils(this, "day_night");
            Boolean isday = spUtils.getBoolean("isday", true);
            setDayNightMode(!isday);
            spUtils.putBoolean("isday", !isday);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            toolbar.setTitle("新闻");
            toolbar.setTitleTextColor(Color.BLACK);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
        } else if (id == R.id.nav_pics) {
            toolbar.setTitle("图片");
            toolbar.setTitleTextColor(Color.BLACK);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new PicsFragment()).commit();
        } else if (id == R.id.nav_slideshow) {

        } /*else if (id == R.id.nav_manage) {

        }*/ else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } /*else if (id == R.id.switchView) {
            SPUtils spUtils = new SPUtils(this, "day_night");
            Boolean isday = spUtils.getBoolean("isday", true);
            setDayNightMode(!isday);
            spUtils.putBoolean("isday", !isday);

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }


}
