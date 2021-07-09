package com.zhuyizhuo.example.java.spi.client;

import com.zhuyizhuo.example.java.spi.DataBaseDriver;

import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) {
        ServiceLoader<DataBaseDriver> serviceLoader = ServiceLoader.load(DataBaseDriver.class);

        for (DataBaseDriver dataBaseDriver : serviceLoader){
            System.out.println(dataBaseDriver.connect("test"));
        }
    }
}
