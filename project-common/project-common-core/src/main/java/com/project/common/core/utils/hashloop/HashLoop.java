package com.project.common.core.utils.hashloop;

import com.project.common.core.utils.StringUtils;

import java.io.File;

/**
 * - 自定义一致性哈希环
 * @author User
 *
 */
public class HashLoop {
	/**
	 * - 0  ~ (2^63 -1)==>>9223372036854775807  正数范围
	 * - -1 ~ (-2^63)==>> -9223372036854775808  负数范围
	 * - 使用两个SIZE的数组表示哈希环
	 * - 哈希环的长度
	 */
	private static final Long SIZE = 9223372036854775807L;
	
	private String hashCode;
	
	public static void main(String[] args) {
		File dir = new File("D:\\2021-12-20数据");
		String[] fileNameArr = dir.list();
		for(int i = 0; i < fileNameArr.length; i++) {
			String target = fileNameArr[i];
			target = StringUtils.substringBeforeLast(target, ".sql");
			System.out.println("DELETE FROM `" + target + "` ;");
		}
	}
}
