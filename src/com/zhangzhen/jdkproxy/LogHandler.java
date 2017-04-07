package com.zhangzhen.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 日志处理器 实现了jdk invocationHandler的事务处理接口
 */
public class LogHandler implements InvocationHandler {
    //被代理对象传递进来
    private Object target;
    //通过构造方法传参数
    public LogHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * @param proxy  被代理的对象
     * @param method 被代理对象的方法
     * @param args   被代理对象方法的参数
     * @return 返回值就是调用方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行被代理对象的方法前
        System.out.println("开始记录日志。。。");
        //执行被代理对象的方法
        method.invoke(target);
        //执行被代理对象的方法后
        System.out.println("结束日志记录。。。");
        //由于被代理对象的方法没有返回值
        return null;
    }
}
