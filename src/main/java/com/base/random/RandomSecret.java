package com.base.random;

import com.table.code.service.CodeService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class RandomSecret {
	@Autowired
	CodeService securityCodeService;

	/**
	 * 生成随机密码
	 * <p>
	 * 生成的密码的总长度
	 *
	 * @return 密码的字符串
	 */
	public static String genRandomNum() {
		// 26*2个字母+10个数字
		final int leastLength = 10;
		final int maxNum = 67;
		final int maxLength = 20;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', '<', '>', '!', '$', '^'};
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		Random random = new Random();
		int pwd_len = random.nextInt(maxLength) + leastLength;
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为62-1
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}

	/**
	 * 生成5-10位的随机密码
	 *
	 * @return
	 * @author gbq
	 * 2016年5月19日
	 */
	public static String getAccess() {
		// 26*2个字母+10个数字
		final int leastLength = 5;
		final int maxNum = 62;
		final int maxLength = 10;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9'};
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		Random random = new Random();
		int pwd_len = random.nextInt(maxLength) + leastLength;
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为62-1
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}

	/**
	 * 生出6位数字的随机密码
	 *
	 * @return
	 * @author gbq
	 * 2016年5月19日
	 */
	public static String getNum() {
		// 26*2个字母+10个数字
		final int leastLength = 6;
		final int maxNum = 10;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		int pwd_len = leastLength;
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为62-1
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}

	public static void main(String[] args) {
		System.out.println(genRandomNum());//
		System.out.println(getAccess());
		System.out.println(getNum());
	}

}
