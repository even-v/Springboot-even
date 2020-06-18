//package cn.even.kingsum.origin.util;
//import java.io.UnsupportedEncodingException;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.springframework.util.DigestUtils;
//
//import com.kingsum.platform.common.core.Constants;
//
//public class SecurityUtil {
//
//	public static String genMd5Password(String salt,String password){
//
//		 byte[] bytes = (salt + "##" + password).getBytes();
//		 //String passwordMd5 = new String(DigestUtils.md5Digest(bytes));
//	     String passwordMd5 = DigestUtils.md5DigestAsHex(bytes);
//		 return passwordMd5;
//	}
//
//
//	public static String encodeRememberToken(String account,String pwdmd5){
//		String data = String.format("%s&&%s&&remember", new Object[]{account,pwdmd5});
//		String token = encrypt(data, Constants.ENCODE_DES_KEY, "DES");
//		return token;
//	}
//	public static String encodeRememberToken(String account,String pwdmd5,String jsessionId){
//		String data = String.format("%s&&%s&&%s&&remember", new Object[]{account,pwdmd5,jsessionId});
//		String token = encrypt(data, Constants.ENCODE_DES_KEY, "DES");
//		return token;
//	}
//
//	public static String[] decodeRememberToken(String token){
//		String decodeStr = decrypt(token, Constants.ENCODE_DES_KEY, "DES");
//		String[] strArr = decodeStr.split("\\&\\&");
//		return strArr;
//	}
//
//
//	/**
//	 * 对数据源进行加密
//	 *
//	 * @param src   数据源
//	 * @param key   密钥
//	 * @param name 算法的名称
//	 * @return 返回加密后的数据
//	 * @throws Exception  异常
//	 */
//	public static byte[] encrypt(byte[] src, byte[] key, String name)
//			throws Exception {
//
//		SecretKeySpec securekey = new SecretKeySpec(key, name);
//		// Cipher对象实际完成加密操作
//		Cipher cipher = Cipher.getInstance(name);
//		// 用密匙初始化Cipher对象
//		cipher.init(Cipher.ENCRYPT_MODE, securekey);
//		// 现在，获取数据并加密
//		// 正式执行加密操作
//		return cipher.doFinal(src);
//	}
//
//	/**
//	 * 对加密的数据源进行解密
//	 *
//	 * @param src  数据源
//	 * @param key  密钥
//	 * @param name 算法的名称
//	 * @return 返回解密后的原始数据
//	 * @throws Exception 异常
//	 */
//	public static byte[] decrypt(byte[] src, byte[] key, String name)
//			throws Exception {
//
//		SecretKeySpec securekey = new SecretKeySpec(key, name);
//		// Cipher对象实际完成解密操作
//		Cipher cipher = Cipher.getInstance(name);
//		// 用密匙初始化Cipher对象
//		cipher.init(Cipher.DECRYPT_MODE, securekey);
//		// 现在，获取数据并解密
//		// 正式执行解密操作
//		return cipher.doFinal(src);
//	}
//
//	/**
//	 * 二行制转字符串
//	 * @param bytes 二进制数组
//	 * @return 字符串
//	 */
//	public static String bytes2HexString(byte[] bytes) {
//		String hs = null;
//		if (bytes != null) {
//			final int size = bytes.length;
//			if (size > 0) {
//				StringBuilder sb = new StringBuilder();
//				for (int i = 0; i < size; i++) {
//					String tmp = (java.lang.Integer.toHexString(bytes[i] & 0XFF));
//					if (tmp.length() == 1) {
//						sb.append("0" + tmp);
//					} else {
//						sb.append(tmp);
//					}
//				}
//				hs = sb.toString().toUpperCase();
//			}
//		}
//		return hs;
//	}
//
//	public static byte[] hex2byte(byte[] b) {
//		if ((b.length % 2) != 0) {
//			return null;
//		}
//		byte[] b2 = new byte[b.length / 2];
//		for (int n = 0; n < b.length; n += 2) {
//			String item = new String(b, n, 2);
//			b2[n / 2] = (byte) Integer.parseInt(item, 16);
//		}
//		return b2;
//	}
//
//	/**
//	 * 十六进位格式字符串转二进制流。
//	 *
//	 * @param hs 十六进位格式字符串
//	 * @return byte[]
//	 */
//	public static byte[] hexString2Bytes (String hs) {
//		byte[] bytes = null;
//		if (hs != null) {
//			final int size = (hs.length()) / 2;
//			if (size > 0) {
//				bytes = new byte[size];
//				for (int i = 0; i < size; i++) {
//					String hsByte = hs.substring(i * 2, i * 2 + 2);
//					byte b = 0;
//					try {
//						b = (byte) (Integer.parseInt(hsByte, 16));
//					} catch (java.lang.NumberFormatException e) {
//						b = 0;
//					}
//					bytes[i] = b;
//				}
//			}
//		}
//		return bytes;
//	}
//
//	/**
//	 * 字符串解密
//	 *
//	 * @param data  字符串加密数据
//	 * @param key   密钥
//	 * @param name  算法名称
//	 * @return 解密字符串
//	 */
//	public static String decrypt(String data, String key, String name) {
//		try {
//			return new String(decrypt(hex2byte(data.getBytes()),
//					string2Bytes(key), name));
//		} catch (Exception e) {
//
//		}
//		return null;
//	}
//
//	/**
//	 * 字符串解密
//	 *
//	 * @param data	符串加密数据
//	 * @param key   密钥
//	 * @param name  算法名称
//	 * @return  解密字符串
//	 */
//	public static String decrypt(String data, byte[] key, String name) {
//		try {
//			return new String(decrypt(hex2byte(data.getBytes()),key, name));
//		} catch (Exception e) {
//
//		}
//		return null;
//	}
//
//	/**
//	 * 把字符串转化成 Unicode Bytes.
//	 *
//	 * @param s 字符串
//	 * @return byte[]
//	 */
//	public static byte [] string2Bytes(String s) {
//		byte[] bytes = null;
//		if (s != null) {
//			try {
//				bytes = s.getBytes("utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
//		return bytes;
//	}
//
//	/**
//	 * 根据 Unicode Bytes 构造字符串.
//	 *
//	 * @param bytes byte[]
//	 * @return String
//	 */
//	public static String bytes2String (byte[] bytes) {
//		String s = null;
//		if (bytes != null) {
//			try {
//				s = new String(bytes, "utf-8");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return s;
//	}
//
//
//	/**
//	 * 字符串加密
//	 *
//	 * @param data 字符串数据
//	 * @param key  密钥
//	 * @param name 算法名称
//	 * @return String
//	 */
//	public static String encrypt(String data, byte[] key, String name) {
//		try {
//			return bytes2HexString(encrypt(data.getBytes(), key, name));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	/**
//	 * 字符串加密
//	 *
//	 * @param data  字符串数据
//	 * @param key   密钥
//	 * @param name  算法名称
//	 * @return String
//	 */
//	public static String encrypt(String data, String key, String name) {
//		try {
//			return bytes2HexString(encrypt(data.getBytes(), string2Bytes(key), name));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public static void main(String[] args) {
//		String token = "E8FEF1C87A0D04BC7D25BA743BAF078C2A8362C664AA6BC23E6433828D94F7051847A32167EB57ADEF19C6822510C4659E7686386FDED21D1B8C9A19AC0506B2F23549369A3A7CA778D746C9E780778EFC7E1019A5F3BD19";
//		String decodeStr = decrypt(token, Constants.ENCODE_DES_KEY, "DES");
//		String[] strArr = decodeStr.split("\\&\\&");
//		System.out.println(genMd5Password("13711111111","123456"));
//	}
//
//}
