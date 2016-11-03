package com.core.util;

import java.util.UUID;

/**
 * 给每个jsp生产独有的Id
 */
public class IdUtil {

	private IdUtil() {
		super();
	}

	/**
	 * 创建一个新的Id(uuid),线程同步
	 */
	public static synchronized String createId() {
		//"-"转换成"A" 使该值可以用做js定义变量
		return "UUID" + UUID.randomUUID().toString().replaceAll("-", "A");
	}

	public static synchronized String createUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "_");
	}

}
