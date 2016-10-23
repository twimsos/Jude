package com.twimsos.judu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jude.utils.JUtils;
import com.twimsos.judu.config.MySql;


public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, MySql.DATABASE_NAME, null, MySql.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        JUtils.Log("table onCreate");
        db.execSQL(MySql.creatDownloadTable);
        db.execSQL(MySql.createCollectTable);
        db.execSQL(MySql.createRecommendTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        JUtils.Log("onUpgrade");
        db.execSQL(MySql.createRecommendTable);
    }
}
