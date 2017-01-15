package com.love.lxinxin.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.love.lxinxin.greendao.data.dao.DaoMaster;
import com.love.lxinxin.greendao.data.dao.DaoSession;

/**
 * Created by lixinxin on 2017/1/15.
 * 邮箱 895330766@qq.com
 */

public class App extends Application {

    private static DaoSession daoSession;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;

    @Override
    public void onCreate() {
        super.onCreate();
        //数据库的配置
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "my_db", null);
        db = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
