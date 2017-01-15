package com.love.lxinxin.greendao.data.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by lixinxin on 2017/1/15.
 * 邮箱 895330766@qq.com
 */

@Entity
public class User extends BaseBean {

    @Id(autoincrement = true)
    private long id;
    private String name;
    private String phone;
    private String address;
    private int sex;
    private int age;

    @Generated(hash = 1215254593)
    public User(long id, String name, String phone, String address, int sex,
            int age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.sex = sex;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
