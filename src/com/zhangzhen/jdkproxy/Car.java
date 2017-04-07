package com.zhangzhen.jdkproxy;

/**
 * 被代理的对象之 汽车
 */
public class Car implements Moveable{
    @Override
    public void move() {
        System.out.println("汽车行驶中。。。");
    }
}
