package com.zhuyizhuo.example.java.spi.mysql;


import com.zhuyizhuo.example.java.spi.DataBaseDriver;

/**
 * Created by yizhuo on 2018/6/26.
 */
public class MysqlDriver implements DataBaseDriver {

    public String connect(String s) {
        return "MysqlDriver connect mysql : " + s;
    }

}
