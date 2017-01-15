package com.love.lxinxin.greendao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.love.lxinxin.greendao.App;
import com.love.lxinxin.greendao.R;
import com.love.lxinxin.greendao.data.bean.User;
import com.love.lxinxin.greendao.data.dao.DaoSession;

import org.greenrobot.greendao.rx.RxDao;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class RxGreenDaoActivity extends AppCompatActivity {


    private TextView tv;

    private DaoSession mDaoSession;
    private RxDao<User, Long> userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_green_dao);
        tv = (TextView) findViewById(R.id.tv);
        mDaoSession = App.getDaoSession();
        userDao = mDaoSession.getUserDao().rx();
    }

    public void onClick(View v) {

        userDao.loadAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<User>>() {
            @Override
            public void call(List<User> users) {
                    tv.setText(users.get(0).toString());
            }
        });

        User user=new User(100,"lixnixn","address","123232323",1,34);

        userDao.insert(user).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<User>() {
            @Override
            public void call(User user) {

            }
        });

    }
}
