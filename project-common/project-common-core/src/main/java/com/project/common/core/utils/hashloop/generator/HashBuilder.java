package com.project.common.core.utils.hashloop.generator;

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * - 哈希函数生产器
 * @author User
 *
 */
public class HashBuilder {
	/**
	 * - 算法枚举类
	 * @return
	 */
	public static enum Algorithm {
		SHA("SHA"),
		SHA_224("SHA-224"),
		SHA_256("SHA-256"),
		SHA_384("SHA-384"),
		SHA_512("SHA-512"),
		MD2("MD2"),
		MD5("MD5");
		private final String name;
		Algorithm(String name)
	    {
	        this.name = name;
	    }
		public String getName()
	    {
	        return name;
	    }
	}
	/**
	 * - 第一个哈希算法
	 */
	private Algorithm algorithm1 = Algorithm.SHA_256;
	/**
	 * - 第二个哈希算法
	 */
	private Algorithm algorithm2 = Algorithm.MD5;
	/**
	 * - 第二个哈希Digest
	 */
	private MessageDigest hash1;
	
	/**
	 * - 第二个哈希Digest
	 */
	private MessageDigest hash2;
	
	public HashBuilder() {
		try {
			hash1 = MessageDigest.getInstance(algorithm1.getName());
			hash2 = MessageDigest.getInstance(algorithm2.getName());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public HashBuilder(Algorithm algorithm1, Algorithm algorithm2) {
		this.algorithm1 = algorithm1;
		this.algorithm2 = algorithm2;
		try {
			hash1 = MessageDigest.getInstance(algorithm1.getName());
			hash2 = MessageDigest.getInstance(algorithm2.getName());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/**
	 * - 哈希函数1
	 * @param input
	 * @return
	 */
	private BigInteger hashCode1(String input) {
		byte[] bytes = hash1.digest(input.getBytes());
		return new BigInteger(bytes);
	}
	
	/**
	 * - 哈希函数2
	 * @param input
	 * @return
	 */
	private BigInteger hashCode2(String input) {
		byte[] bytes = hash2.digest(input.getBytes());
		return new BigInteger(bytes);
	}
	
	/**
	 * - 使用新的哈希函数
	 * @param input
	 * @param N
	 * @return
	 */
	public String generator(String input, String N) {
		BigInteger one = this.hashCode1(input);
		BigInteger two = this.hashCode2(input);
		one = one.multiply(new BigInteger(N));
		one = one.add(two);
		return DatatypeConverter.printHexBinary(one.toByteArray()).toUpperCase();
	}
	
	/**
	 * - 使用新的哈希函数
	 * @param input
	 * @param N
	 * @return
	 */
	public BigInteger generatorBigInteger(String input, String N) {
		BigInteger one = this.hashCode1(input);
		BigInteger two = this.hashCode2(input);
		one = one.multiply(new BigInteger(N));
		return one.add(two);
	}
}
