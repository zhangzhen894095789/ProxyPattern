package com.zhangzhen.jdkproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 测试类jdk 动态代理
 */
public class Client {
    @Test
    /**
     * 实现了car 的动态代理
     */
    public void testCarProxy() {
        //创建被代理类的对象，首先这个对象实现了某一个或多个接口
        Car car = new Car();
        /**使用Proxy创建该类的代理对象
         * loader 被代理类的类加载器
         * interfaces 被代理类实现的接口
         * h InvocationHandler
         */
        ClassLoader loader = car.getClass().getClassLoader();
        Class<?>[] interfaces = car.getClass().getInterfaces();
        InvocationHandler h = new LogHandler(car);
        //获取实现了同一接口的类的代理对象
        Moveable m = (Moveable) Proxy.newProxyInstance(loader, interfaces, h);
        //调用了创建的car的代理对象，car方法调用前后动态代理类执行了
        m.move();
    }

    @Test
    /**
     * 同样增加一个与car 类似的ship也具有moveable接口的功能，
     * 只需要将ship实现了moveable接口的对象通过Proxy对象创建代理对象
     * 然后使用相同的handler就能动态的实现handler中的业务
     */
    public void testShipProxy(){
        Ship ship = new Ship();

        Moveable m = (Moveable) Proxy.newProxyInstance(ship.getClass().getClassLoader(), ship.getClass().getInterfaces(), new LogHandler(ship));

        m.move();
    }
}
