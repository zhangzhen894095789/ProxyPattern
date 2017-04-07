package com.zhangzhen.proxy.静态代理.聚合方式;

public class CarLogProxy implements Moveable {

	public CarLogProxy(Moveable m) {
		super();
		this.m = m;
	}

	private Moveable m;

	@Override
	public void move() {
		System.out.println("日志开始....");
		m.move();
		System.out.println("日志结束....");
	}

}
