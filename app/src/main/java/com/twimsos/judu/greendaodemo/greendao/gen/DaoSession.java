package com.twimsos.judu.greendaodemo.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.twimsos.judu.model.bean.Recommend;

import com.twimsos.judu.greendaodemo.greendao.gen.RecommendDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig recommendDaoConfig;

    private final RecommendDao recommendDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        recommendDaoConfig = daoConfigMap.get(RecommendDao.class).clone();
        recommendDaoConfig.initIdentityScope(type);

        recommendDao = new RecommendDao(recommendDaoConfig, this);

        registerDao(Recommend.class, recommendDao);
    }
    
    public void clear() {
        recommendDaoConfig.getIdentityScope().clear();
    }

    public RecommendDao getRecommendDao() {
        return recommendDao;
    }

}
