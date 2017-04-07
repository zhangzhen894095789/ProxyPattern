package com.zhangzhen.proxy.静态代理.聚合方式;

public class Client {

	/**
	 * 测试类
	 */
	public static void main(String[] args) {
		Car car = new Car();
		CarLogProxy clp = new CarLogProxy(car);
		CarTimeProxy ctp = new CarTimeProxy(clp);
		ctp.move();
	}

}
