package com.twimsos.judu.greendaodemo.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.twimsos.judu.model.bean.Recommend;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "RECOMMEND".
*/
public class RecommendDao extends AbstractDao<Recommend, Long> {

    public static final String TABLENAME = "RECOMMEND";

    /**
     * Properties of entity Recommend.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Tip = new Property(1, String.class, "tip", false, "TIP");
        public final static Property ImageUrl1 = new Property(2, String.class, "imageUrl1", false, "IMAGE_URL1");
        public final static Property Title1 = new Property(3, String.class, "title1", false, "TITLE1");
        public final static Property Content1 = new Property(4, String.class, "content1", false, "CONTENT1");
        public final static Property ImageUrl2 = new Property(5, String.class, "imageUrl2", false, "IMAGE_URL2");
        public final static Property Title2 = new Property(6, String.class, "title2", false, "TITLE2");
        public final static Property Content2 = new Property(7, String.class, "content2", false, "CONTENT2");
    };


    public RecommendDao(DaoConfig config) {
        super(config);
    }
    
    public RecommendDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"RECOMMEND\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"TIP\" TEXT," + // 1: tip
                "\"IMAGE_URL1\" TEXT," + // 2: imageUrl1
                "\"TITLE1\" TEXT," + // 3: title1
                "\"CONTENT1\" TEXT," + // 4: content1
                "\"IMAGE_URL2\" TEXT," + // 5: imageUrl2
                "\"TITLE2\" TEXT," + // 6: title2
                "\"CONTENT2\" TEXT);"); // 7: content2
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"RECOMMEND\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Recommend entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String tip = entity.getTip();
        if (tip != null) {
            stmt.bindString(2, tip);
        }
 
        String imageUrl1 = entity.getImageUrl1();
        if (imageUrl1 != null) {
            stmt.bindString(3, imageUrl1);
        }
 
        String title1 = entity.getTitle1();
        if (title1 != null) {
            stmt.bindString(4, title1);
        }
 
        String content1 = entity.getContent1();
        if (content1 != null) {
            stmt.bindString(5, content1);
        }
 
        String imageUrl2 = entity.getImageUrl2();
        if (imageUrl2 != null) {
            stmt.bindString(6, imageUrl2);
        }
 
        String title2 = entity.getTitle2();
        if (title2 != null) {
            stmt.bindString(7, title2);
        }
 
        String content2 = entity.getContent2();
        if (content2 != null) {
            stmt.bindString(8, content2);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Recommend entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String tip = entity.getTip();
        if (tip != null) {
            stmt.bindString(2, tip);
        }
 
        String imageUrl1 = entity.getImageUrl1();
        if (imageUrl1 != null) {
            stmt.bindString(3, imageUrl1);
        }
 
        String title1 = entity.getTitle1();
        if (title1 != null) {
            stmt.bindString(4, title1);
        }
 
        String content1 = entity.getContent1();
        if (content1 != null) {
            stmt.bindString(5, content1);
        }
 
        String imageUrl2 = entity.getImageUrl2();
        if (imageUrl2 != null) {
            stmt.bindString(6, imageUrl2);
        }
 
        String title2 = entity.getTitle2();
        if (title2 != null) {
            stmt.bindString(7, title2);
        }
 
        String content2 = entity.getContent2();
        if (content2 != null) {
            stmt.bindString(8, content2);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Recommend readEntity(Cursor cursor, int offset) {
        Recommend entity = new Recommend( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // tip
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // imageUrl1
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // title1
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // content1
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // imageUrl2
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // title2
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // content2
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Recommend entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTip(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setImageUrl1(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTitle1(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setContent1(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setImageUrl2(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTitle2(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setContent2(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Recommend entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Recommend entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
