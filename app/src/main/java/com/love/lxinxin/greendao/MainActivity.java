package com.love.lxinxin.greendao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.love.lxinxin.greendao.activity.RxGreenDaoActivity;
import com.love.lxinxin.greendao.data.bean.User;
import com.love.lxinxin.greendao.data.dao.DaoSession;
import com.love.lxinxin.greendao.data.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;

    private Button insert;
    private Button select;
    private Button update;
    private Button delete;

    private Button inserts;
    private Button findAll;


    private Button rx;


    private DaoSession mDaoSession;
    private UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        insert = (Button) findViewById(R.id.insert);
        select = (Button) findViewById(R.id.select);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        inserts = (Button) findViewById(R.id.inserts);
        findAll = (Button) findViewById(R.id.find_add);
        rx = (Button) findViewById(R.id.rx);

        insert.setOnClickListener(this);
        select.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        inserts.setOnClickListener(this);
        findAll.setOnClickListener(this);
        rx.setOnClickListener(this);

        mDaoSession = App.getDaoSession();
        userDao = mDaoSession.getUserDao();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert:
                insert();
                break;
            case R.id.select:
                select();
                break;
            case R.id.update:
                update();
                break;
            case R.id.delete:
                delete();
                break;
            case R.id.inserts:
                inserts();
                break;
            case R.id.find_add:
                findAll();
                break;
            case R.id.rx:
               startActivity(new Intent(this,RxGreenDaoActivity.class));
                break;
        }
    }

    /**
     * 查找Lists
     */
    private void findAll() {

        List<User> list;
        list = userDao.loadAll();
        String str = "";
        if (list != null && list.size() > 0) {
            for (User user : list) {
                str += user.toString() + "\n";
            }
        }
        tv.setText(str);

    }


    /**
     * 批量插入
     */
    private void inserts() {

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i,"lee" + i, "170903434" + i, "address" + i, 1 + i, 1);
            list.add(user);
        }

        userDao.insertInTx(list);
    }

    private void delete() {
        userDao.deleteByKey(1l);

       // userDao.deleteAll(); //删除所有
    }

    private void update() {
        User user = new User(1l, "lee", "17090408824", "三里屯", 24, 1);
        userDao.update(user);
    }


    private void insert() {
        User user = new User(0, "lixinxin", "17090408824", "三里屯", 24, 1);
        userDao.insert(user);
    }

    private void select() {
        List<User> list;
        list = userDao.queryBuilder().where(UserDao.Properties.Id.eq(5)).list();
        if (list != null && list.size() > 0) {
            String name = list.get(0).toString();
            tv.setText(name);
        } else {
            tv.setText("没有查到");
        }
    }
}
