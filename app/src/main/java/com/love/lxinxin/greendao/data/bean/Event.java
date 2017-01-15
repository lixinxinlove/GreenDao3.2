package com.love.lxinxin.greendao.data.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lixinxin on 2017/1/15.
 * 邮箱 895330766@qq.com
 */
@Entity
public class Event extends BaseBean {
    @Id
    private long id;
    private String title;
    private String desc;

    private String url;

    @Generated(hash = 1743502813)
    public Event(long id, String title, String desc, String url) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.url = url;
    }

    @Generated(hash = 344677835)
    public Event() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
